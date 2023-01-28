package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseBehaviour;
import edu.uoc.pacman.model.entities.characters.pacman.Pacman;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

import java.util.HashMap;

import static edu.uoc.pacman.model.entities.characters.ghosts.Behaviour.*;
import static edu.uoc.pacman.model.entities.characters.pacman.State.NORMAL;
import static edu.uoc.pacman.model.utils.Direction.UP;

/**
 * Represents an abstract Ghost class which defines a specific Character entity.
 */
public abstract class Ghost extends Character implements Scorable {
    private Behaviour behaviour;
    protected ChaseBehaviour chaseBehaviour;
    private Position scatterPosition;

    protected Ghost(Position startPosition, Position scatterPosition, Direction direction, Behaviour behaviour, Sprite sprite, Level level) {
        super(startPosition, direction, sprite, level);
        this.behaviour = behaviour;
        setScatterPosition(scatterPosition);
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public Position getScatterPosition() {
        return scatterPosition;
    }

    /**
     * Returns the target position of the ghosts according to its current behaviour.
     * CHASE: the value returned by ChaseBehaviour's getChasePosition.
     * SCATTER, FRIGHTENED: the value returned by getScatterPosition.
     * Other values: null.
     * @return The target position according to the ghost's current behaviour.
     */
    private Position getTargetPosition() {
        if (this.getBehaviour().equals(CHASE)) {
            return this.chaseBehaviour.getChasePosition(this);
        } else if (this.getBehaviour().equals(SCATTER) || this.getBehaviour().equals(FRIGHTENED)) {
            return getScatterPosition();
        }
        return null;
    }

    /**
     * Checks if the ghost hits Pacman, i.e. if ghost's position and Pac man's position are the same.
     * If both positions are identical, then the ghost must be killed when its behaviour is FRIGHTENED. Otherwise,
     * if the ghost's behaviour is different to INACTIVE and Pac man's state is NORMAL, then pacman must be killed.
     * When either the ghost or Pacman are killed, then this method returns true. Otherwise, false.
     * @return true when the ghost and Pacman collide as long as the ghost is not INACTIVE. Otherwise, it returns false.
     */
    @Override
    public boolean hit() {
        Pacman pacman = getLevel().getPacman();
        if (!(getBehaviour() == INACTIVE) && getPosition().equals(pacman.getPosition())) {
            switch (getBehaviour()) {
                case CHASE, SCATTER -> {
                    if (pacman.getState() == NORMAL) {
                        pacman.kill();          // Ghost kills Pacman
                        return true;
                    }
                    return true;               // If pacman it's not in normal or eater mode, it's invincible
                }
                case FRIGHTENED -> {
                    kill();             // If ghost it's frightened, it means Pacman it's in eater mode. Kill the ghost
                    return true;
                }
            }
        }
        return false;           // If any other condition return false
    }

    /**
     * Kills the ghost and add its points to the level's score.
     */
    public void kill() {
        super.kill();
        setBehaviour(INACTIVE);
        getLevel().addPoints(this.getPoints());
    }

    /**
     * Moves the ghost according to the game rules.
     * If the targetPosition is null (e.g. because ghost's behavior is INACTIVE), then the ghost does not move.
     * In order to decide how to reach the targetPosition, i.e. in which direction the ghost should move, this method
     * calculates the euclidean distance of the 4 potential positions and choose the one with the smallest distance.
     * The new position is the one that meets the all three requirements below:
     *      It has the smallest distance to the targetPosition.
     *      It is pathable, and
     *      its direction is not opposite to the current one.
     *      if two or more directions have the same distance to the targetPosition, then the new position will be the last
     *      direction in the enum Direction.
     * In addition to set the new position, this method sets the direction and invokes the hit method in order to check
     * if the ghost hits Pacman in the new position.
     * In any case, this method invokes nextBehaviour.
     */
    public void move() {
        // If ghost it's inactive or target position it's null, do not move it
        if (this.getTargetPosition() != null) {
            Direction oppositeDir = this.getDirection().opposite();

            // Create a HashMap with the directions as the keys and the values
            Direction[] directions = Direction.values();
            HashMap<Direction, Double> distMap = new HashMap<Direction, Double>();
            // Create a HashMap with the directions as keys and the candidate positions as values
            HashMap<Direction, Position> posMap = new HashMap<Direction, Position>();

            // Fill in the values
            for (Direction dir : directions) {
                Position position = new Position(getPosition().getX() + dir.getX(), getPosition().getY() + dir.getY());
                double distance = position.distance(getTargetPosition());
                distMap.put(dir, distance);
                posMap.put(dir, position);
            }

            // Find the smallest distance and it's key
            directions = Direction.values();
            Direction minKey = null;
            double minValue = Double.MAX_VALUE;
            for (Direction dir : directions) {
                double value = distMap.get(dir);
                if (value <= minValue && dir != oppositeDir && getLevel().getMapItem(posMap.get(dir)).isPathable()) {
                    minValue = value;
                    minKey = dir;
                }
            }

            // Move the Ghost
            setPosition(posMap.get(minKey));
            setDirection(minKey);
        }
        // Check for collisions if the ghost it's not inactive
        if (!this.getBehaviour().equals(INACTIVE)) hit();
        nextBehaviour();
    }

    /**
     * Decreases the behaviour's duration and changes the ghost's behaviour to the next behaviour if duration is 0.
     */
    private void nextBehaviour() {
        setDuration(getDuration() - 1);
        if (getDuration() == 0) {
            if (getBehaviour().equals(CHASE)) {
                setBehaviour(SCATTER);
            }
            else {
                setBehaviour(CHASE);
            }
        }
    }

    /**
     * Resets the ghost back to its start position where it is "alive" (as the Character does) and also with a behaviour of INACTIVE and facing UP.
     */
    public void reset() {
        setPosition(getStartPosition());
        alive();
        setBehaviour(INACTIVE);
        setDirection(UP);
    }

    /**
     * Sets the current behaviour of the ghost.
     * Its duration overrides the value of the attribute duration.
     * @param behaviour - New value for the attribute behaviour.
     */
    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    /**
     * Setter of the attribute scatterPosition.
     * @param scatterPosition - New value for the attribute scatterPosition.
     */
    private void setScatterPosition(Position scatterPosition) {
        this.scatterPosition = scatterPosition;
    }

    /**
     * Represents this ghost in a comma-separated string format.
     * Format is: "x,y,DIRECTION,BEHAVIOUR:behaviourDuration".
     * DIRECTION is the uppercase enum type value for Direction.
     * BEHAVIOUR is the uppercase enum type value for Behaviour.
     * Example:
     * "2,3,UP,SCATTER,3"
     * @return "x,y,DIRECTION,BEHAVIOUR:behaviourDuration"
     */
    @Override
    public String toString() {
        return String.format(this.getPosition().getX() + "," +
                this.getPosition().getY() + "," +
                this.getDirection() + "," +
                this.getBehaviour());
    }

    /**
     * Checks if another object instance is equal to this ghost. Ghosts are equal if they have the same "dead status",
     * behaviour, direction, position (remember that Position overrides equals) and its duration is identical.
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Ghost && this.isDead() == ((Ghost) o).isDead() &&
                        this.getPosition().equals(((Ghost) o).getPosition()) &&
                        this.getDirection().getKeyCode() == ((Ghost) o).getDirection().getKeyCode() &&
                        this.getBehaviour().toString().compareTo(((Ghost) o).getBehaviour().toString()) == 0;
    }
}

package edu.uoc.pacman.model.entities.characters.pacman;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.Character;
import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.entities.items.*;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

import static edu.uoc.pacman.model.entities.characters.ghosts.Behaviour.FRIGHTENED;
import static edu.uoc.pacman.model.entities.characters.ghosts.Behaviour.INACTIVE;
import static edu.uoc.pacman.model.entities.characters.pacman.State.*;
import static edu.uoc.pacman.model.utils.Direction.*;
import static edu.uoc.pacman.model.utils.Sprite.*;

public class Pacman extends Character {
    /**
     * Stores the state of the Pacman.
     */
    private State state;

    public Pacman(Position startposition, Direction direction, State state, Level level) {
        super(startposition, direction, null, level);
        this.state = state;
        // Update pacman Sprite to match direction
        switch (direction) {
            case RIGHT -> setSprite(PACMAN_RIGHT);
            case DOWN -> setSprite(PACMAN_DOWN);
            case LEFT -> setSprite(PACMAN_LEFT);
            case UP -> setSprite(PACMAN_UP);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * Check if Pacman is in INVINCIBLE or EATER state and the timer has run out.
     * If time it's over, sets the state to NORMAL.
     */
    private void nextState() {
        setDuration(getDuration() - 1);     // Decrease duration
        if ( (getState().equals(INVINCIBLE) || getState().equals(EATER))
                && getDuration() == 0) {
            setState(NORMAL);
        }
    }

    /**
     * Resets Pacman back to its start position where it is "alive" (as Character does) and also with a state of INVINCIBLE and facing UP.
     */
    @Override
    public void reset() {
        setPosition(getStartPosition());
        setState(INVINCIBLE);
        setDirection(Direction.UP);
    }

    /**
     * Moves Pacman across the board only one step.
     * If the MapItem which is in the potential new position is pathable, then this method moves Pacman into this position. Otherwise, Pacman stays in its current position.
     * After moving, Pacman will eat the item that occupies the cell/tile/position and will add its score to the game score.
     * Lastly, it will invoke the hit method.
     * In any case, this method invokes nextState.
     */
    @Override
    public void move() {
        Position targetPos;
        switch (getDirection()) {
            case RIGHT -> targetPos = new Position(getPosition().getX() + RIGHT.getX(), getPosition().getY() + RIGHT.getY());
            case DOWN -> targetPos = new Position(getPosition().getX() + DOWN.getX(), getPosition().getY() + DOWN.getY());
            case LEFT -> targetPos = new Position(getPosition().getX() + LEFT.getX(), getPosition().getY() + LEFT.getY());
            case UP -> targetPos = new Position(getPosition().getX() + UP.getX(), getPosition().getY() + UP.getY());
            default -> targetPos = new Position(getPosition().getX(), getPosition().getY());
        }

        if (getLevel().getMapItem(targetPos) != null && getLevel().getMapItem(targetPos).isPathable()) {
            setPosition(targetPos);
            eat();
            hit();
        }
        nextState();
    }

    /**
     * Sets the direction of Pacman.
     * If the new direction is null, then the direction is not set and remains the same.
     * Because Pacman has 4 different sprites depending on its direction, this method also updates the value of
     * the attribute sprite, i.e. PACMAN_UP, PACMAN_LEFT, PACMAN_RIGHT and PACMAN_DOWN.
     * @param direction - New value for the attribute direction.
     */
    @Override
    public void setDirection(Direction direction) {
        if (direction != null) {
            super.setDirection(direction);
            switch (direction) {
                case RIGHT -> setSprite(PACMAN_RIGHT);
                case DOWN -> setSprite(PACMAN_DOWN);
                case LEFT -> setSprite(PACMAN_LEFT);
                case UP -> setSprite(PACMAN_UP);
            }
        }
    }

    /**
     * Performs the eat action. This means which picks Pickable objects up and add its points to the level's score, if it is needed.
     * Remember that some Pickable objects are Scorable ones as well.
     * If Pacman picks an energizer up, then the behaviour of all the ghosts must be FRIGHTENED. Moreover, Pac man's state must be EATER.
     * If Pacman picks a life up, then one life is increased for the current level.
     * When any Pickable objects is picked up, then it is removed from the labyrinth/map and replaced by a Path item.
     */
    private void eat() {
        MapItem item = getLevel().getMapItem(this.getPosition());       // Get item located in Pac man's position
        boolean picked = false;
        if (item instanceof Dot) {
            ((Dot) item).setPicked(true);
            getLevel().addPoints(((Dot) item).getPoints());
            picked = true;
        }
        if (item instanceof Life) {
            ((Life) item).setPicked(true);
            getLevel().increaseLives();
            picked = true;
        }
        if (item instanceof Energizer) {
            ((Energizer) item).setPicked(true);
            getLevel().addPoints(((Energizer) item).getPoints());
            getLevel().setGhostsFrightened();
            setState(EATER);
            setDuration(EATER.getDuration());
            picked = true;
        }
        // If an item was picked replace it with a path element
        if (picked) {
            Path path = new Path(item.getPosition());
            getLevel().removeMapItem(item);
            getLevel().addMapItem(path);
        }
    }

    /**
     * Checks if Pacman is in the same position which any ghost. If this happens, then checks ghost's status:
     * If Pac man's state is INVINCIBLE, then nothing happens and this method returns false.
     * If the ghost is FRIGHTENED, then the ghost is killed. This method returns true.
     * If the ghost is INACTIVE, then nothing happens and this method returns false.
     * @return true if Pacman collides with any ghost and the aforesaid cases are met. Otherwise, false.
     */
    public boolean hit() {
        if (getState() != INVINCIBLE) {
            for(Ghost g: getLevel().getGhostList()) {
                if (g.getPosition().equals(this.getPosition()) && g.getBehaviour() == FRIGHTENED) {
                    g.kill();
                    return true;
                }
                if (g.getPosition().equals(this.getPosition()) && g.getBehaviour() != INACTIVE){
                    this.kill();        // Pacman dies if ghost it's not in a FRIGHTENED state
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Kills Pacman and decreases one life in the current level. Moreover, it assigns INVINCIBLE to its state.
     */
    public void kill() {
        getLevel().decreaseLives();
        super.kill();
        reset();
    }
}

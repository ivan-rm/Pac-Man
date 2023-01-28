package edu.uoc.pacman.model.entities.characters;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * A character is any entity that is able to move and hit. As a result, it can traverse the game board and interact with other entities.
 * @author Iván Ruiz Marcos
 */
public abstract class Character extends Entity implements Movable, Hitable {
    /**
     * Indicates if the character is dead (true) or not (false).
     */
    private boolean dead;
    /**
     * The direction that the character faces.
     */
    private Direction direction;
    /**
     * Left time so that the ghost changes its current behaviour or the Pacman changes its current state.
     */
    private int duration;
    /**
     * Reference to the current level object.
     */
    private Level level;
    /**
     * Stores the initial/start position of the character.
     */
    private Position startPosition;

    /**
     * Creates a character at the given position facing in the given direction.
     * Any character is pathable.
     * If the position is null, then the position will be (0,0).
     * Take into consideration that the value of the parameter position is also the start/initial position of the character.
     * If the direction is null, then the direction will be UP.
     * By default, any character is alive.
     * @param position - to be set to.
     * @param direction - to be facing.
     * @param sprite - to be set to.
     * @param level - Reference to the current level.
     */
    public Character(Position position, Direction direction, Sprite sprite, Level level) {
        super(position, true, sprite);
        this.dead = false;
        if (direction == null) {
            direction = Direction.UP;
        }
        this.direction = direction;
        this.level = level;
        this.startPosition = position;
    }

    /**
     * Sets the attribute dead to false.
     */
    public void alive() {
        dead = false;
    }
    /**
     * Sets the attribute dead to true.
     */
    public void kill() {
        dead = true;
    }
    /**
     * Resets the character. This means that the character is placed in the start position and is alive.
     */
    public void reset() {
        setDead(false);
        this.setPosition(startPosition);
    }
    public boolean isDead() {
        return dead;
    }

    private void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * Gets the direction that the character is facing.
     * @return The current direction of the character.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the character.
     * If the direction is null, then the direction is not set and remains the same.
     * @param direction - New value for the attribute direction.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    protected int getDuration() {
        return duration;
    }

    protected void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter of the attribute level.
     * @return The current value of the attribute level.
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Setter of the attribute level.
     * @param level - New value for the attribute level.
     */

    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Getter of the attribute startPosition.
     * @return Current value of the attribute startPosition.
     */
    protected Position getStartPosition() {
        return startPosition;
    }

    /**
     * Setter of the attribute startPosition.
     * @param startPosition - New value of the attribute startPosition.
     */
    private void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }
    @Override
    public String toString() {
        return String.format(this.getPosition().getX() + "," + this.getPosition().getY() + "," + this.getDirection());
    }
    @Override
    public boolean hit() {
        return false;
    }
}

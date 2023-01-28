package edu.uoc.pacman.model.entities;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents any item that appears in the game.
 * @author Iván Ruiz Marcos
 */
public abstract class Entity {
    /**
     * Indicates if the entity is pathable or not.
     */
    private boolean pathable;
    /**
     * Position where the entity is.
     */
    private Position position;
    /**
     * Value of Sprite linked to the entity.
     */
    private Sprite sprite;

    /**
     * Constructor with arguments.
     * @param pathable - Initial value of the attribute pathable.
     * @param position - Initial value of the attribute position.
     * @param sprite - Initial value of the attribute sprite.
     */
    protected Entity(Position position, boolean pathable, Sprite sprite) {
        this.pathable = pathable;
        this.position = position;
        this.sprite = sprite;
    }

    /**
     * Getter of the attribute pathable.
     * @return - New value for the attribute pathable.
     */
    public boolean isPathable() {
        return pathable;
    }

    /**
     * Setter of the attribute pathable.
     * @param pathable - New value for the attribute pathable.
     */
    public void setPathable(boolean pathable) {
        this.pathable = pathable;
    }

    /**
     * Gets the current position of the entity.
     * @return current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the entity. If position is null, then the position is not set.
     * @param position - to set to the entity
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Getter of the attribute sprite.
     * @return Current value of sprite.
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Setter of the attribute sprite.
     * @param sprite - New value for the attribute sprite.
     */
    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}

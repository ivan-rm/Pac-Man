package edu.uoc.pacman.model.entities.characters;

import edu.uoc.pacman.model.utils.Direction;

/**
 * Defines the methods that any hitable entity must have.
 * @author Iván Ruiz Marcos
 */
public interface Movable {
    /**
     * Defines the signature of the method that manages the movement of any movable entity.
     */
    void move();

    /**
     * Defines the signatures of the method that manages the direction in which any movable entity moves.
     * @param direction - New direction to set
     */
    void setDirection(Direction direction);
}

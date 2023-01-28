package edu.uoc.pacman.model.entities.characters;

/**
 * Defines the methods that any hitable entity must have.
 * @author Iván Ruiz Marcos
 */
public interface Hitable {
    /**
     * Defines the signature of the method that manages the hit action of any hitable entity.
     * @return true if the entity has hit any other entity. Otherwise, false.
     */
    boolean hit();
}

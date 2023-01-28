package edu.uoc.pacman.model.entities;

/**
 * Defines the methods that any scorable entity must have.
 * @author Iván Ruiz Marcos
 */
public interface Scorable {
    /**
     * Gets the number of points
     * @return The number of points that the entity gives.
     */
    int getPoints();
}

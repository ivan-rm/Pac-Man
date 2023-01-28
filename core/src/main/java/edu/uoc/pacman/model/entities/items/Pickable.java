package edu.uoc.pacman.model.entities.items;

/**
 * Defines the methods that any pickable item must have.
 * @author Iván Ruiz Marcos
 */
public interface Pickable {
    /**
     * Method that allows us to know if the item has been picked or not.
     */
    boolean isPicked();

    /**
     * Sets the item as picked/unpicked.
     */
    void setPicked(boolean picked);
}

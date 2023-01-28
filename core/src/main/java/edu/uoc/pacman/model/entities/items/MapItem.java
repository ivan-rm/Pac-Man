package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Entity;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Abstract class that represents any labyrinth/map item.
 * @author Iván Ruiz Marcos
 */
public abstract class MapItem extends Entity {
    /**
     * Constructor with arguments.
     * @param position - Position where the item is.
     * @param pathable - Indicates if the item is pathable or not.
     * @param sprite - Value linked to the file configuration symbol and image.
     */
    protected MapItem(Position position, boolean pathable, Sprite sprite) {
        super(position, pathable, sprite);
    }
}

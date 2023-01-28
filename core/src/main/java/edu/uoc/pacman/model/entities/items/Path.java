package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a path in the labyrinth/map.
 * @author Iván Ruiz Marcos
 */
public class Path extends MapItem {
    /**
     * Constructor with arguments.
     * The value for pathable is true and for sprite is Sprite.PATH.
     * @param position - Position where the path is.
     */
    public Path(Position position) {
        super(position, true, Sprite.PATH);
    }
}

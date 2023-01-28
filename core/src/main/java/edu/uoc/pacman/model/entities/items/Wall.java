package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a wall in the labyrinth/map.
 * @author Iván Ruiz Marcos
 */
public class Wall extends MapItem {
    /**
     * Constructor with arguments.
     * The value for pathable is false and for sprite is Sprite.WALL.
     * @param position - Position where the wall is.
     */
    public Wall(Position position) {
        super(position, false, Sprite.WALL);
    }
}

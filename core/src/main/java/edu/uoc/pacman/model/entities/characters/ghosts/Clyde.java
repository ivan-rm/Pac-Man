package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseCoward;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a Clyde (orange) ghost.
 * @author Iván Ruiz Marcos
 */
public class Clyde extends Ghost {
    /**
     * This attribute stores the amount of points that the Inky ghost gives.
     */
    private static final int POINTS = 100;

    /**
     * Constructor with arguments.
     * The value of the scatterPosition is (-1,LEVEL.HEIGHT).
     * The value of the sprite is Sprite.CLYDE.
     * It assigns to chaseBehaviour a ChaseCoward object.
     * @param startPosition - The position where the ghost is in the beginning (value given by the level configuration file).
     * @param direction - Direction which the ghost faces in the beginning.
     * @param behaviour - Current behaviour of the ghost.
     * @param level - Reference to the current level object.
     */
    public Clyde(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(-1, level.getHeight()), direction, behaviour, Sprite.CLYDE, level);
        this.chaseBehaviour = new ChaseCoward();

    }

    /**
     * Getter of the attribute POINTS.
     * @return Returns the value of the attribute POINTS.
     */
    public int getPoints() {
        return POINTS;
    }
}

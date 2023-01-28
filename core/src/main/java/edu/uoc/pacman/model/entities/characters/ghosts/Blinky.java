package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseAggressive;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a Blinky (red) ghost.
 * @author Iván Ruiz Marcos
 */
public class Blinky extends Ghost {
    /**
     * This attribute stores the amount of points that the Blinky ghost gives.
     */
    private static final int POINTS = 400;

    /**
     * Constructor with arguments.
     * The value of the scatterPosition is (level.WIDTH,-1).
     * The value of the sprite is Sprite.BLINKY.
     * It assigns to chaseBehaviour a ChaseAggressive object.
     * @param startPosition - The position where the ghost is in the beginning (value given by the level configuration file).
     * @param direction - Direction which the ghost faces in the beginning.
     * @param behaviour - Current behaviour of the ghost.
     * @param level - Reference to the current level object.
     */
    public Blinky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(level.getWidth(), -1), direction, behaviour, Sprite.BLINKY, level);
        this.chaseBehaviour = new ChaseAggressive();
    }

    /**
     * Getter of the attribute POINTS.
     * @return Returns the value of the attribute POINTS.
     */
    public int getPoints() {
        return POINTS;
    }
}

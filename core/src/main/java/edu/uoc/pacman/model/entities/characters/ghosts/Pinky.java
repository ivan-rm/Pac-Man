package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChaseAmbush;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a Pinky ghost.
 * @author Iván Ruiz Marcos
 */
public class Pinky extends Ghost {

    /**
     * This attribute stores the amount of points that the Pinky ghost gives.
     */
    private static final int POINTS = 300;

    /**
     * Constructor with arguments.
     * The value of the scatterPosition is (-1,-1).
     * The value of the sprite is Sprite.PINKY.
     * It assigns to chaseBehaviour a ChaseAmbush object.
     * @param startPosition - The position where the ghost is in the beginning (value given by the level configuration file).
     * @param direction - Direction which the ghost faces in the beginning.
     * @param behaviour - Current behaviour of the ghost.
     * @param level - Reference to the current level object.
     */
    public Pinky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(-1,-1), direction, behaviour, Sprite.PINKY, level);
        this.chaseBehaviour = new ChaseAmbush();
    }

    /**
     * Getter of the attribute POINTS.
     * @return Returns the value of the attribute POINTS.
     */
    public int getPoints() {
        return POINTS;
    }
}

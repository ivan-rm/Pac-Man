package edu.uoc.pacman.model.entities.characters.ghosts;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.chase.ChasePatrol;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents an Inky (bluish) ghost.
 * @author Iván Ruiz Marcos
 */
public class Inky extends Ghost {
    /**
     * This attribute stores the amount of points that the Inky ghost gives.
     */
    private static final int POINTS = 200;

    /**
     * Constructor with arguments.
     * The value of the scatterPosition is (LEVEL.WIDTH,LEVEL.HEIGHT).
     * The value of the sprite is Sprite.INKY.
     * It assigns to chaseBehaviour a ChasePatrol object.
     * @param startPosition - The position where the ghost is in the beginning (value given by the level configuration file).
     * @param direction - Direction which the ghost faces in the beginning.
     * @param behaviour - Current behaviour of the ghost.
     * @param level - Reference to the current level object.
     */
    public Inky(Position startPosition, Direction direction, Behaviour behaviour, Level level) {
        super(startPosition, new Position(level.getHeight(), level.getWidth()), direction, behaviour, Sprite.INKY, level);
        this.chaseBehaviour = new ChasePatrol();
    }

    /**
     * Getter of the attribute POINTS.
     * @return Returns the value of the attribute POINTS.
     */
    public int getPoints() {
        return POINTS;
    }
}

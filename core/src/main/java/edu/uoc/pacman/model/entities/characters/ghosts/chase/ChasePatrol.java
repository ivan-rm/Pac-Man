package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

/**
 * It implements the ChaseBehaviour interface according to an aggressive behaviour.
 * In order to locate Inky's target position, we first start by selecting the position TILES_OFFSET tiles in front
 * of Pac-Man in his current direction of travel, similar to Pinky's targeting method.
 * From there, imagine drawing a vector from Blinky's position to this tile, and then doubling (i.e. the value of
 * VECTOR_INCREASE the length of the vector. The tile that this new, extended vector ends on will be Inky's actual target.
 */
public class ChasePatrol implements ChaseBehaviour {
    /**
     * The amount of tiles/cells/positions/steps that must be added to the Pacman's position
     */
    private static final int TILES_OFFSET = 2;
    /**
     * The amount which the vector equals to targetPositionBlinky - FIRST_BLINKY_POSITION must be extended (multiplied).
     */
    private static final int VECTOR_INCREASE = 2;
    public ChasePatrol() {
    }

    /**
     * The ghost will chase twice a vector equals to:
     * targetBlinkyPosition - FIRST_BLINKY_POSITION targetBlinkyPosition is the position which is TILES_OFFSET
     * steps/tiles/cells/positions ahead of Pacman's position in the direction Pacman is facing.
     * @param ghost - Ghost object that chases.
     * @return Position where the ghost must go:
     * VECTOR_INCREASE * (targetBlinkyPosition - FIRST_BLINKY_POSITION)
     *
     * If there are no Blinky ghosts, then it returns targetBlinkyPosition.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        // Compute targetBlinkyPosition
        Position pacmanPos = ghost.getLevel().getPacman().getPosition();
        Direction pacmanDir = ghost.getLevel().getPacman().getDirection();

        Position targetBlinkyPosition = new Position(pacmanPos.getX() + pacmanDir.getX() * TILES_OFFSET,
                pacmanPos.getY() + pacmanDir.getY() * TILES_OFFSET);

        if (ghost.getLevel().getBlinky() == null) return targetBlinkyPosition;

        Position firstBlinkyPosNegative = new Position(-ghost.getLevel().getBlinky().getPosition().getX(),
                -ghost.getLevel().getBlinky().getPosition().getY());
        Position returnPos = (Position.add(targetBlinkyPosition, firstBlinkyPosNegative));
        returnPos.setX(returnPos.getX() * VECTOR_INCREASE);
        returnPos.setY(returnPos.getY() * VECTOR_INCREASE);
        return returnPos;
    }
}

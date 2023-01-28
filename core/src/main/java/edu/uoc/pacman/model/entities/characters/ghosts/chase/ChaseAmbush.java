package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.Level;
import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Direction;
import edu.uoc.pacman.model.utils.Position;

import static edu.uoc.pacman.model.utils.Direction.*;

/**
 * It implements the ChaseBehaviour interface according to an ambush behaviour.
 * Its target position is four steps ahead of Pacman's position in the direction Pacman is facing.
 * @author Iván Ruiz Marcos
 */
public class ChaseAmbush implements ChaseBehaviour {
    /**
     * The amount of tiles/cells/positions/steps that must be added to the Pacman's position.
     */
    private static final int TILES_OFFSET = 4;

    public ChaseAmbush() {
    }

    /**
     * The ghost will chase the position which is TILES_OFFSET steps/tiles/cells/positions ahead of Pac man's position
     * in the direction Pacman is facing.
     * @param ghost - Ghost object that chases.
     * @return Position where the ghost must go, i.e. the position which is TILES_OFFSET steps ahead of Pac man's
     * position in the direction Pacman is facing.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        Direction pacmanDir = ghost.getLevel().getPacman().getDirection();
        Position pacmanPos = ghost.getLevel().getPacman().getPosition();
        return new Position(pacmanPos.getX() + pacmanDir.getX() * TILES_OFFSET,
                pacmanPos.getY() + pacmanDir.getY() * TILES_OFFSET);
    }
}

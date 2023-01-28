package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Position;

/**
 * It implements the ChaseBehaviour interface according to a coward behaviour.
 * It has two different modes which it constantly switches back and forth between, based on its proximity to Pacman.
 */
public class ChaseCoward implements ChaseBehaviour {
    /**
     * Distance in tiles to decide which position is the target one.
     */
    private static final int TILES_TO_CHASE = 8;

    public ChaseCoward() {
    }

    /**
     * The ghost will target Pacman's position if the euclidean distance between positions is equal to or greater than
     * a distance of TILES_TO_CHASE.
     * @param ghost - Ghost object that chases.
     * @return Position where the ghost must go. Pac man's position fs the euclidean distance is equal to or greater
     * than TILES_TO_CHASE. Otherwise, ghost's scatter position.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        if (ghost.getPosition().distance(ghost.getLevel().getPacman().getPosition()) >= TILES_TO_CHASE) return ghost.getLevel().getPacman().getPosition();
        return ghost.getScatterPosition();
    }
}

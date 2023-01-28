package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Position;

/**
 * It implements the ChaseBehaviour interface according to an aggressive behaviour.
 * Its target position is directly Pacman's position
 */
public class ChaseAggressive implements ChaseBehaviour {

    public ChaseAggressive() {
    }

    /**
     * The ghost will chase the Pacman's current direction.
     * @param ghost - Ghost object that chases.
     * @return Pacman's current position.
     */
    @Override
    public Position getChasePosition(Ghost ghost) {
        return ghost.getLevel().getPacman().getPosition();
    }
}

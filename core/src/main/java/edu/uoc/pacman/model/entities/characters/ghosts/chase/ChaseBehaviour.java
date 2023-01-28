package edu.uoc.pacman.model.entities.characters.ghosts.chase;

import edu.uoc.pacman.model.entities.characters.ghosts.Ghost;
import edu.uoc.pacman.model.utils.Position;

/**
 * Defines the methods that any character (namely, ghost) must have to chase.
 * @author Iván Ruiz Marcos
 */
public interface ChaseBehaviour {
    /**
     * Defines the signature of the method to be used to get the position where any character (namely, ghosts) must to go to.
     * @param ghost - Ghost object that wants to chase.
     * @return Position where the ghost must go to.
     */
    Position getChasePosition(Ghost ghost);
}

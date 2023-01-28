package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents a life in the labyrinth/map.
 * @author Iván Ruiz Marcos
 */
public class Life extends MapItem implements Pickable {

    /**
     * This attribute allows us to manage if the life has been picked or not.
     */
    private boolean picked;

    /**
     * Constructor with argument.
     * The value for pathable is true and for sprite is Sprite.LIFE.
     * @param position - The position where the life is.
     */
    public Life(Position position) {
        super(position, true, Sprite.LIFE);
    }

    /**
     * Getter of the attribute picked.
     * @return The current value of the attribute picked.
     */
    @Override
    public boolean isPicked() {
        return picked;
    }

    /**
     * Setter of the attribute pickled.
     * @param picked - New value for the attribute picked.
     */
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}

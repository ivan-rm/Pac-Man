package edu.uoc.pacman.model.entities.items;

import edu.uoc.pacman.model.entities.Scorable;
import edu.uoc.pacman.model.utils.Position;
import edu.uoc.pacman.model.utils.Sprite;

/**
 * Represents an energizer in the labyrinth/map.
 * @author Iván Ruiz Marcos
 */
public class Energizer extends MapItem implements Pickable, Scorable {
    /**
     * This attribute allows us to manage if the energizer has been picked or not.
     */
    private boolean picked;
    /**
     * This attribute stores the amount of points that the energizer gives.
     */
    private static final int POINTS = 5;

    /**
     * Constructor with argument.
     * The value for pathable is true and for sprite is Sprite.ENERGIZER.
     * @param position - The position where the energizer is.
     */
    public Energizer(Position position) {
        super(position, true, Sprite.ENERGIZER);
        this.picked = false;
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
     * Setter of the attribute picked.
     * @param picked - New value for the attribute picked.
     */
    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    /**
     * Getter of the attribute POINTS.
     * @return Returns the value of the attribute POINTS.
     */
    public int getPoints() {
        return POINTS;
    }
}

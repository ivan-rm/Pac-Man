package edu.uoc.pacman.model.entities.characters.pacman;

/**
 * Represents the three state which Pacman can have. The behaviour are defined as "NORMAL", "EATER" and "INVINCIBLE".
 * "NORMAL" - Its the most frequent state. Its duration is Integer.MAX_VALUE.
 * "EATER" - Pacman can kill ghosts. It has a duration of 30, the same as the ghost's frightened behaviour.
 * "INVINCIBLE" - Pacman cannot be killed by ghosts, but it does not kill ghosts either. Duration = 5.
 * @author Iván Ruiz Marcos
 */
public enum State {
    EATER(30),
    INVINCIBLE(5),
    NORMAL(Integer.MAX_VALUE);

    /**
     * Stores the duration of the state.
     */
    private final int duration;

    State(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Returns a String with information of the State.
     * Format: STATE:stateDuration
     * Example: "INVINCIBLE:5"
     * @return State:stateDuration
     */
    @Override
    public String toString() {
        return String.format(super.toString() + ":" + this.getDuration());

    }
}

package edu.uoc.pacman.model.entities.characters.ghosts;

/**
 * Behaviour defines the different behaviour which a ghost can be in. The behaviour are defined as "CHASE", "SCATTER", "FRIGHTENED"
 * and "INACTIVE".
 * "CHASE" - Behaviour where the ghosts chase Pacman. Has a duration of 20.
 * "FRIGHTENED" - Behaviour where the ghosts are frightened and confused. It has a duration of 30.
 * "SCATTER" - Behaviour where the ghosts run home (scatter position). IT has a duration of 10.
 * "INACTIVE" - Behaviour where the ghosts don't do anything and Pacman cannot kill them.
 * @author Iván Ruiz Marcos
 */
public enum Behaviour {
    CHASE(20),
    FRIGHTENED(30),
    INACTIVE(5),
    SCATTER(10);
    /**
     * Stores the duration of the behaviour.
     */
    private final int duration;

    /**
     * Constructor with parameter
     * @param duration - Duration of the behaviour
     */
    Behaviour(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Returns a String with information of the Behaviour. Format: BEHAVIOUR:behaviourDuration Example: "CHASE:20" Hint: Remember
     * that toString() is already coded in Object.
     * @return BEHAVIOUR:behaviourDuration
     */
    @Override
    public String toString() {
        return String.format(super.toString() + ":" + this.getDuration());

    }
}

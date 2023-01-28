package edu.uoc.pacman.model.exceptions;

/**
 * Represents the different exceptions expected in the game.
 * @author Iván Ruiz Marcos
 * @version 1.0
 */
public class LevelException extends Exception {
    /**
     * Error message when the size of the board does not meet the minimum.
     */
    public static final String SIZE_ERROR = "[ERROR] Board's size must be equal or greater than !!!";
    /**
     * Error message when there are not any dot or energizer
     */
    public static final String PICKABLE_ERROR = "[ERROR] There must be one pickable item (i.e. dot or energizer) at least!!";
    /**
     * Error message when there are not any dot or energizer.
     */
    public static final String GHOSTS_ERROR = "[ERROR] This level does not contain any ghost!!";
    /**
     * Error message when there isn't any ghost.
     */
    public static final String PARSING_LEVEL_FILE_ERROR = "[ERROR] There was an error while loading the current level file!";

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LevelException(String message) {
        super(message);
    }
}

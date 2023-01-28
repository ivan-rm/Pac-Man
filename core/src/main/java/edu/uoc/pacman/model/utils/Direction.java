package edu.uoc.pacman.model.utils;

/**
 * Direction that Pacman and ghosts face.
 * @author Iván Ruiz Marcos
 * @version 1.0
 */
public enum Direction {

    RIGHT(1, 0, 22),
    DOWN(0, 1, 20),
    LEFT(-1, 0, 21),
    UP(0, -1, 19);

    /**
     * Offset in X axis
     */
    private final int x;
    /**
     * Offset in Y axis
     */
    private final int y;
    /**
     * Intenger value that is given by libgdx to a key pressed by the user.
     */
    private final int keyCode;

    Direction(int x, int y, int keyCode) {
        this.keyCode = keyCode;
        this.x = x;
        this.y = y;
    }

    /**
     * Given the value of keyCode, it returns the corresponding Direction value.
     * @param keyCode - Integer value of a key.
     * @return The Direction value linked to keyCode. If any, then returns null.
     */
    public static Direction getDirectionByKeyCode(int keyCode) {
        for (Direction d : values()) {
            if (d.keyCode == keyCode) {
                return d;
            }
        }
        return null;
    }

    /**
     * Getter of the attibute keyCode
     * @return The value of the attribute keyCode
     */
    public int getKeyCode() {
        return this.keyCode;
    }

    /**
     * Getter of the attibute x
     * @return The value of the attribute x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter of the attibute y
     * @return The value of the attribute y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets the opposite direction of the direction that invokes this method.
     * @return Opposite direction to the current direction.
     */
    public Direction opposite() {
        switch (this.getKeyCode()) {
            case 19 -> {
                return DOWN;
            }
            case 20 -> {
                return UP;
            }
            case 21 -> {
                return RIGHT;
            }
            case 22 -> {
                return LEFT;
            }
        }
        return null;
    }
}

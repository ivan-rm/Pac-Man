package edu.uoc.pacman.model.utils;

import java.util.Objects;

/**
 * Stores a 2D position/point/coordinate.
 * @author Iván Ruiz Marcos
 */
public class Position {
    /**
     * Value of the attribute X axis
     */
    private int x;
    /**
     * Value of the attribute Y axis
     */
    private int y;

    /**
     * Constructor with arguments.
     * @param x - Initial value of the attribute x
     * @param y - Initial value of the attribute y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of the attribute x
     * @return - New value for the attribute x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter of the attribute x
     * @param x - New value for the attribute x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter of the attribute y
     * @return The current value of the attribute y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter of the attribute y
     * @param y - New value for the attribute y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calculates the Euclidean distance from this point to other given point.
     * @param other - Second position to calculate distance.
     * @return The Euclidean distance between the position which invokes the method and the other position. If other is null, then it returns 0.
     */
    public double distance(Position other) {
        if (other != null) return Math.sqrt( Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
        return 0;
    }

    /**
     * Creates a new Position object as a result to add p1 and p2.
     * @param p1 - First position
     * @param p2 - Second position
     * @return New Position with x = p1.x + p2.x and y = p1.y and p2.y.
     * @throws NullPointerException - When either p1 or p2 are null.
     */
    public static Position add(Position p1, Position p2) throws NullPointerException {
        if (p1 == null || p2 == null) throw new NullPointerException();
        return new Position(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }

    /**
     * Checks if two positions are equal.
     * @param other - object to compare against.
     * @return true if the type of other is Position and x == this.x and also y == this.y, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other.getClass() == Position.class && ((Position) other).getX() == x && ((Position) other).getY() == y;
    }

    /**
     * Returns the hash of a Position object.
     * @return The result of applying Objects.hash on x and y.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Returns a comma-seperated string representation of a Position.
     * Format: "x,y"
     * Example: "3,4"
     * @return "x,y"
     */
    @Override
    public String toString() {
        return String.format(x + "," + y);
    }
}

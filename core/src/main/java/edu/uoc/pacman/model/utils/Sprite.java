package edu.uoc.pacman.model.utils;

/**
 * Sprite that stores the configuration file symbol and the image's path.
 * @author Iván Ruiz Marcos
 */
public enum Sprite {

    BLINKY('B', "images/blinky.png"),
    CLYDE('C',"images/clyde.png"),
    DOT('.', "images/dot.png"),
    ENERGIZER('0', "images/energizer.png"),
    INKY('I', "images/inky.png"),
    LIFE('L', "images/life.png"),
    PACMAN_DOWN('V', "images/pac_down.png"),
    PACMAN_LEFT('>', "images/pac_left.png"),
    PACMAN_RIGHT('<', "images/pac_right.png"),
    PACMAN_UP('^', "images/pac_up.png"),
    PATH(' ', "images/path.png"),
    PINKY('P', "images/pinky.png"),
    WALL('#', "images/wall.png");

    /**
     * Value of the image path.
     */
    private final String imageSrc;
    /**
     * Value in the configuration file.
     */
    private final char symbol;

    /**
     * Constructor with arguments.
     * @param symbol - Value of the configuration file symbol.
     * @param imageSrc - Value of the image path.
     */
    Sprite(char symbol, String imageSrc) {
        this.imageSrc = imageSrc;
        this.symbol = symbol;
    }

    /**
     * Getter of the attribute symbol.
     * @return Current value of the attribute symbol.
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * Getter of the attribute imageSrc.
     * @return Current value of the attribute imageSrc.
     */
    public String getImageSrc() {
        return this.imageSrc;
    }
}

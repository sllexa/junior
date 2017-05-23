package ru.job4j.chess;

/**
 * Класс Cell.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.05.2017
 */
public class Cell {
    /**
     * coordinate X.
     */
    private int x;
    /**
     * coordinate Y.
     */
    private int y;

    /**
     * Constructor Cell.
     * @param x - coordinate X.
     * @param y - coordinate Y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for X.
     * @return - coordinate X.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setter for X.
     * @param x - number.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for Y.
     * @return - coordinate Y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter for Y.
     * @param y - number.
     */
    public void setY(int y) {
        this.y = y;
    }
}

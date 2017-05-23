package ru.job4j.chess;

import ru.job4j.chess.exception.ImposibleMoveException;
/**
 * Класс Figure.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.05.2017
 */
public abstract class Figure {
    /**
     * Current position figure.
     */
    private final Cell position;

    /**
     * Constructor for Figure.
     * @param position - current.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return this.position;
    }

    /**
     * Method for return possible move of figure.
     * @param dist - cell for destination.
     * @return array of cell.
     * @throws ImposibleMoveException when move is impossible.
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;
    /**
     * Method for clone figure.
     * @param dist - destination cell for clone.
     * @return new figure.
     */
    public abstract Figure clone(Cell dist);

}

package ru.job4j.chess;

import ru.job4j.chess.exception.ImposibleMoveException;

/**
 * Класс Elephant.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.05.2017
 */
public class Elephant extends Figure {
    /**
     * Constructor for Elephant.
     * @param position - current position.
     */
    public Elephant(Cell position) {
        super(position);
    }

    /**
     * Method for return possible move of figure.
     * @param dist - cell for destination.
     * @return array of cell.
     * @throws ImposibleMoveException when move is impossible.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int posX = this.getPosition().getX();
        int posY = this.getPosition().getY();
        int deltaX = Math.abs(this.getPosition().getX() - dist.getX());
        int deltaY = Math.abs(this.getPosition().getY() - dist.getY());
        if (deltaX == deltaY) {
            Cell[] result = new Cell[deltaX];
            for (int i = 0; i < deltaX; i++) {
                if (posX > dist.getX() && posY < dist.getY()) {
                    result[i] = new Cell(--posX, ++posY);
                } else if (posX < dist.getX() && posY > dist.getY()) {
                    result[i] = new Cell(++posX, --posY);
                } else if (posX < dist.getX() && posY < dist.getY()) {
                    result[i] = new Cell(++posX, ++posY);
                } else if (posX > dist.getX() && posY > dist.getY()) {
                    result[i] = new Cell(--posX, --posY);
                }

                ///result[i] = step(this.getPosition().getX(), this.getPosition().getY(), dist.getX(), dist.getY());
            }
            return result;
        } else {
            throw new ImposibleMoveException("The elephant can't go so.");
        }
    }

    /**
     * Method for clone figure.
     * @param dist - destination cell for clone.
     * @return new figure.
     */
    public Figure clone(Cell dist) {
        return new Elephant(dist);
    }
}

package ru.job4j.chess;

import ru.job4j.chess.exception.ImposibleMoveException;

/**
 * Класс Rook.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.05.2017
 */
public class Rook extends Figure {
    /**
     * Constructor for Figure.
     * @param position - current.
     */
    public Rook(Cell position) {
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
        int deltaX = Math.abs(posX - dist.getX());
        int deltaY = Math.abs(posY - dist.getY());
        if (deltaX == 0 || deltaY == 0) {
            int delta = deltaX != 0 ? deltaX : deltaY;
            Cell[] result = new Cell[delta];
            for (int i = 0; i < delta; i++) {
                if (posX == dist.getX() && posY < dist.getY()) {
                    result[i] = new Cell(posX, ++posY);
                } else if (posX == dist.getX() && posY > dist.getY()) {
                    result[i] = new Cell(posX, --posY);
                } else if (posX < dist.getX() && posY == dist.getY()) {
                    result[i] = new Cell(++posX, posY);
                } else if (posX > dist.getX() && posY == dist.getY()) {
                    result[i] = new Cell(--posX, posY);
                }

                //result[i] = step(this.getPosition().getX(), this.getPosition().getY(), dist.getX(), dist.getY());
            }
            return result;
        } else {
            throw new ImposibleMoveException("The rook can't go so.");
        }
    }

    /**
     * Method for clone figure.
     * @param dist - destination cell for clone.
     * @return new figure.
     */
    public Figure clone(Cell dist) {
        return new Rook(dist);
    }
}

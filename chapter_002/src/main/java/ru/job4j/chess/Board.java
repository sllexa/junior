package ru.job4j.chess;

import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImposibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Класс Board.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 20.05.2017
 */
public class Board {
    /**
     * Array of figures for game.
     */
    private Figure[] figures;

    /**
     * Constructor for Board.
     * @param figures - array of figures.
     */
    public Board(Figure[] figures) {
        this.figures = figures;
    }
    /**
     * Method for moving a figure.
     * @param source cell for move figure.
     * @param dist - destination cell for move figure.
     * @return boolean true for legal move and false for illegal.
     * @throws ImposibleMoveException when move is impossible.
     * @throws OccupiedWayException when way is occupied.
     * @throws FigureNotFoundException when figure isn't founded.
     */
    boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        int ind = 0;
        boolean result = false;
        boolean figureIs = false;
        for (; ind < figures.length; ind++) {
            if (this.figures[ind] != null && this.figures[ind].getPosition().equals(source)) {
                figureIs = true;
                break;
            }
        }
        if (!figureIs) {
            throw new FigureNotFoundException("In the source cell is no figure.");
        } else {
            Cell[] wayFigure = null;
            wayFigure = this.figures[ind].way(dist);
            if (wayFigure != null) {
                for (Figure tmp : figures) {
                    for (Cell cell : wayFigure) {
                        if (tmp.getPosition().equals(cell)) {
                            throw new OccupiedWayException("The path is not free.");
                        }
                    }
                }
                figures[ind] = figures[ind].clone(dist);
                result = true;
            }
        }
        return result;
    }
}
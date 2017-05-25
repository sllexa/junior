package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImposibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 24.05.2017
 */
public class BoardTest {
    /**
     * test for check method move if source cell hasn't figure.
     * @throws ImposibleMoveException -
     * @throws OccupiedWayException -
     * @throws FigureNotFoundException -
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenUseMoveButInCellNoFigure() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure firstElephant = new Elephant(new Cell(3, 1));
        Figure secondElephant = new Elephant(new Cell(6, 1));
        Figure firstRook = new Rook(new Cell(1, 1));
        Figure secondRook = new Rook(new Cell(8, 1));
        Figure[] figures = {firstElephant, firstRook, secondElephant, secondRook};
        Board board = new Board(figures);
        board.move(new Cell(1, 7), new Cell(2, 5));

    }

    /**
     * test for check method move if way is occupied other figures.
     * @throws ImposibleMoveException -
     * @throws OccupiedWayException -
     * @throws FigureNotFoundException -
     */
    @Test(expected = OccupiedWayException.class)
    public void whenUseMoveButWayIsOccupied() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure firstElephant = new Elephant(new Cell(2, 7));
        Figure secondElephant = new Elephant(new Cell(6, 1));
        Figure firstRook = new Rook(new Cell(4, 5));
        Figure secondRook = new Rook(new Cell(8, 1));
        Figure[] figures = {firstElephant, firstRook, secondElephant, secondRook};
        Board board = new Board(figures);
        board.move(new Cell(2, 7), new Cell(6, 3));
    }

    /**
     * test for check method move if use legal figure's way.
     * @throws ImposibleMoveException -
     * @throws OccupiedWayException -
     * @throws FigureNotFoundException -
     */
    @Test
    public void whenUseMoveForLegalWayThenOk() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure firstElephant = new Elephant(new Cell(2, 7));
        Figure secondElephant = new Elephant(new Cell(6, 1));
        Figure firstRook = new Rook(new Cell(1, 1));
        Figure secondRook = new Rook(new Cell(8, 1));
        Figure[] figures = {firstElephant, firstRook, secondElephant, secondRook};
        Board board = new Board(figures);
        boolean result = board.move(new Cell(2, 7), new Cell(6, 3));
        boolean expected = true;
        assertThat(result, is(expected));
    }
}

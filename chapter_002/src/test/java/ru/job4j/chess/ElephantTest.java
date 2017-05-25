package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.ImposibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс ElephantTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.05.2017
 */
public class ElephantTest {
    /**
     * test for check method move if use legal figure's way.
     * @throws ImposibleMoveException -
     */
    @Test
    public void whenDoWayMethodThenGetArrayOfCells() throws ImposibleMoveException {
        Elephant figure = new Elephant(new Cell(4, 4));
        Cell[] result = figure.way(new Cell(1, 7));
        Cell[] expected = {new Cell(3, 5), new Cell(2, 6), new Cell(1, 7)};
        assertThat(result[0].equals(expected[0]), is(true));
    }
    /**
     * test for check method move if use illegal figure's way.
     * @throws ImposibleMoveException -
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenUseMoveButWayOfFigureIsIllegal() throws ImposibleMoveException {
        Elephant figure = new Elephant(new Cell(4, 4));
        figure.way(new Cell(2, 7));
    }
}

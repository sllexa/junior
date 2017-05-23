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
    @Test
    public void whenDoWayMethodThenGetArrayOfCells() throws ImposibleMoveException {
        Elephant figure = new Elephant(new Cell(4, 4));
        Cell[] result = figure.way(new Cell(1, 7));
        for (int i = 0; i <result.length; i++) {
            int x = result[i].getX();
            int y = result[i].getY();
            System.out.println(x + " " + y);
        }
        Cell[] expected = {new Cell(3, 5), new Cell(2, 6), new Cell(1, 7)};
        assertThat(result, is(expected));
    }
}

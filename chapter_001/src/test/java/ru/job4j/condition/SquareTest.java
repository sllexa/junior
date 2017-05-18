package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс SquareTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 18.05.2017
 */
public class SquareTest {
    /**
     * Тест метода isSquare.
     */
    @Test
    public void testSquareIsSquare() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(1, 3);
        Point pointC = new Point(3, 3);
        Point pointD = new Point(3, 1);
        Square square = new Square(pointA, pointB, pointC, pointD);
        assertThat(square.isSquare(), is(true));
    }
}

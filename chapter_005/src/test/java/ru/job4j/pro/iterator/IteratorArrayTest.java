package ru.job4j.pro.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class IteratorArrayTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 12.06.2017
 */
public class IteratorArrayTest {
    /**
     * Test method next for two-dimensional array.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        for (int i = 0; i < 4; i++) {
            it.next();
        }
        int result = (int) it.next();
        assertThat(result, is(5));
    }
    /**
     * Test method hasNext for two-dimensional array.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                assertThat(it.hasNext(), is(true));
            }
            it.next();
        }
        assertThat(it.hasNext(), is(false));
    }
}
package ru.job4j.pro.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class IteratorEvenNumbersArrayTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 14.06.2017
 */
public class IteratorEvenNumbersArrayTest {
    /**
     * Test method next.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        IteratorEvenNumbersArray it = new IteratorEvenNumbersArray(new int[] {1, 2, 5, 6, 9, 10});
        it.next();
        int result = (int) it.next();
        assertThat(result, is(6));
    }

    /**
     * Test method hasNext.
     */
    @Test
    public void whenCheckNextPositionShouldReturnTrue() {
        IteratorEvenNumbersArray it = new IteratorEvenNumbersArray(new int[] {1, 2, 5, 6, 9, 10});
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}
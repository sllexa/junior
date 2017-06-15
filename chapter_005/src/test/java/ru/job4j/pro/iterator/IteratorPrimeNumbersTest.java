package ru.job4j.pro.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class IteratorPrimeNumbersTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 15.06.2017
 */
public class IteratorPrimeNumbersTest {
    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        IteratorPrimeNumbers it = new IteratorPrimeNumbers(new int[] {2, 4, 215, 9, 5});
        it.next();
        int result = (int) it.next();
        assertThat(result, is(5));
    }
    /**
     * Test method hasNext().
     */
    @Test
    public void whenIteratorHasNextPrimeNumberThen() {
        IteratorPrimeNumbers it = new IteratorPrimeNumbers(new int[] {2, 4, 215, 9, 5});
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}
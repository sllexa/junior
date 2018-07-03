package ru.job4j.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
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
     * Iterator.
     */
    private Iterator<Integer> it;

    /**
     * Create new IteratorArray.
     */
    @Before
    public void setUp() {
        it = new IteratorPrimeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }

    /**
     * Test method expected.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Test methods hasNext and Next.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    /**
     * Test prime numbers.
     */
    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new IteratorPrimeNumbers(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }
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
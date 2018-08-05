package ru.job4j.pro.set;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ArraySetContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.07.2017
 */
public class ArraySetContainerTest {
    /**
     * Set container.
     */
    private ArraySetContainer<String> arraySet = new ArraySetContainer<>(3);
    /**
     * Iterator for set container.
     */
    private Iterator itr = arraySet.iterator();

    /**
     * Add elements.
     */
    @Before
    public void addElements() {
        arraySet.add("One");
        arraySet.add("Two");
        arraySet.add("Three");
    }

    /**
     * Test iterator.
     */
    @Test
    public void iteratorTest() {
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("One"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Two"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Three"));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test duplicate.
     */
    @Test
    public void duplicateTest() {
        arraySet.add("Two");
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("One"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Two"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Three"));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void noSuchElementExceptionTest() {
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("One"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Two"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Three"));
        assertThat(itr.next(), is("Four"));

    }
    /**
     * Test add method und iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        ArraySetContainer<Integer> set = new ArraySetContainer<>(4);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        Integer[] expected = {1, 2, 3, 4};
        Iterator itr = set.iterator();
        int ind = 0;
        while (itr.hasNext()) {
            assertThat(itr.next(), is(expected[ind++]));
        }
    }
}
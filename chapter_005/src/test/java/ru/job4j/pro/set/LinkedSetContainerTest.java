package ru.job4j.pro.set;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class LinkedSetContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.07.2017
 */
public class LinkedSetContainerTest {
    /**
     * Set container.
     */
    private LinkedSetContainer<String> container = new LinkedSetContainer<>();

    /**
     * Add elements.
     */
    @Before
    public void addElements() {
        container.add("One");
        container.add("Two");
        container.add("Three");
    }

    /**
     * Duplicate test.
     */
    @Test
    public void duplicateTest() {
        container.add("Three");
        Iterator itr = container.iterator();
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
    public void iteratorTest() {
        Iterator itr = container.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("One"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Two"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Three"));
        assertThat(itr.hasNext(), is(false));
        assertThat(itr.next(), is("Four"));
    }

    /**
     * Test add method and iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        LinkedSetContainer<Integer> set = new LinkedSetContainer<>();
        Integer[] arrStr = {100, 200, 200, 300, 400};

        for (Integer str : arrStr) {
            set.add(str);
        }

        Integer[] expected = {100, 200, 300, 400};
        Iterator itr = set.iterator();
        int ind = 0;
        while (itr.hasNext()) {
            assertThat(itr.next(), is(expected[ind++]));
        }
    }
}
package ru.job4j.pro.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class LinkedContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.06.2017
 */
public class LinkedContainerTest {
    /**
     * Create container.
     */
    private LinkedContainer<Integer> container = new LinkedContainer<>();

    /**
     * container filling.
     */
    @Before
    public void addElementsInContainer() {
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
    }

    /**
     * Test method get.
     */
    @Test
    public void whenGetItemByIndex() {
        assertThat(container.get(4), is(5));
    }

    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThrowNoSuchElementException() {
        Iterator<Integer> itr = container.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(3));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(4));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(5));
        assertThat(itr.hasNext(), is(false));
        assertThat(itr.next(), is(6));
    }

    /**
     * Test ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationCollection() {
        Iterator<Integer> iterator = container.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        container.add(6);
        assertThat(iterator.next(), is(6));
    }

    /**
     * Test add method and iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        LinkedContainer<String> linkCont = new LinkedContainer<>();
        String[] arrStr = {"001", "002", "003", "004"};

        for (String str : arrStr) {
            linkCont.add(str);
        }

        Iterator<String> itr = linkCont.iterator();
        String[] result = new String[arrStr.length];
        int ind = 0;
        while (itr.hasNext()) {
            result[ind++] = itr.next();
        }

        assertThat(result, is(arrStr));
    }

    /**
     * Test add and get method.
     */
    @Test
    public void whenAddElementsThenGetWithIndex() {
        LinkedContainer<String> linkCont = new LinkedContainer<>();
        String[] arrStr = {"001", "002", "003", "004"};

        for (String str : arrStr) {
            linkCont.add(str);
        }

        String[] result = new String[arrStr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = linkCont.get(i);
        }

        assertThat(result, is(arrStr));
    }
}
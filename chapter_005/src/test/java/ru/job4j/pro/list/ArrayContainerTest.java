package ru.job4j.pro.list;

import org.junit.Test;
import org.junit.Before;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.06.2017
 */
public class ArrayContainerTest {
    /**
     * Container for tests.
     */
    private ArrayContainer<Integer> container = new ArrayContainer<>(10);

    /**
     * container filling.
     */
    @Before
    public void setUp() {
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
        container.add(10);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddTeenAndElevenElement() {
        container.add(11);
        container.add(12);
        assertThat(container.get(11), is(12));
    }

    /**
     * Test method get of index.
     */
    @Test
    public void whenGetIndex() {
        assertThat(container.get(0), is(1));
        assertThat(container.get(8), is(9));
        assertThat(container.get(5), is(6));
    }

    /**
     * Test Iterator methods hasNext and Next.
     */
    @Test
    public void whenHasNextIsTrueAndNextHaveNextElements() {
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(1));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(2));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(3));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(4));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(5));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(6));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(7));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(8));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(9));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is(10));
        assertThat(container.iterator().hasNext(), is(false));
    }

    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThrowNoSuchElementException() {
        assertThat(container.iterator().next(), is(1));
        assertThat(container.iterator().next(), is(2));
        assertThat(container.iterator().next(), is(3));
        assertThat(container.iterator().next(), is(4));
        assertThat(container.iterator().next(), is(5));
        assertThat(container.iterator().next(), is(6));
        assertThat(container.iterator().next(), is(7));
        assertThat(container.iterator().next(), is(8));
        assertThat(container.iterator().next(), is(9));
        assertThat(container.iterator().next(), is(10));
        assertThat(container.iterator().next(), is(11));
    }

    /**
     * Test ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorThrowConcurrentModificationException() {
        assertThat(container.iterator().next(), is(1));
        assertThat(container.iterator().next(), is(2));
        assertThat(container.iterator().next(), is(3));
        assertThat(container.iterator().next(), is(4));
        assertThat(container.iterator().next(), is(5));
        assertThat(container.iterator().next(), is(6));
        assertThat(container.iterator().next(), is(7));
        assertThat(container.iterator().next(), is(8));
        assertThat(container.iterator().next(), is(9));
        assertThat(container.iterator().next(), is(10));
        container.add(11);
        assertThat(container.iterator().next(), is(11));
    }
    /**
     * Test array container.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsThenGetWithIterator() {
        ArrayContainer<String> arrCont = new ArrayContainer<>(2);
        String[] strArr = {"001", "002", "003", "004"};

        for (String str : strArr) {
            arrCont.add(str);
        }

        Iterator it = arrCont.iterator();
        int ind = 0;
        while (it.hasNext()) {
            assertThat(it.next(), is(strArr[ind++]));
        }
    }
}
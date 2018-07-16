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
     * Create Iterator container.
     */
    private Iterator itr = container.iterator();
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
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(6));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(7));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(8));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(9));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(10));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThrowNoSuchElementException() {
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
        assertThat(itr.next(), is(4));
        assertThat(itr.next(), is(5));
        assertThat(itr.next(), is(6));
        assertThat(itr.next(), is(7));
        assertThat(itr.next(), is(8));
        assertThat(itr.next(), is(9));
        assertThat(itr.next(), is(10));
        assertThat(itr.next(), is(11));
    }

    /**
     * Test ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorThrowConcurrentModificationException() {
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
        assertThat(itr.next(), is(4));
        assertThat(itr.next(), is(5));
        assertThat(itr.next(), is(6));
        assertThat(itr.next(), is(7));
        assertThat(itr.next(), is(8));
        assertThat(itr.next(), is(9));
        assertThat(itr.next(), is(10));
        container.add(11);
        assertThat(itr.next(), is(11));
    }

    /**
     * Bad test.
     */
    @Test
    public void badTest() {
        Iterator<Integer> iterator1 = container.iterator();
        int a = iterator1.next();
        assertThat(a, is(1));
        Iterator<Integer> iterator2 = container.iterator();
        int b = iterator2.next();
        assertThat(b, is(1));
    }
    /**
     * Test array container.
     */
    @Test
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
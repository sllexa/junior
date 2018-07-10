package ru.job4j.pro.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayListTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.07.2018
 */
public class SimpleArrayListTest {
    /**
     * List type Integer.
     */
    private SimpleArrayList<Integer> list;

    /**
     * Create new list.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Test method get.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Test method getSize.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Test method delete.
     */
    @Test
    public void whenAddThreeElementsDeleteThenUseGetOneResultTwo() {
        //list.delete();
        assertThat(list.delete(), is(3));
        assertThat(list.delete(), is(2));
        assertThat(list.getSize(), is(1));
    }
}
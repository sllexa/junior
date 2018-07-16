package ru.job4j.pro.set;

import org.junit.Test;
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
     * Test add method und iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        ArraySetContainer<Integer> set = new ArraySetContainer<>(4);
        //Integer[] arrInt = {100, 200, 300, 400};
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        /*for (Integer ival : arrInt) {
            set.add(ival);
        }*/

        Integer[] expected = {1, 2, 3, 4};
        Iterator itr = set.iterator();
        assertThat(itr.next(), is(4));
/*        int ind = 0;

        while (itr.hasNext()) {
            assertThat(itr.next(), is(expected[ind++]));
        }*/
    }
}
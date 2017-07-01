package ru.job4j.pro.set;

import org.junit.Test;

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
     * Test add method and iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        LinkedSetContainer<String> set = new LinkedSetContainer<>();
        String[] arrStr = {"100", "200", "200", "300", "400"};

        for (String str : arrStr) {
            set.add(str);
        }

        String[] expected = {"100", "200", "300", "400"};
        Iterator itr = set.iterator();
        int ind = 0;
        while (itr.hasNext()) {
            assertThat(itr.next(), is(expected[ind++]));
        }
    }
}
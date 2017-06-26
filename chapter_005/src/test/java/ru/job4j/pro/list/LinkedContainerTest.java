package ru.job4j.pro.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class LinkedContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.06.2017
 */
public class LinkedContainerTest {
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
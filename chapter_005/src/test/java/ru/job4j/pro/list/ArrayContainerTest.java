package ru.job4j.pro.list;

import org.junit.Test;

import java.util.Iterator;

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
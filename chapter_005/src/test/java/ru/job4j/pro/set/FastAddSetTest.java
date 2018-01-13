package ru.job4j.pro.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FastAddSetTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 07.07.2017
 */
public class FastAddSetTest {
    /**
     * Test add method and iterator.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        FastAddSet<String> set = new FastAddSet<>(2);
        String[] arrStr = {"000", "001", "000", "003", "002", "001", "002"};

        for (String str : arrStr) {
            set.add(str);
        }

        String[] expected = {"000", "001", "002", "003"};
        Iterator<String> itr = set.iterator();

        String[] result = new String[4];
        int ind = 0;
        while (itr.hasNext()) {
            result[ind++] = itr.next();
        }

        assertThat(result, is(expected));
    }

    /**
     * Measure the speed of adding elements.
     */
    @Test
    public void whenAddElementsThenTrue() {
        long fastTime = addFastTime();
        long setTime = addSetTime();

        assertThat(fastTime < setTime, is(true));
    }

    /**
     * Measure the speed of adding elements.
     * @return - time
     */
    private long addFastTime() {
        FastAddSet<Integer> set = new FastAddSet<>(2);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            set.add(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    /**
     * Measure the speed of adding elements.
     * @return - time
     */
    private long addSetTime() {
        ArraySetContainer<Integer> set = new ArraySetContainer<>(2);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            set.add(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
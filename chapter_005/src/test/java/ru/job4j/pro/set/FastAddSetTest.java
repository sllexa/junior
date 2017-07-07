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
        FastAddSet<String> set = new FastAddSet<>();
        String[] arrStr = {"003", "001", "000", "003", "002", "001", "002"};

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
}
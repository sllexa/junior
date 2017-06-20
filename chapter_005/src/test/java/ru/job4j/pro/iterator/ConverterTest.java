package ru.job4j.pro.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 16.06.2017
 */
public class ConverterTest {
    /**
     * Test method convert(Iterator<Iterator<Integer>> it).
     */
    @Test
    public void whetConvertIteratorThenIterator() {
        final Iterator<Integer> itr1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        final Iterator<Integer> itr2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        final Iterator<Integer> itr3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();

        final List<Iterator<Integer>> list = new ArrayList<>();
        list.addAll(Arrays.asList(itr1, itr2, itr3));

        final Iterator<Iterator<Integer>> itr = list.iterator();
        final Iterator<Integer> result = new Converter().convert(itr);
        final Iterator<Integer> expected = Arrays.asList(
                4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4
        ).iterator();
        while (result.hasNext()) {
            assertThat(result.next(), is(expected.next()));
        }
    }
}
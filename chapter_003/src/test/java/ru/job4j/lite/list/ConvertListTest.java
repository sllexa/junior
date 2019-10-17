package ru.job4j.lite.list;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertListTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.06.2018
 */
public class ConvertListTest {
    /**
     * test convert list of arrays to one ArrayList.
     */
    @Test
    public void when2And4ElementsThen6() {
        ConvertList clist = new ConvertList();
        List<int[]> list = List.of(
                new int[] {9, 8},
                new int[] {7, 6, 5, 4},
                new int[] {3, 2, 1}
        );
        List<Integer> result = clist.convert(list);
        List<Integer> expect = List.of(9, 8, 7, 6, 5, 4, 3, 2, 1);
        assertThat(result, is(expect));
    }
}

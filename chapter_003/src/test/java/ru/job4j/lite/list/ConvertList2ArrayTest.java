package ru.job4j.lite.list;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertList2ArrayTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2018
 */
public class ConvertList2ArrayTest {
    /**
     * Test class ConvertList2Array.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(List.of(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expect));
    }
}

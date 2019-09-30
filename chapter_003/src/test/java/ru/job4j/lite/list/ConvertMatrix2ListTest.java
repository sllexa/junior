package ru.job4j.lite.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertMatrix2ListTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2018
 */
public class ConvertMatrix2ListTest {
    /**
     * Testing the toList method from the ConvertMatrix2List class.
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {{1, 2}, {3, 4}};
        List<Integer> result = list.toList(input);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expect));
    }
}

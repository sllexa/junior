package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertMatrixTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.10.2019
 */
public class ConvertMatrixTest {
    /**
     * Test convert a matrix of numbers to a list of numbers.
     */
    @Test
    public void whenMatrixIntegerThenListInteger() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = new ArrayList<>();
        ConvertMatrix conmat = new ConvertMatrix();
        List<Integer> result = conmat.convert(matrix);
        for (Integer[] row : matrix) {
            expected.addAll(Arrays.asList(row));
        }
        assertThat(result, is(expected));
    }
}
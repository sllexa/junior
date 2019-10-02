package ru.job4j.labmda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FunctionDiapasonTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.10.2019
 */
public class FunctionDiapasonTest {
    /**
     * Test linear function.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Test quadratic function.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    /**
     * Test logarithmic function.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(1, 4, x -> Math.rint(Math.log(x)));
        List<Double> expected = Arrays.asList(0D, 1D, 1D);
        assertThat(result, is(expected));
    }
}
package ru.job4j.labmda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class FunctionDiapason.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.10.2019
 */
public class FunctionDiapason {
    /**
     * Count function in range.
     * @param start - start range
     * @param end - end range
     * @param func - function
     * @return - list values
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}

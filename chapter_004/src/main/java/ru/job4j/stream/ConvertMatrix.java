package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class ConvertMatrix.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.10.2019
 */
public class ConvertMatrix {
    /**
     * Convert a matrix of numbers to a list of numbers.
     * @param matrix - matrix numbers
     * @return - list numbers
     */
    List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}

package ru.job4j.stream;

import java.util.Arrays;

/**
 * Class StreamApi.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.10.2019
 */
public class StreamApi {
    /**
     * Leave only even numbers. Square each number. And sum up all the elements.
     * @param array - array
     * @return - sum of all elements
     */
    int sumAll(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .reduce(0, (x, y) -> x + y * y);
    }
}

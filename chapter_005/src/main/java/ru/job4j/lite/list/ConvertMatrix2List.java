package ru.job4j.lite.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertMatrix2List.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2018
 */
public class ConvertMatrix2List {
    /**
     * Convert two-dimensional Array to ArrayList.
     * @param array - two-dimensional.
     * @return - ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}

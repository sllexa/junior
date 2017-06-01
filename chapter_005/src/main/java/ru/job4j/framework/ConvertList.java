package ru.job4j.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class ConvertList.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 29.05.2017
 */
public class ConvertList {
    /**
     * Convert two-dimensional Array to ArrayList.
     * @param array - two-dimensional
     * @return - ArrayList
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Convert ArrayList to two-dimensional Array.
     * @param list for convert.
     * @param rows - number of rows in two-dimensional Array.
     * @return converted two-dimensional Array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cols;
        if (list.size() % rows == 0) {
            cols = list.size() / rows;
        } else {
            cols = list.size() / rows + 1;
        }
        int[][] array = new int[rows][cols];
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (itr.hasNext()) {
                    array[i][j] = itr.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
    /**
     * Convert list of arrays to one ArrayList.
     * @param list for convert.
     * @return converted ArrayList.
     */
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int i = 0; i < array.length; i++) {
                result.add(array[i]);
            }
        }
        return result;
    }
}

package ru.job4j.lite.list;

import java.util.List;

/**
 * Class ConvertList2Array.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.06.2018
 */
public class ConvertList2Array {
    /**
     * Convert ArrayList to two-dimensional array.
     * @param list - for convert.
     * @param rows - number of rows in two-dimensional array.
     * @return - converted two-dimensional array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;

        for (Integer num : list) {
            if (j == cells) {
                i++;
                j = 0;
            }
            if (num == null) {
                num = 0;
            }
            array[i][j++] = num;
        }
        return array;
    }
}

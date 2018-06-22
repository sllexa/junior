package ru.job4j.lite.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.06.2018
 */
public class ConvertList {
    /**
     * Convert list of arrays to one ArrayList.
     * @param list - for convert.
     * @return - converted ArrayList.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int num : array) {
                result.add(num);
            }
        }
        return result;
    }
}

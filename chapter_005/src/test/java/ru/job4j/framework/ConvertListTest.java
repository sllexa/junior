package ru.job4j.framework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertListTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.05.2017
 */
public class ConvertListTest {
    /**
     * test convert two-dimensional Array to List.
     */
    @Test
    public void whenConvertArrayToListThenList() {
        int[][] arSource = {{9, 8, 7}, {6, 5}, {4, 3, 2, 1}};
        ConvertList conList = new ConvertList();
        List<Integer> resList = conList.toList(arSource);
        List<Integer> expList = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            expList.add(i);
        }
        assertThat(resList, is(expList));
    }

    /***
     * test convert ArrayList to two-dimensional Array.
     */
    @Test
    public void whenConvertListToArrayThenArray() {
        ConvertList conList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 2; i--) {
            list.add(i);
        }
        int[][] resArray = conList.toArray(list, 3);
        int[][] expArray = {{9, 8, 7}, {6, 5, 4}, {3, 0, 0}};
        assertThat(resArray, is(expArray));
    }
}

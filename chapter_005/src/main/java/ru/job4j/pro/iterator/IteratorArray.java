package ru.job4j.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorArray.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 11.06.2017
 */
public class IteratorArray implements Iterator {
    /**
     * Two-dimensional array.
     */
    private final int[][] value;
    /**
     * First index.
     */
    private int ind1 = 0;
    /**
     * Second index.
     */
    private int ind2 = 0;

    /**
     * Constructor.
     * @param value - two-dimensional array.
     */
    public IteratorArray(int[][] value) {
        this.value = value;
    }

    /**
     * Override method hasNext for two-dimensional array.
     * @return
     */
    @Override
    public boolean hasNext() {
        return value.length > ind1 && value[0].length > ind2;
    }

    /**
     * Override method next for two-dimensional array.
     * @return - array.
     */
    @Override
    public Object next() {
        Object result = value[ind1][ind2++];

        if (ind2 >= value[ind1].length) {
            ind1++;
            ind2 = 0;
        }
        return result;
    }
}

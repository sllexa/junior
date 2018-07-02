package ru.job4j.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        return this.value.length > this.ind1;
    }

    /**
     * Override method next for two-dimensional array.
     * @return - array.
     */
    @Override
    public Object next() {
        if (this.ind1 >= this.value.length) {
            throw new NoSuchElementException();
        }

        Object result = this.value[ind1][ind2++];
        if (ind2 >= this.value[ind1].length) {
            this.ind1++;
            this.ind2 = 0;
        }
        return result;
    }
}

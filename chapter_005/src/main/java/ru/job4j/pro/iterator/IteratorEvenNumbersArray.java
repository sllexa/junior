package ru.job4j.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorEvenNumbersArray.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 14.06.2017
 */
public class IteratorEvenNumbersArray implements Iterator {
    /**
     * Array.
     */
    private final int[] values;
    /**
     * Index for array.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param values - array.
     */
    public IteratorEvenNumbersArray(final int[] values) {
        this.values = values;
    }

    /**
     * Override method hasNext for array.
     * @return - boolean.
     */
    @Override
    public boolean hasNext() {
        return this.getEvenIndex() != -1;
    }

    /**
     * Override method next for array.
     * @return - array.
     */
    @Override
    public Object next() {

        this.index = this.getEvenIndex();
        Object result = this.values[this.index];
        this.index++;
        return result;
    }

    /**
     * Method getter index.
     * @return - index.
     */
    private int getEvenIndex() {
        int result = -1;

        for (int i = this.index; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}



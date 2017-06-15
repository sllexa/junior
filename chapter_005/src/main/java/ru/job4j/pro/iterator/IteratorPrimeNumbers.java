package ru.job4j.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorPrimeNumbers.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 15.06.2017
 */
public class IteratorPrimeNumbers implements Iterator {
    /**
     * Array of ints.
     */
    private final int[] values;
    /**
     * Index of array.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param values - array.
     */
    public IteratorPrimeNumbers(int[] values) {
        this.values = values;
    }
    /**
     * Check next number.
     * @return true if iterator has next prime number.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.index >= this.values.length) {
            result = false;
        } else {
            int num = this.index;
            while (num < this.values.length) {
                if (this.isPrimeNumber(this.values[num])) {
                    result = true;
                    num = this.values.length;
                } else {
                    num++;
                }
            }
        }
        return result;
    }
    /**
     * Get next prime number.
     * @return next prime number.
     */
    @Override
    public Object next() {
        Object result = null;
        while (this.index < this.values.length) {
            if (this.isPrimeNumber(this.values[this.index])) {
                result = this.values[this.index];
                break;
            }
            this.index++;
        }
        this.index++;
        return result;
    }

    /**
     * The method checks this prime number.
     * @param num - number.
     * @return - true or false.
     */
    private boolean isPrimeNumber(int num) {
        boolean result = true;
        if (num == 0 || num == 1) {
            result = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    result = false;
                }
            }
        }
        return result;
    }
}

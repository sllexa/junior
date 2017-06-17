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
        return this.getPrimeIndex() != -1;
    }
    /**
     * Get next prime number.
     * @return next prime number.
     */
    @Override
    public Object next() {

        this.index = this.getPrimeIndex();
        Object result = this.values[this.index];
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

    /**
     * Will find the index of a prime number.
     * @return - prime index.
     */
    private int getPrimeIndex() {
        int result = -1;
        for (int i = this.index; i < this.values.length; i++) {
            if (this.isPrimeNumber(this.values[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
}

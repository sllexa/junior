package ru.job4j.pro.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2017
 * @param <T> - generic
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Array of objects.
     */
    private Object[] arr;
    /**
     * Index array.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size - array size.
     */
    public SimpleArray(int size) {
        this.arr = new Object[size];
    }

    /**
     * Add Item.
     * @param value - new value.
     */
    public void add(T value) {
        if (this.index >= this.arr.length) {
            throw new RuntimeException("Overflow");
        }
        this.arr[this.index++] = value;
    }

    /**
     * Update value.
     * @param position - number cell.
     * @param value - new value.
     */
    public void update(int position, T value) {
        if (position < 0 || position >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        this.arr[position] = value;
    }

    /**
     * Delete Item.
     * @param position - number cell.
     */
    public void delete(int position) {
        if (position < 0 || position >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(this.arr, position + 1, this.arr, position, this.index - position - 1);
        if (this.arr.length - 1 >= position) {
            this.arr[this.index - 1] = null;
        }
        this.index--;
    }

    /**
     * Get value.
     * @param position - number cell.
     * @return - value.
     */
    public T get(int position) {
        if (position < 0 || position >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.arr[position];
    }

    /**
     * Get size array.
     * @return - number
     */
    public int getSize() {
        return this.arr.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new SampleArrIterator(index, (Iterator<T>) Arrays.stream(this.arr).iterator());
    }

    /**
     * Inner class for iterator.
     */
    private class SampleArrIterator implements Iterator {
        /**
         * size.
         */
        private int size;
        /**
         * index.
         */
        private int ind;
        /**
         * object iterator.
         */
        private Iterator<T> arrIterator;

        /**
         * Constructor.
         * @param size -
         * @param arrIterator -
         */
        SampleArrIterator(int size, Iterator<T> arrIterator) {
            this.size = size;
            this.ind = 0;
            this.arrIterator = arrIterator;
        }

        @Override
        public boolean hasNext() {
            return ind <= size && arrIterator.hasNext();
        }

        @Override
        public T next() {
            if (ind > size - 1) {
                throw new NoSuchElementException("index lower than size");
            }
            ind++;
            return arrIterator.next();
        }
    }
}

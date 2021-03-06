package ru.job4j.pro.generic;

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
        return new Iterator<T>() {
            private int ind = 0;

            @Override
            public boolean hasNext() {
                return arr.length > ind;
            }

            @Override
            public T next() {
                if (ind >= arr.length || arr[ind] == null) {
                    throw new NoSuchElementException("index lower than size");
                }
                return (T) arr[ind++];
            }
        };
    }
}

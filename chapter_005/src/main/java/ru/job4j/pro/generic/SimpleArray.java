package ru.job4j.pro.generic;

/**
 * Class SimpleArray.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2017
 * @param <T> - generic
 */
public class SimpleArray<T> {
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
        this.arr[this.index++] = value;
    }

    /**
     * Update value.
     * @param position - number cell.
     * @param value - new value.
     */
    public void update(int position, T value) {
        this.arr[position] = value;
    }

    /**
     * Delete Item.
     * @param position - number cell.
     */
    public void delete(int position) {
        System.arraycopy(this.arr, position + 1, this.arr, position, this.index - position - 1);
        if (this.arr.length - 1 >= position) {
            this.arr[this.index - 1] = null;
        }
    }

    /**
     * Get value.
     * @param position - number cell.
     * @return - value.
     */
    public T get(int position) {
        return (T) this.arr[position];
    }
}

package ru.job4j.pro.list;

import java.util.Iterator;

/**
 * Class ArrayContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.06.2017
 * @param <E> - generic
 */
public class ArrayContainer<E> implements SimpleContainer<E> {
    /**
     * Array of object.
     */
    private Object[] container;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size - size of array
     */
    public ArrayContainer(int size) {
        this.container = new Object[size];
    }

    /**
     * Expand size of array in doubly.
     */
    private void expand() {
        if (this.index == this.container.length) {
            Object[] newc = new Object[this.container.length * 2];
            System.arraycopy(this.container, 0, newc, 0, this.container.length);
            this.container = newc;
        }
    }

    /**
     * Add method.
     * @param value - value
     */
    @Override
    public void add(E value) {
        this.expand();
        this.container[this.index++] = value;
    }

    /**
     * Get method.
     * @param index - index
     * @return - value
     */
    @Override
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Get iterator for passing container.
     * @return - iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itInd;

            @Override
            public boolean hasNext() {
                return index > this.itInd;
            }

            @Override
            public E next() {
                return (E) container[this.itInd++];
            }
        };
    }
}

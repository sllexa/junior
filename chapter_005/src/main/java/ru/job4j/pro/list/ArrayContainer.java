package ru.job4j.pro.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArrayContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.06.2017
 * @param <E> - generic
 */
public class ArrayContainer<E> implements Iterable<E> {
    /**
     * Array of object.
     */
    private Object[] container;
    /**
     * Index.
     */
    private int index = 0;
    /**
     * collection size change counter.
     */
    private int modCount = 0;
    /**
     * Index Iterator.
     */
    private int itInd;
    /**
     * Expected size collection.
     */
    private int expectedModCount = modCount;

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
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
            this.modCount++;
        }
    }

    /**
     * Add method.
     * @param value - value
     */
    public void add(E value) {
        this.expand();
        this.container[this.index++] = value;
    }

    /**
     * Get method.
     * @param index - index
     * @return - value
     */
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

            @Override
            public boolean hasNext() {
                return index > itInd;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException("this collection has undergone a change");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("there is no next element");
                }
                return (E) container[itInd++];
            }
        };
    }
}

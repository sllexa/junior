package ru.job4j.pro.set;

import java.util.Iterator;

/**
 * Class FastAddSet.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.07.2017
 * @param <E> - type of set
 */
public class FastAddSet<E> implements SampleSet<E> {
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
    public FastAddSet(int size) {
        this.container = new Object[size];
    }

    /**
     * Method add object in array.
     * @param elem for adding.
     */
    @Override
    public void add(E elem) {
        this.expand();
        int ind = (elem.hashCode() & 0x7FFFFFFF) % this.container.length;
        if (this.container[ind] == null) {
            this.container[ind] = elem;
            this.index++;
        }
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
     * Get iterator for passing container.
     * @return - iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itInd;

            @Override
            public boolean hasNext() {
                return index > itInd;
            }

            @Override
            public E next() {
                return (E) container[this.itInd++];
            }
        };
    }
}

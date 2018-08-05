package ru.job4j.pro.set;

import ru.job4j.pro.list.ArrayContainer;

import java.util.Iterator;

/**
 * Class ArraySetContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.07.2017
 * @param <E> - type
 */
public class ArraySetContainer<E> implements Iterable<E> {
    /**
     * Container.
     */
    private ArrayContainer<E> container;

    /**
     * Constructor.
     * @param size - size of array
     */
    public ArraySetContainer(int size) {
        this.container = new ArrayContainer<>(size);
    }

    /**
     * Add method.
     * @param value - value
     */
    public void add(E value) {
        if (!this.duplicate(value)) {
            this.container.add(value);
        }
    }

    /**
     * Check duplicate.
     * @param value - value.
     * @return - true if contains element
     */
    private boolean duplicate(E value) {
        boolean result = false;
        Iterator<E> itr = this.container.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        Iterator<E> itr = this.container.iterator();
        return new Iterator() {

            @Override
            public boolean hasNext() {
                return itr.hasNext();
            }

            @Override
            public E next() {
                return itr.next();
            }
        };
    }
}

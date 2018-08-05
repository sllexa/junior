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
public class ArraySetContainer<E> extends ArrayContainer<E> {

    /**
     * Constructor.
     * @param size - size of array
     */
    public ArraySetContainer(int size) {
        super(size);
    }

    /**
     * Add method.
     * @param value - value
     */
    @Override
    public void add(E value) {
        if (!this.duplicate(value)) {
            super.add(value);
        }
    }

    /**
     * Check duplicate.
     * @param value - value.
     * @return - true if contains element
     */
    private boolean duplicate(E value) {
        boolean result = false;
        Iterator<E> itr = super.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

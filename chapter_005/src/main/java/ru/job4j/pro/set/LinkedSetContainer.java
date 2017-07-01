package ru.job4j.pro.set;

import ru.job4j.pro.list.LinkedContainer;

import java.util.Iterator;

/**
 * Class LinkedSetContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.07.2017
 * @param <E> - type
 */
public class LinkedSetContainer<E> extends LinkedContainer<E> {

    /**
     * Add method.
     * @param value - value
     */
    @Override
    public void add(E value) {
        if (value != null && !this.duplicate(value)) {
            super.add(value);
        }
    }
    /**
     * Check duplicate.
     * @param value - value
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

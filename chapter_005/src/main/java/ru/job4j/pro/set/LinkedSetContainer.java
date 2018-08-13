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
public class LinkedSetContainer<E> implements Iterable<E> {
    /**
     * Container for set.
     */
    private LinkedContainer<E> container = new LinkedContainer<>();

    /**
     * Add method.
     * @param value - value
     */
    public void add(E value) {
        if (value != null && !this.duplicate(value)) {
            this.container.add(value);
        }
    }
    /**
     * Check duplicate.
     * @param value - value
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
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}

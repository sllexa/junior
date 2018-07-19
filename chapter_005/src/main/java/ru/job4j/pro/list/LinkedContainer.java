package ru.job4j.pro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 * Class LinkedContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.06.2017
 * @param <E> - type
 */
public class LinkedContainer<E> implements Iterable<E> {
    /**
     * Size container.
     */
    private int size = 0;
    /**
     * First element.
     */
    private Unit<E> first;
    /**
     * Last element.
     */
    private Unit<E> last;
    /**
     * Container modifier.
     */
    private int modCount = 0;

    /**
     * Add method.
     * @param value - value
     */
    public void add(E value) {
        Unit<E> l = this.last;
        Unit<E> newUnit = new Unit<>(l, value, null);
        this.last = newUnit;
        if (l == null) {
            this.first = newUnit;
        } else {
            l.next = newUnit;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Get method.
     * @param index - index
     * @return - E value
     */
    public E get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Unit<E> x = this.first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.item;
    }

    /**
     * Iterator container.
     * @return - iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Unit<E> elem = first;

            @Override
            public boolean hasNext() {
                return this.elem != null;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException("this collection has undergone a change");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = this.elem.item;
                this.elem = this.elem.next;
                return value;
            }
        };
    }

    /**
     * Links e as first element.
     * @param e - value
     */
    public void linkFirst(E e) {
        final Unit<E> f = first;
        final Unit<E> newUnit = new Unit<>(null, e, f);
        first = newUnit;
        if (f == null) {
            last = newUnit;
        } else {
            f.prev = newUnit;
        }
        size++;
    }

    /**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        final Unit<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * @return - element
     */
    public E poll() {
        final Unit<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
    /**
     * Unlinks non-null first unit f.
     * @param f - first element
     * @return - value
     */
    private E unlinkFirst(Unit<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Unit<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        this.modCount++;
        return element;
    }
    /**
     * Unit - of LinkedList.
     * @param <E> - type value
     */
    private static class Unit<E> {
        /**
         * Element.
         */
        private E item;
        /**
         * Next.
         */
        private Unit<E> next;
        /**
         * Previous.
         */
        private Unit<E> prev;

        /**
         * Constructor.
         * @param prev - link previous element
         * @param element - link current element
         * @param next - link next element
         */
        Unit(Unit<E> prev, E element, Unit<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

package ru.job4j.pro.list;

import java.util.Iterator;

/**
 * Class LinkedContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.06.2017
 * @param <E> - type
 */
public class LinkedContainer<E> implements SimpleContainer<E> {
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
    //private int linkMod = 0;

    /**
     * Add method.
     * @param value - value
     */
    @Override
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
        //this.linkMod++;
    }

    /**
     * Get method.
     * @param index - index
     * @return - E value
     */
    @Override
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

            private Unit<E> elem = first;
            @Override
            public boolean hasNext() {
                return this.elem != null;
            }

            @Override
            public E next() {
                E value = this.elem.item;
                this.elem = this.elem.next;
                return value;
            }
        };
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

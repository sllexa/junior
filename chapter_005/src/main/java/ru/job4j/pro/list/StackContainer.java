package ru.job4j.pro.list;

/**
 * Class StackContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.06.2017
 * @param <E> - type
 */
public class StackContainer<E> extends LinkedContainer<E> {
    /**
     * Pushes an element.
     * @param e - element to push
     * @return - element
     */
    public E push(E e) {
        super.linkFirst(e);
        return e;
    }

    /**
     * Removes and returns the first element.
     * @return - element
     */
    public E pop() {
        return super.poll();
    }
}

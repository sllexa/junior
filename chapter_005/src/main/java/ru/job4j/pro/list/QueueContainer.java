package ru.job4j.pro.list;

/**
 * Class QueueContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.06.2017
 * @param <E> - type
 */
public class QueueContainer<E> extends LinkedContainer<E> {
    /**
     * Add first element.
     * @param e - element
     */
    public void push(E e) {
        super.add(e);
    }
    /**
     * Removes and returns the first element.
     * @return - element
     */
    public E poll() {
        return super.poll();
    }
}

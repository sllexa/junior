package ru.job4j.pro.list;

/**
 * Class SimpleContainer.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.06.2017
 * @param <E> - generic
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add method.
     * @param value - value
     */
    void add(E value);

    /**
     * Get method.
     * @param index - index
     * @return - value.
     */
    E get(int index);
}

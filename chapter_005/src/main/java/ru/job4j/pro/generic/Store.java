package ru.job4j.pro.generic;

/**
 * Class Store.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.06.2017
 * @param <T> - generic
 */
public interface Store<T extends Base> {

    /**
     * Add method.
     * @param value - value.
     */
    void add(T value);

    /**
     * Update method.
     * @param position - of Base object.
     * @param value - new value.
     */
    void update(int position, T value);

    /**
     * Delete method.
     * @param position - of element.
     */
    void delete(int position);

    /**
     * Get method.
     * @param position - position.
     * @return - value.
     */
    T get(int position);
}

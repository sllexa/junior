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
     * @param id - of Base object.
     * @param value - new value.
     */
    void update(String id, T value);

    /**
     * Delete method.
     * @param id - of element.
     */
    void delete(String id);

    /**
     * Get method.
     * @param id - position.
     * @return - value.
     */
    T get(String id);
}

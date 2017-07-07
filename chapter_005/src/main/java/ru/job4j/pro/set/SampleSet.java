package ru.job4j.pro.set;

/**
 * Class SampleSet.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.07.2017
 * @param <E> - type
 */
public interface SampleSet<E> extends Iterable<E> {
    /**
     * Add element to set.
     * @param elem for adding.
     */
    void add(E elem);
}

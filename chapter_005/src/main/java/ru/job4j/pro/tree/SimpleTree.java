package ru.job4j.pro.tree;

import java.util.Optional;

/**
 * Class SimpleTree.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.08.2018
 * @param <E> - generic
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Method add.
     * @param parent - type E
     * @param child - type E
     * @return - true or false
     */
    boolean add(E parent, E child);

    /**
     * Method findBy.
     * @param value - type E
     * @return - Optional object
     */
    Optional<Node<E>> findBy(E value);
}

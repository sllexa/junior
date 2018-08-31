package ru.job4j.pro.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Node.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.08.2018
 * @param <E> - generic
 */
public class Node<E extends Comparable<E>> {
    /**
     * List subcategory.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Value.
     */
    private final E value;

    /**
     * Constructor.
     * @param value - value
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Method getValue.
     * @return - E value
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Add method.
     * @param child - Node<E> child
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Method leaves.
     * @return - List<Node<E>>
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Method eqValue.
     * @param that - type E
     * @return - true or false
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}

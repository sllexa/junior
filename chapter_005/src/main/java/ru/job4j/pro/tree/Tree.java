package ru.job4j.pro.tree;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Class Tree.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 26.08.2018
 * @param <E> generic
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Element tree.
     */
    private Node<E> root;
    /**
     * Counter.
     */
    private int size;

    /**
     * Override method add.
     * @param parent - type E
     * @param child - type E
     * @return - true or false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (this.root == null) {
            this.root = new Node<>(parent);
            this.root.add(new Node<>(child));
            this.size = 1;
            result = true;
        } else {
            if (this.findBy(parent).isPresent() && !this.findBy(child).isPresent()) {
                this.findBy(parent).get().add(new Node<>(child));
                this.size++;
                result = true;
            }
        }
        return result;
    }

    /**
     * Override method findBy.
     * @param value - type E
     * @return - Optional object
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Override method iterator.
     * @return - Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> data = new LinkedList<>();
            private boolean n = this.data.offer(root);

            @Override
            public boolean hasNext() {
                return !this.data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = this.data.poll();
                for (Node<E> element : result.leaves()) {
                    this.data.offer(element);
                }
                return result.getValue();
            }
        };
    }
}

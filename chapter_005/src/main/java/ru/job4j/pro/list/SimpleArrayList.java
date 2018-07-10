package ru.job4j.pro.list;

/**
 * Class SimpleArrayList.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.07.2018
 * @param <E> - type data.
 */
public class SimpleArrayList<E> {
    /**
     * Size of collection.
     */
    private int size;
    /**
     * First element in the collection.
     */
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     * @param date - type data.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method delete.
     * @return - type E.
     */
    public E delete() {
        Node<E> result = this.first;
        this.first = this.first.next;
        this.size--;
        return result.date;
    }

    /**
     * Метод получения элемента по индексу.
     * @param index - number type int.
     * @return - type E.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     * @return - type int.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     * @param <E> - type data.
     */
    private static class Node<E> {
        /**
         * data for storage.
         */
        private E date;
        /**
         * Next element.
         */
        private Node<E> next;

        /**
         * Constructor.
         * @param date - data.
         */
        Node(E date) {
            this.date = date;
        }
    }
}

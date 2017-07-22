package ru.job4j.pro.map;

import java.util.Iterator;

/**
 * Class Directory.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 13.07.2017
 * @param <K> - type of key
 * @param <V> - type of value
 */
public class Directory<K, V> {
    /**
     * Array of nodes.
     */
    private Node<K, V>[] table;
    /**
     * This field orders count add Object.
     */
    private int count = 0;

    /**
     * Constructor default.
     */
    public Directory() {
        this.table = new Node[10];
    }

    /**
     * Constructor.
     * @param length - length array
     */
    public Directory(int length) {
        this.table = new Node[length];
    }

    /**
     * Method insert.
     * @param key - key object
     * @param value - value
     * @return - true or false
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        this.resize();
        int index = this.hash(key);
        if (this.table[index] == null) {
            this.table[index] = new Node<>(key, value, null);
            this.count++;
            result = true;
        } else {
            Node<K, V> node = this.table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                }
                if (node.next == null) {
                    node.next = new Node<>(key, value, null);
                    this.count++;
                    result = true;
                    break;
                }
                node = node.next;
            }
        }
        return result;
    }

    /**
     * Method get.
     * @param key - key object
     * @return - value
     */
    public V get(K key) {
        V result = null;
        int index = this.hash(key);
        if (this.table[index] != null) {
            Node<K, V> node = this.table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    result = node.value;
                    break;
                }
                node = node.next;
            }
        }
        return result;
    }

    /**
     * Method delete.
     * @param key - key object
     * @return - true or false
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = this.hash(key);
        if (this.table[index] != null) {
            Node<K, V> node = this.table[index];
            if (node.key.equals(key)) {
                if (node.next == null) {
                    this.table[index] = null;
                    result = true;
                    this.count--;
                } else {
                    this.table[index] = node.next;
                }
            } else {
                Node<K, V> tmpNode = node;
                while (node != null) {
                    if (node.key.equals(key)) {
                        if (node.next != null) {
                            tmpNode.next = node.next;
                            node.next = null;
                        } else {
                            tmpNode.next = null;
                        }
                        this.count--;
                        result = true;
                    }
                    tmpNode = node;
                    node = node.next;
                }
            }
        }
        return result;
    }

    /**
     * Method resize.
     */
    private void resize() {
        if (this.count >= 0.75 * this.table.length) {
            this.count = 0;
            Node<K, V>[] oldTab = this.table;
            this.table = new Node[this.table.length * 2];
            for (int i = 0; i < oldTab.length; i++) {
                if (oldTab[i] != null) {
                    Node<K, V> node = oldTab[i];
                    while (node != null) {
                        this.insert(node.key, node.value);
                        node = node.next;
                    }
                }
            }
        }
    }

    /**
     * Hash function.
     * @param key - key object
     * @return - number
     */
    private int hash(K key) {
        int h = key.hashCode();
        return (h & 0x7FFFFFFF) % this.table.length;
    }

    /**
     * Method iterator.
     * @return - iterator
     */
    public Iterator<K> iterator() {
        return new DirectoryIterator();
    }

    /**
     * Class DirectoryIterator.
     */
    private class DirectoryIterator implements Iterator<K> {
        /**
         * Index iterator.
         */
        private int index = 0;

        /**
         * Check next element.
         * @return true if iterator has next number.
         */
        @Override
        public boolean hasNext() {
            return this.index < table.length;
        }

        /**
         * Get next element.
         * @return next element.
         */
        @Override
        public K next() {
            K ckey = table[this.index] == null ? null : table[this.index].key;
            this.index++;
            return ckey;
        }
    }

    /**
     * Class Node. Contains key and value.
     * @param <K> - type of key.
     * @param <V> - type of value.
     */
    private class Node<K, V> {
        /**
         * Unique key.
         */
        private K key;
        /**
         * Value of key.
         */
        private V value;
        /**
         * Next element (node).
         */
        private Node<K, V> next;

        /**
         * Node constructor.
         * @param key - key for adding ti directory
         * @param value - value of key
         * @param next - next element node
         */
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

package ru.job4j.pro.list;

/**
 * Class CycleNode.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.06.2017
 */
public class CycleNode {

    /**
     * Check cycle.
     * @param first Node
     * @return - true if list of node has cycle
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node tmp = first;
        while (tmp.getNext() != null) {
            if (tmp.getNext() == tmp || tmp.getNext() == first) {
                result = true;
                break;
            }
            tmp = tmp.getNext();
        }
        return result;
    }

}

/**
 * Node.
 * @param <T> element.
 */
class Node<T> {
    /**
     * Value that contains Node.
     */
    private T value;

    /**
     * Next Node.
     */
    private Node<T> next;

    /**
     * Constructor for Node.
     * @param value for Node.
     */
    Node(T value) {
        this.value = value;
    }

    /**
     * Getter for next.
     * @return next.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Setter for next.
     * @param next for setting.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
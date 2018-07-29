package ru.job4j.pro.list;

import org.junit.Test;
import org.junit.Assert;
import ru.job4j.pro.list.CycleNode.Node;

/**
 * Class CycleNodeTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.06.2017
 */
public class CycleNodeTest {
    /**
     * The first item in the list.
     */
    private static Node<Integer> first = new Node<>(1);
    /**
     * The second element of the list.
     */
    private static Node<Integer> second = new Node<>(2);
    /**
     * The third element of the list.
     */
    private static Node<Integer> third = new Node<>(3);
    /**
     * The four element of the list.
     */
    private static Node<Integer> four = new Node<>(4);

    /**
     * Test method hasCycle.
     */
    @Test
    public void whenListOfNodesHasCycleThenReturnTrue() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(first);

        Assert.assertTrue(new CycleNode().hasCycle(first));
    }

    /**
     * Link begin with begin.
     */
    @Test
    public void whenLinkingBeginWithBeginThenTrue() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(second);

        Assert.assertTrue(new CycleNode().hasCycle(first));
    }
    /**
     * Test method hasCycle.
     */
    @Test
    public void whenListOfNodesHasNotCycleThenReturnFalse() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(null);

        Assert.assertFalse(new CycleNode().hasCycle(first));
    }
}
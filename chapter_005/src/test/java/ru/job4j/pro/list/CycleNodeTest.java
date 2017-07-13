package ru.job4j.pro.list;

import org.junit.Test;

import org.junit.Assert;

/**
 * Class CycleNodeTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.06.2017
 */
public class CycleNodeTest {
    /**
     * Test method hasCycle.
     */
    @Test
    public void whenListOfNodesHasCycleThenReturnTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

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
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

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
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(null);

        Assert.assertFalse(new CycleNode().hasCycle(first));
    }
}
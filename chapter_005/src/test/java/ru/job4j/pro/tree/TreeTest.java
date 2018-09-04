package ru.job4j.pro.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class TreeTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 29.08.2018
 */
public class TreeTest {
    /**
     * Create Tree.
     */
    private Tree<String> tree = new Tree<>();

    /**
     * Add elements in collections.
     */
    @Before
    public void addElementInCollection() {
        tree.add("Russia", "Tverskaya");
        tree.add("Russia", "Moskovskaya");
        tree.add("Tverskaya", "Torzhok");
        tree.add("Torzhok", "Gorkogo 47");
    }

    /**
     * Test method findBy.
     */
    @Test
    public void whenFindElementGorkogo47ThenTrue() {
        assertThat(tree.findBy("Gorkogo 47").isPresent(), is(true));
    }

    /**
     * Test method findBy.
     */
    @Test
    public void whenFindElementGorkogo50ThenFalse() {
        assertThat(tree.findBy("Gorkogo 50").isPresent(), is(false));
    }

    /**
     * Test iterator.
     */
    @Test
    public void iteratorTest() {
        Iterator itr = tree.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Russia"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Tverskaya"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Moskovskaya"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Torzhok"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Gorkogo 47"));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test method isBinary return true.
     */
    @Test
    public void whenIsBinaryThenTrue() {
        assertThat(tree.isBinary(), is(true));
    }

    /**
     * Test method isBinary return false.
     */
    @Test
    public void whenIsBinaryThenFalse() {
        tree.add("Tverskaya", "Tver");
        tree.add("Tverskaya", "Rzhev");
        assertThat(tree.isBinary(), is(false));
    }
}
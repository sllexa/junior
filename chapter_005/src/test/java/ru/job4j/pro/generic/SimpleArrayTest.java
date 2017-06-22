package ru.job4j.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.06.2017
 */
public class SimpleArrayTest {
    /**
     * Test method add. Type String.
     */
    @Test
    public void whenCreateContainerShouldReturnTheStringType() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");

        assertThat(arr.get(0), is("first"));
        assertThat(arr.get(1), is("second"));
    }

    /**
     * Test method add. Type Integer.
     */
    @Test
    public void whenCreateContainerShouldReturnTheIntegerType() {
        SimpleArray<Integer> arr = new SimpleArray<>(2);
        arr.add(2);
        arr.add(1);

        assertThat(arr.get(0), is(2));
        assertThat(arr.get(1), is(1));
    }

    /**
     * Test method update. Type String.
     */
    @Test
    public void whenUpdateMethodTheNewValueTypeString() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");
        arr.update(0, "new value");

        assertThat(arr.get(0), is("new value"));
    }

    /**
     * Test method delete.
     */
    @Test
    public void whenDeleteMethodTheDeleteItem() {
        SimpleArray<String> arr = new SimpleArray<>(3);
        arr.add("first");
        arr.add("second");
        arr.add("third");
        arr.delete(1);
        String[] expected = {"first", "third", null};
        for (int i = 0; i < 3; i++) {
            assertThat(arr.get(i), is(expected[i]));
        }
    }
}
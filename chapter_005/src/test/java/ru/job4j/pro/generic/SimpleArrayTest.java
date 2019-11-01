package ru.job4j.pro.generic;

import org.junit.Test;

import java.util.Iterator;

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
     * Test RuntimeException.
     */
    @Test(expected = RuntimeException.class)
    public void addTestWhenOverflow() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("First");
        simpleArray.add("Second");
    }

    /**
     * Test IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void setTestWhenIndexOutOfBoundsException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("First");
        simpleArray.update(3, "Third");
    }

    /**
     * Test method get ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getTestArrayIndexOutOfBoundsException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("First");
        simpleArray.get(1);
    }

    /**
     * Test method delete.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteTestIndexOutOfBoundsException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("First");
        simpleArray.delete(1);
    }
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
        String[] expected = {"first", "third"};
        for (int i = 0; i < 2; i++) {
            assertThat(arr.get(i), is(expected[i]));
        }
    }

    /**
     * Test method Iterator.
     */
    @Test
    public void whenAddTwoElementsShouldGetTwoElementsUsingIterator() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("ss");
        arr.add("bb");
        String[] expected = new String[]{"ss", "bb"};
        String[] result = new String[2];
        Iterator<String> itr = arr.iterator();
        result[0] = itr.next();
        result[1] = itr.next();
        assertThat(result, is(expected));
    }
}
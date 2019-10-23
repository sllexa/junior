package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StreamApiTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.10.2019
 */
public class StreamApiTest {
    /**
     * Test method sumAll.
     */
    @Test
    public void whenArrayThen24() {
        int[] arr = {1, 2, 3, 4, 2};
        var result = new StreamApi().sumAll(arr);
        assertThat(result, is(24));
    }
    /**
     * Test method sumAll.
     */
    @Test
    public void whenArrayThenZero() {
        int[] arr = {1, 3, 5, 7};
        var result = new StreamApi().sumAll(arr);
        assertThat(result, is(0));
    }
}
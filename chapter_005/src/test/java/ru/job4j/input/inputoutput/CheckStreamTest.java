package ru.job4j.input.inputoutput;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CheckStreamTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.01.2019
 */
public class CheckStreamTest {
    /**
     * Create stream.
     */
    private CheckStream chs = new CheckStream();

    /**
     * Positive flow test for an even number.
     * @throws IOException - an exception
     */
    @Test
    public void whenInEvenThenResultTrue() throws IOException {
        String input = "1234";
        try (InputStream result = new ByteArrayInputStream(input.getBytes())) {
            assertThat(chs.isNumber(result), is(true));
        }
    }

    /**
     * Negative flow test for an even number in the stream.
     * @throws IOException - an exception
     */
    @Test
    public void whenInEvenThenResultFalse() throws IOException {
        String input = "123";
        try (InputStream result = new ByteArrayInputStream(input.getBytes())) {
            assertThat(chs.isNumber(result), is(false));
        }
    }

    /**
     * Test exception.
     * @throws IOException -
     */
    @Test(expected = NumberFormatException.class)
    public void whenInNotNumberThenGetNumberFormatException() throws IOException {
        String input = "not number";
        try (InputStream result = new ByteArrayInputStream(input.getBytes())) {
            assertThat(chs.isNumber(result), is(false));
        }
    }
}
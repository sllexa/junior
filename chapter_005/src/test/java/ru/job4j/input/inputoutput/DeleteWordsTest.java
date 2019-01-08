package ru.job4j.input.inputoutput;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DeleteWordsTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.01.2019
 */
public class DeleteWordsTest {
    /**
     * Test deletion of forbidden words.
     * @throws IOException - exception
     */
    @Test
    public void whenInStreamThenGetOutStreamWithoutAbuseWords() throws IOException {
        DeleteWords dw = new DeleteWords();
        String[] abuse = {"Masha", "Katya"};

        ByteArrayInputStream in = new ByteArrayInputStream("VasyaMashaKolyaKatyaTolik".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        dw.dropAbuses(in, out, abuse);
        String expected = "VasyaKolyaTolik";
        assertThat(out.toString(), is(expected));
    }
}
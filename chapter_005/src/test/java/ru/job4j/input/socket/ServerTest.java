package ru.job4j.input.socket;

import com.google.common.base.Joiner;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Class ServerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.03.2019
 */
public class ServerTest {
    /**
     * Line separator.
     */
    private static final String LN = System.getProperty("line.separator");

    /**
     * Input test 'exit'.
     * @throws IOException -
     */
    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        testServer("exit", "");
    }

    /**
     * Input test hello.
     * @throws IOException -
     */
    @Test
    public void whenAskHelloThenBackGreat() throws IOException {
        testServer(
                Joiner.on(LN).join(
                        "hello",
                        "exit"
                ),
                String.format("Hello, dear friend, I'm a oracle.%s%s", LN, LN)
        );
    }

    /**
     * Any word input test.
     * @throws IOException -
     */
    @Test
    public void whenUnsupportedAskThenDontUnderstand() throws IOException {
        testServer(
                Joiner.on(LN).join(
                        "unsupported ask",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "I don't understand",
                        "",
                        ""
                )
        );
    }

    /**
     * Test run method.
     * @param input - input
     * @param expected - expected
     * @throws IOException -
     */
    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }
}
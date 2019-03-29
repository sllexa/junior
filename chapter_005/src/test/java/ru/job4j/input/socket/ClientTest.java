package ru.job4j.input.socket;

import com.google.common.base.Joiner;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class ClientTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.03.2019
 */
public class ClientTest {
    /**
     * Line separator.
     */
    private static final String LN = System.getProperty("line.separator");

    /**
     * Test insert exit.
     * @throws IOException -
     */
    @Test
    public void whenAskExitThenOracleExit() throws IOException {
        testClient("exit", LN, "");
    }

    /**
     * Test insert hello.
     * @throws IOException -
     */
    @Test
    public void whenAskHelloThenBackGreat() throws IOException {
        testClient(
                Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", "", ""),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", "")
        );
    }

    /**
     * Test run method.
     * @param input - input
     * @param inServer - input server
     * @param expected - expected
     * @throws IOException -
     */
    private void testClient(String input, String inServer, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(inServer.getBytes());
        ByteArrayInputStream consoleInput = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));
        System.setIn(consoleInput);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start();
        assertThat(consoleOutput.toString(), is(expected));
    }
}
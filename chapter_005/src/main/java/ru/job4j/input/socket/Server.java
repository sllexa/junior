package ru.job4j.input.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class Server.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.03.2019
 */
public class Server {
    /**
     * Socket.
     */
    private final Socket socket;

    /**
     * Constructor.
     * @param socket - socket
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Method start.
     * @throws IOException -
     */
    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!"exit".equals(ask)) {
                out.println("I don't understand");
                out.println();
            }
        } while (!"exit".equals(ask));
    }

    /**
     * Method main.
     * @param args - args
     * @throws IOException -
     */
    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        }
    }
}

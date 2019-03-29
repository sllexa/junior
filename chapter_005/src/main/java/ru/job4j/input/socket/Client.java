package ru.job4j.input.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Client.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.03.2019
 */
public class Client {
    /**
     * Socket.
     */
    private final Socket socket;

    /**
     * Constructor.
     * @param socket - socket
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Method start.
     * @throws IOException -
     */
    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        String request;
        String response;
        do {
            request = scanner.nextLine();
            out.println(request);
            if (!"exit".equals(request)) {
                response = in.readLine();
                while (!response.isEmpty()) {
                    System.out.println(response);
                    response = in.readLine();
                }
            }
        } while (!"exit".equals(request));
    }

    /**
     * Method main.
     * @param args - args
     * @throws IOException -
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName("localhost"), 5000)) {
            new Client(socket).start();
        }
    }
}

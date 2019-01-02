package ru.job4j.input.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class CheckStream.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.01.2019
 */
public class CheckStream {
    /**
     * The method checks that an even number is written in the byte stream.
     * @param in - byte stream
     * @return - true or false
     * @throws IOException -
     */
    public boolean isNumber(InputStream in) throws IOException {
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String sline = br.readLine();
            result = Integer.valueOf(sline) % 2 == 0;
        }
        return result;
    }
}

package ru.job4j.input.inputoutput;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;

/**
 * Class DeleteWords.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 04.01.2019
 */
public class DeleteWords {
    /**
     * Method removes forbidden words from the stream.
     * @param in - input stream
     * @param out - output stream
     * @param abuse - array of forbidden words
     * @throws IOException - exception
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        while ((str = br.readLine()) != null) {
            for (String elmAbs : abuse) {
                str = str.replaceAll(elmAbs, "");
            }
            out.write(str.getBytes());
        }
    }
}

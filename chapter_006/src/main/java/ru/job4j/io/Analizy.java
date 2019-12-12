package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Class Analizy.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 25.11.2019
 */
public class Analizy {

    public void unavailable(String source, String target) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(source));
                PrintWriter out = new PrintWriter(new FileOutputStream(target))
            ) {

            String line = reader.readLine();
            StringBuilder result = new StringBuilder();
            boolean status = true;

            while (line != null) {
                String[] str = line.split(" ");
                if (status) {
                    if (str[0].equals("400") || str[0].equals("500")) {
                        result.append(str[1] + ";");
                        status = false;
                    }
                } else {
                    if (str[0].equals("200")) {
                        result.append(str[1]).append(System.lineSeparator());
                        status = true;
                    }
                }
                line = reader.readLine();
            }
            out.print(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

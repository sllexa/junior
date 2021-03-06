package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class AnalizyTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 12.12.2019
 */
public class AnalizyTest {
    private static final String FS = System.getProperty("file.separator");
    String tmp;

    @Before
    public void before() {
        tmp = System.getProperty("java.io.tmpdir");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(tmp + FS + "server.log"))) {
            out.println("200 10:56:01");
            out.println("");
            out.println("500 10:57:01");
            out.println("");
            out.println("400 10:58:01");
            out.println("");
            out.println("200 10:59:01");
            out.println("");
            out.println("500 11:01:02");
            out.println("");
            out.println("200 11:02:02");
            out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLogContains3PeriodsShould3Periods() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        analizy.unavailable(tmp + FS + "server.log", tmp + FS + "target.csv");
        Scanner scanner = new Scanner(new FileInputStream(tmp + FS + "target.csv"));
        assertThat(scanner.nextLine(), is("10:57:01;10:59:01"));
        assertThat(scanner.nextLine(), is("11:01:02;11:02:02"));
        scanner.close();
    }

    @After
    public void after() {
        File file = new File(tmp + FS + "server.log");
        if (file.exists()) {
            file.delete();
        }
        file = new File(tmp + FS + "target.csv");
        if (file.exists()) {
            file.delete();
        }
    }
}
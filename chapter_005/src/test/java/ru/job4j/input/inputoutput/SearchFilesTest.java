package ru.job4j.input.inputoutput;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class SearchFilesTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 24.01.2019
 */
public class SearchFilesTest {
    /**
     * File separator.
     */
    private static final String FS = System.getProperty("file.separator");
    /**
     * Directory path.
     */
    private final String path = FS + "SearchFile";
    /**
     * List extensions of files.
     */
    private final List<String> etxs = new ArrayList<>();

    /**
     * Add elements in list.
     */
    @Before
    public void setUp() {
        new File(path).mkdir();
        this.etxs.add(".ini");
        this.etxs.add(".log");
        this.etxs.add(".txt");
    }

    /**
     * Test.
     */
    @Test
    public void whenAddTenThenReceiveTen() {
        List<File> expect = new LinkedList<>();
        SearchFiles search = new SearchFiles();
        int count = 5;
        try {

            for (int i = 0; i < count; i++) {
                String curPath = path + FS + i;
                new File(curPath).mkdir();
                for (String s : etxs) {
                    File curFile = new File(curPath + FS + i + s);
                    expect.add(curFile);
                    curFile.createNewFile();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<File> result = search.files(path, etxs);
        assertThat(result, is(expect));

    }

}
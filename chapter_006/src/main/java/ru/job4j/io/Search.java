package ru.job4j.io;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class Search.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.12.2019
 */
public class Search {
    /**
     * Return list of files.
     * @param parent - searching directory
     * @param exts - extensions of files
     * @return - list of objects File
     */
    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();

        File file = new File(parent);
        for (File fileAll : Arrays.asList(file.listFiles())) {
            data.add(fileAll);
        }

        File tmp;
        while (!data.isEmpty()) {
            tmp = data.poll();
            if (tmp.isDirectory()) {
                for (File fileAll : Arrays.asList(tmp.listFiles())) {
                    data.add(fileAll);
                }
            } else {
                for (String str : exts) {
                    if (tmp.getName().endsWith(str)) {
                        result.add(tmp);
                        break;
                    }
                }
            }
        }
        return result;
    }
}

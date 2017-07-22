package ru.job4j.pro.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DirectoryTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 15.07.2017
 */
public class DirectoryTest {
    /**
     * Test methods insert and get.
     */
    @Test
    public void whenInsertAndGetMethodsThenGetItValue() {
        Directory<String, String> dir = new Directory<>(2);
        dir.insert("first", "001");

        assertThat(dir.get("first"), is("001"));
    }

    /**
     * Test insert and delete method.
     */
    @Test
    public void whenInsertAndDeleteThenTrue() {
        Directory<String, Integer> dir = new Directory<>();
        String[] arrKey = {"first", "second", "third", "four", "five"};

        for (int i = 0; i < arrKey.length; i++) {
            dir.insert(arrKey[i], i + 1);
        }
        boolean result = dir.delete("second");

        assertThat(result, is(true));
    }

    /**
     * Test iterator.
     */
    @Test
    public void whenIteratorThenTrue() {
        Directory<String, Integer> dir = new Directory<>();
        String[] arrKey = {"first", "second", "third", "four", "five"};

        for (int i = 0; i < arrKey.length; i++) {
            dir.insert(arrKey[i], i + 1);
        }

        Iterator itr = dir.iterator();
        Object str;
        while (itr.hasNext()) {
            str = itr.next();
            if (str != null && str.equals(arrKey[2])) {
                assertThat(dir.get(arrKey[2]), is(3));
            }
        }
    }
}
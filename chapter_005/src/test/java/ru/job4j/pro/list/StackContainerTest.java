package ru.job4j.pro.list;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StackContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.06.2017
 */
public class StackContainerTest {
    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenPushElementAndPopThenExpected() {
        StackContainer<String> stcont = new StackContainer<>();
        stcont.push("001");
        stcont.push("002");
        stcont.push("003");
        assertThat(stcont.pop(), is("003"));
        assertThat(stcont.pop(), is("002"));
        assertThat(stcont.pop(), is("001"));
        stcont.pop();
    }
    /**
     * Test methods push() and pop().
     */
    @Test
    public void whenPushElementAndPopThenGetIt() {
        StackContainer<Integer> stcont = new StackContainer<>();
        stcont.push(150);
        stcont.push(200);
        Integer result = stcont.pop();

        assertThat(result, is(200));
    }
}
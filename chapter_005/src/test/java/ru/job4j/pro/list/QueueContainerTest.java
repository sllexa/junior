package ru.job4j.pro.list;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class QueueContainerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.06.2017
 */
public class QueueContainerTest {
    /**
     * Test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenPushElementAndPollThenExpected() {
        QueueContainer<String> qcont = new QueueContainer<>();
        qcont.push("001");
        qcont.push("002");
        qcont.push("003");
        assertThat(qcont.poll(), is("001"));
        assertThat(qcont.poll(), is("002"));
        assertThat(qcont.poll(), is("003"));
        qcont.poll();
    }

    /**
     * Test method poll.
     */
    @Test
    public void whenAddElementAndPollThenGetIt() {
        QueueContainer<Integer> qcont = new QueueContainer<>();
        qcont.push(150);
        qcont.push(200);
        Integer result = qcont.poll();

        assertThat(result, is(150));
    }
}
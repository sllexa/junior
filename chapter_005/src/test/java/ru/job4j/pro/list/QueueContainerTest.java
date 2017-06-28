package ru.job4j.pro.list;

import org.junit.Test;

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
     * Test method poll.
     */
    @Test
    public void whenAddElementAndPollThenGetIt() {
        QueueContainer<Integer> qcont = new QueueContainer<>();
        qcont.add(150);
        qcont.add(200);
        Integer result = qcont.poll();

        assertThat(result, is(150));
    }
}
package ru.job4j.lite.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PriorityQueueTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.06.2018
 */
public class PriorityQueueTest {
    /**
     * Test class PriorityQueue.
     */
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}

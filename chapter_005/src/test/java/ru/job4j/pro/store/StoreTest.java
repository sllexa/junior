package ru.job4j.pro.store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class StoreTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.09.2018
 */
public class StoreTest {
    /**
     * Initial list.
     */
    private List<Store.User> previous = new ArrayList<>();
    /**
     * Modified list.
     */
    private List<Store.User> current = new ArrayList<>();
    /**
     * Store.
     */
    private Store store;
    /**
     * Info.
     */
    private Info info;

    /**
     * Add, remove, set lists.
     */
    @Before
    public void beforeTest() {
        previous.add(new Store.User(10, "Alex"));
        previous.add(new Store.User(11, "Max"));
        previous.add(new Store.User(12, "Nik"));
        previous.add(new Store.User(13, "Mariya"));
        previous.add(new Store.User(14, "Dennis"));
        previous.add(new Store.User(15, "Gulya"));
        current.addAll(previous);
        current.set(1, new Store.User(11, "Bob"));
        current.remove(4);
        current.remove(4);
        current.add(new Store.User(16, "Dariya"));
        current.add(new Store.User(17, "Sandra"));
        current.add(new Store.User(18, "Donald"));
        store = new Store();
    }

    /**
     * Test method diff, return statistics.
     */
    @Test
    public void whenCallDiffMethodThenReturnStatistics() {
        info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(3));
        assertThat(info.getChangCount(), is(1));
        assertThat(info.getDelCount(), is(2));
    }

    /**
     * Test method diff, return zero.
     */
    @Test
    public void whenCallDiffMethodWithEmptyListsThen0() {
        previous.clear();
        current.clear();
        info = store.diff(previous, current);
        assertThat(info.getAddCount(), is(0));
        assertThat(info.getChangCount(), is(0));
        assertThat(info.getDelCount(), is(0));
    }
}
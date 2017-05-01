package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс тест TrackerTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 30.04.2017
 */
public class TrackerTest {
    /**
     * Тест проверяющий добавление заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Тест проверяющий обновление заявки.
     */
    @Test
    public void whenUpdateItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        tracker.update(itemTest2);
        assertThat(tracker.findAll()[1], is(itemTest2));
    }
    /**
     * Тест проверяющий удаление заявки.
     */
    @Test
    public void whenDeleteItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        tracker.delete(itemTest1);
        assertThat(tracker.findAll()[0], is(itemTest2));
    }
    /**
     * Тест проверяющий вывод списка всех заявок.
     */
    @Test
    public void whenFindAllItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        Item[] itemProv = {itemTest1, itemTest2};
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        assertThat(tracker.findAll(), is(itemProv));
    }
    /**
     * Тест проверяющий поиск заявок по полю name.
     */
    @Test
    public void whenFindByNameItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test1", "testDescription", 125L);
        Item[] itemProv = {itemTest1, itemTest2};
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        assertThat(tracker.findByName("test1"), is(itemProv));
    }
    /**
     * Тест проверяющий поиск заявок по полю name.
     */
    @Test
    public void whenFindByIdItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        assertThat(tracker.findById(tracker.findAll()[0].getId()), is(itemTest1));
    }
}

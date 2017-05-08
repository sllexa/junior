package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.Tracker;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс StubInputTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.05.2017
 */
public class StubInputTest {
    /**
     * Автоматический тест добавления заявки.
     */
    @Test
    public void whenAddItemThenTrackerNewItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "testName", "testDesc", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("testName"));
    }
    /**
     * Автоматический тест вывода списка всех заявок.
     */
    @Test
    public void whenFindAllItemsThenShowAllItems() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        Item[] itemProv = {itemTest1, itemTest2};
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        Input input = new StubInput(new String[]{"2", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(itemProv));
    }
    /**
     * Автоматический тест редактирования заявки.
     */
    @Test
    public void whenUpdateItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDesc", 123L);
        tracker.add(itemTest1);
        itemTest1.setId("id");
        Input input = new StubInput(new String[]{"3", "id", "newName", "newDesc", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getDesc(), is("newDesc"));
    }
    /**
     * Автоматический тест удаления заявки.
     */
    @Test
    public void whenDeleteItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDesc", 123L);
        Item itemTest2 = new Item("test2", "testDesc", 125L);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        itemTest1.setId("id");
        Input input = new StubInput(new String[]{"4", "id", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }
    /**
     * Автоматический тест поиска заявки по id.
     */
    @Test
    public void whenFindByIdItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDesc", 123L);
        Item itemTest2 = new Item("test2", "testDesc", 125L);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        itemTest1.setId("id");
        Input input = new StubInput(new String[]{"5", "id", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById("id"), is(itemTest1));
    }
    /**
     * Автоматический тест поиска заявки по name.
     */
    @Test
    public void whenFindByNameItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDesc1", 123L);
        Item itemTest2 = new Item("test2", "testDesc2", 125L);
        Item itemTest3 = new Item("test2", "testDesc3", 127L);
        Item[] itemProv = {itemTest2, itemTest3};
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        tracker.add(itemTest3);
        Input input = new StubInput(new String[]{"6", "test2", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test2"), is(itemProv));
    }
}

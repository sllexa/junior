package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

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
     * Поле для выходного потока.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Поле для выхода.
     */
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    /**
     * Автоматический тест добавления заявки.
     */
    @Test
    public void whenAddItemThenTrackerNewItem() {
        Tracker tracker = new Tracker();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "test1", "testDescription", "y"));
        Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test1"));
    }
    /**
     * Автоматический тест вывода списка всех заявок.
     */
   @Test
    public void whenFindAllItemsThenShowAllItems() {
        Tracker tracker = new Tracker();
        Item itemTest1 = new Item("test1", "testDescription", 123L);
        Item itemTest2 = new Item("test2", "testDescription", 125L);
        ArrayList<Item> itemProv = new ArrayList<>();
        itemProv.add(itemTest1);
        itemProv.add(itemTest2);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
       ArrayList<String> list = new ArrayList<>(Arrays.asList("2", "y"));
       Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("3", "id", "newName", "newDesc", "y"));
        Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getDesc(), is("newDesc"));
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("4", "001", "y"));
        Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0), is(itemTest2));
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("5", "001", "y"));
        new StartUI(new StubInput(list), tracker, output).init();
        assertThat(tracker.findById("001"), is(itemTest1));
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
        ArrayList<Item> itemProv = new ArrayList<>();
        itemProv.add(itemTest2);
        itemProv.add(itemTest3);
        tracker.add(itemTest1);
        tracker.add(itemTest2);
        tracker.add(itemTest3);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("6", "test2", "y"));
        Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findByName("test2"), is(itemProv));
    }
}

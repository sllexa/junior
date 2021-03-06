package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

/**
 * Класс MenuTracker.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 10.05.2017
 */
public class MenuTracker {
    /**
     * Поле ввода.
     */
    private Input input;
    /**
     * Поле объекта работы с заявками.
     */
    private Tracker tracker;
    /**
     * Массив для хранения меню.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();
    /**
     * Счетчик действий.
     */
    private int count = 0;
    /**
     * Поле длявывода.
     */
    private static Consumer<String> output;

    /**
     * Конструктор класса.
     * @param input - объект ввода.
     * @param tracker - объект для работы с заявками
     * @param output - объект для вывода
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        MenuTracker.output = output;
    }
    /**
     * Метод заполняет массив для хранения меню.
     * @return - возвращает массив действий.
     */
    public ArrayList<UserAction> fillAction() {
        this.actions.add(count++, new MenuTracker.AddItem("Add new item.", count));
        this.actions.add(count++, new MenuTracker.ShowItems("Show all items.", count));
        this.actions.add(count++, new MenuTracker.EditItem("Edit item.", count));
        this.actions.add(count++, new MenuTracker.DeleteItem("Delete item.", count));
        this.actions.add(count++, new MenuTracker.FindById("Find item by Id.", count));
        this.actions.add(count++, new MenuTracker.FindByName("Find items by name.", count));
        return this.actions;
    }

    /**
     * Метод заполняет массив цифовым интервалом меню.
     * @param count - количество действий в меню.
     * @return - возвращает массив с цифровым интервалом.
     */
    public ArrayList<Integer> fillRange(int count) {
        ArrayList<Integer> menuRange = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            menuRange.add(i);
        }
        return menuRange;
    }
    /**
     * Метод выбора меню польльзователем.
     * @param key - номер меню.
     */
    public void select(int key) {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * Метод печатает меню в консоли.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
    /**
     * Внутренний статический класс для меню добавление новой заявки.
     */
    private static class AddItem extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        AddItem(String name, int key) {
            super(name, key);
        }
        /**
         * Метод добавляет новую заявку.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String tName = input.ask("Please, inter the task's name: ");
            String tDesc = input.ask("Please, inter the task's description: ");
            Date date = new Date();
            tracker.add(new Item(tName, tDesc, date.getTime()));
        }
    }
    /**
     * Внутренний статический класс для вывода в консоль списка всех заявок.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        ShowItems(String name, int key) {
            super(name, key);
        }
        /**
         * Метод выводит список всех заявок.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item tmp : tracker.findAll()) {
                output.accept(tmp.toString());
            }
        }
    }
    /**
     * Внутренний статический класс для редактирования заявки.
     */
    private static class EditItem extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        EditItem(String name, int key) {
            super(name, key);
        }
        /**
         * Метод редкктирует заявку.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    String tName = input.ask("Please, inter the task's  new name: ");
                    String tDesc = input.ask("Please, inter the task's new description: ");
                    Item tNew = new Item(tName, tDesc, tmp.getCreated());
                    tNew.setId(tId);
                    tracker.update(tNew);
                    output.accept("The changes were successfully made.");
                    break;
                }
            }
        }
    }
    /**
     * Внутренний статический класс для удаления заявки.
     */
    private static class DeleteItem extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        DeleteItem(String name, int key) {
            super(name, key);
        }
        /**
         * Метод удаляет заявку.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    tracker.delete(tmp);
                    output.accept("The task's was successfully deleted.");
                    break;
                }
            }
        }
    }
    /**
     * Внутренний статический класс для поиска заявки по id.
     */
    private static class FindById extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        FindById(String name, int key) {
            super(name, key);
        }
        /**
         * Метод ищет заявку по id.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            Item tmp = tracker.findById(tId);
            if (tmp != null) {
                output.accept(tmp.toString());
            } else {
                output.accept("No task's with this Id.");
            }
        }
    }
    /**
     * Внутренний статический класс для вывода списка заявок с однинаковым name.
     */
    private static class FindByName extends BaseAction {
        /**
         * Конструктор класса.
         * @param name - название меню.
         * @param key - номер меню.
         */
        FindByName(String name, int key) {
            super(name, key);
        }
        /**
         * Метод выводит список заявок с одинаковым name.
         * @param input - ввод данных.
         * @param tracker - объект работы с заявками.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String tName = input.ask("Please, inter the task's name: ");
            for (Item tmp : tracker.findByName(tName)) {
                if (tmp != null) {
                    output.accept(tmp.toString());
                } else {
                    output.accept("No task's with this name.");
                }
            }
        }
    }
}

package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;
import java.util.Date;

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
    private UserAction[] actions = new UserAction[6];
    /**
     * Объккт для хранения даты.
     */
    private static Date date;
    /**
     * Счетчик действий.
     */
    private int count = 0;

    /**
     * Конструктор класса.
     * @param input - объект ввода.
     * @param tracker - объект для работы с заявками.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод заполняет массив для хранения меню.
     * @return - возвращает массив действий.
     */
    public UserAction[] fillAction() {
        this.actions[count++] = new MenuTracker.AddItem("Add new item.", count);
        this.actions[count++] = new MenuTracker.ShowItems("Show all items.", count);
        this.actions[count++] = new MenuTracker.EditItem("Edit item.", count);
        this.actions[count++] = new MenuTracker.DeleteItem("Delete item.", count);
        this.actions[count++] = new MenuTracker.FindById("Find item by Id.", count);
        this.actions[count++] = new MenuTracker.FindByName("Find items by name.", count);
        return this.actions;
    }
    /*/**
     * Метод добавления нового действия.
     * @param action - действие.
     */
    /*public void AddActions(UserAction action) {
        this.actions[count++] = action;
    }*/
    /**
     * Метод заполняет массив цифовым интервалом меню.
     * @param list - массив действий.
     * @return - возвращает массив с цифровым интервалом.
     */
    public int[] fillRange(UserAction[] list) {
        int[] menuRange = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            menuRange[i] = i + 1;
        }
        return menuRange;
    }
    /**
     * Метод выбора меню польльзователем.
     * @param key - номер меню.
     */
    public void select(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    /**
     * Метод печатает меню в консоли.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
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
        public void execute(Input input, Tracker tracker) {
            String tName = input.ask("Please, inter the task's name: ");
            String tDesc = input.ask("Please, inter the task's description: ");
            date = new Date();
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
        public void execute(Input input, Tracker tracker) {
            for (Item tmp : tracker.findAll()) {
                System.out.println(tmp);
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
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    String tName = input.ask("Please, inter the task's  new name: ");
                    String tDesc = input.ask("Please, inter the task's new description: ");
                    Item tNew = new Item(tName, tDesc, tmp.getCreated());
                    tNew.setId(tId);
                    tracker.update(tNew);
                    System.out.println("The changes were successfully made.");
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
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    tracker.delete(tmp);
                    System.out.println("The task's was successfully deleted.");
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
        public void execute(Input input, Tracker tracker) {
            String tId = input.ask("Please, inter the task's Id: ");
            Item tmp = tracker.findById(tId);
            if (tmp != null) {
                System.out.println(tmp);
            } else {
                System.out.println("No task's with this Id.");
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
        public void execute(Input input, Tracker tracker) {
            String tName = input.ask("Please, inter the task's name: ");
            for (Item tmp : tracker.findByName(tName)) {
                if (tmp != null) {
                    System.out.println(tmp);
                } else {
                    System.out.println("No task's with this name.");
                }
            }
        }
    }
}

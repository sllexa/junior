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
     */
    public void fillAction() {
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindById();
        this.actions[5] = new MenuTracker.FindByName();
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
    private static class AddItem implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 1;
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

        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }
    /**
     * Внутренний статический класс для вывода в консоль списка всех заявок.
     */
    private static class ShowItems implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 2;
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
        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
    /**
     * Внутренний статический класс для редактирования заявки.
     */
    private static class EditItem implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 3;
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
        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }
    /**
     * Внутренний статический класс для удаления заявки.
     */
    private static class DeleteItem implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 4;
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
        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }
    /**
     * Внутренний статический класс для поиска заявки по id.
     */
    private static class FindById implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 5;
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
        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }
    /**
     * Внутренний статический класс для вывода списка заявок с однинаковым name.
     */
    private static class FindByName implements UserAction {
        /**
         * Метод возвращает ключ меню.
         * @return - возвращает номер меню.
         */
        public int key() {
            return 6;
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
        /**
         * Метод выводит информацию о действии.
         * @return - возвращает строку с информацией.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }
    }
}

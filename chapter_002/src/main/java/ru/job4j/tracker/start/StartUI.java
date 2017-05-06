package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.Tracker;
import java.util.Date;

/**
 * Класс StartUI.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.05.2017
 */
public class StartUI {
    /**
     * Поле для ввода.
     */
    private Input input;
    /**
     * Поле заявки.
     */
    private Tracker tracker;
    /**
     * Меню для пользователя.
     */
    private final String[] menu = {
            "1.Add new item.",
            "2.Show all items.",
            "3.Edit item.",
            "4.Delete item.",
            "5.Find item by Id.",
            "6.Find items by name.",
            "7.Exit program."
    };
    /**
     * Поле для слежения за работой программы.
     */
    private boolean work = true;
    /**
     * Объкт для работы с датами.
     */
    private Date date = new Date();
    /**
     * Перечисление.
     */
    private enum Actions {
        /**
         * Добавление новой заявки.
         */
        ADD,
        /**
         * Список всех заявок.
         */
        SHOW_ALL,
        /**
         * Обновление заявки.
         */
        EDIT,
        /**
         * Удаление заявки.
         */
        DELETE,
        /**
         * Поиск заявки по id.
         */
        FIND_BY_ID,
        /**
         * Список заявок с одним name.
         */
        FIND_BY_NAME,
        /**
         * Выход из программы.
         */
        EXIT
    }
    /**
     * Конструктор класса.
     * @param input - ввод.
     * @param tracker - заявка.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод инициализации.
     */
    public void init() {
        boolean rMenu;
        while (work) {
            rMenu = false;
            System.out.println("");
            for (String str : this.menu) {
                System.out.println(str);
            }
            String str = input.ask("Inter the number 1 to 7: ");
            str = str.substring(0, 1);
            String[] sMenu = {"1", "2", "3", "4", "5", "6", "7"};
            for (int i = 0; i < sMenu.length; i++) {
                if (sMenu[i].equals(str)) {
                    execution(Actions.values()[i]);
                    rMenu = true;
                    break;
                }
            }
            if (!rMenu) {
                System.out.println("Input error. Expected number from 1 to 7.");
            }
        }
    }
    /**
     * Метод выполняет действия в зависимости от выбранного пункта меню.
     * @param action - выбранный пункта меню.
     */
    private void execution(Actions action) {
        if (action == Actions.ADD) {
            String tName = input.ask("Please, inter the task's name: ");
            String tDesc = input.ask("Please, inter the task's description: ");
            tracker.add(new Item(tName, tDesc, date.getTime()));
            System.out.println("New task successfully added");
        } else if (action == Actions.SHOW_ALL) {
            for (Item tmp : tracker.findAll()) {
                System.out.println(tmp.toString(tmp));
            }
        } else if (action == Actions.EDIT) {
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
        } else if (action == Actions.DELETE) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    tracker.delete(tmp);
                    System.out.println("The task's was successfully deleted.");
                    break;
                }
            }
        } else if (action == Actions.FIND_BY_ID) {
            String tId = input.ask("Please, inter the task's Id: ");
            Item tmp = tracker.findById(tId);
            if (tmp != null) {
                System.out.println(tmp.toString(tmp));
            } else {
                System.out.println("No task's with this Id.");
            }
        } else if (action == Actions.FIND_BY_NAME) {
            String tName = input.ask("Please, inter the task's name: ");
            for (Item tmp : tracker.findByName(tName)) {
                if (tmp != null) {
                    System.out.println(tmp.toString(tmp));
                } else {
                    System.out.println("No task's with this name.");
                }
            }
        } else {
            work = false;
            System.out.println("The program is closed.");
        }
    }
    /**
     * Метод main - старт программы.
     * @param args - входной параметр.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker  = new Tracker();
        new StartUI(input, tracker).init();
    }
}

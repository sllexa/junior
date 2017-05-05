package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.Tracker;
import java.util.Date;
import java.text.SimpleDateFormat;
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
     * Создаем объект класса Tracker для работы с заявками.
     */
    private Tracker tracker = new Tracker();
    /**
     * Объкт для работы с датами.
     */
    private Date date = new Date();
    /**
     * Объект для форматирования даты.
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    /**
     * Конструктор класса.
     * @param input - ввод.
     */
    public StartUI(Input input) {
        this.input = input;
    }
    /**
     * Метод инициализации.
     */
    public void init() {
        int numMenu;
        while (work) {
            numMenu = 0;
            System.out.println("");
            for (String str : this.menu) {
                System.out.println(str);
            }
            String str = input.ask("Inter the number 1 to 7: ");
            str = str.substring(0, 1);
            String[] sMenu = {"1", "2", "3", "4", "5", "6", "7"};
            for (int i = 0; i < sMenu.length; i++) {
                if (sMenu[i].equals(str)) {
                    numMenu = Integer.parseInt(str);
                    break;
                }
            }
            if (numMenu != 0) {
                execution(numMenu);
            } else {
                System.out.println("Input error. Expected number from 1 to 7.");
            }
        }
    }
    /**
     * Метод выполняет действия в зависимости от выбранного пункта меню.
     * @param num - номер пункта меню.
     */
    private void execution(int num) {
        if (num == 1) {
            String tName = input.ask("Please, inter the task's name: ");
            String tDesc = input.ask("Please, inter the task's description: ");
            tracker.add(new Item(tName, tDesc, date.getTime()));
            System.out.println("New task successfully added");
        }
        if (num == 2) {
            for (Item tmp : tracker.findAll()) {
                System.out.println(tmp.getName() + " | " + tmp.getDesc() + " | "
                        + dateFormat.format(tmp.getCreated()) + " | " + tmp.getId());
            }
        }
        if (num == 3) {
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
        if (num == 4) {
            String tId = input.ask("Please, inter the task's Id: ");
            for (Item tmp : tracker.findAll()) {
                if (tmp != null && tmp.getId().equals(tId)) {
                    tracker.delete(tmp);
                    System.out.println("The task's was successfully deleted.");
                    break;
                }
            }
        }
        if (num == 5) {
            String tId = input.ask("Please, inter the task's Id: ");
            Item tmp = tracker.findById(tId);
            if (tmp != null) {
                System.out.println(tmp.getName() + " | " + tmp.getDesc() + " | "
                        + dateFormat.format(tmp.getCreated()) + " | " + tmp.getId());
            } else {
                System.out.println("No task's with this Id.");
            }
        }
        if (num == 6) {
            String tName = input.ask("Please, inter the task's name: ");
            for (Item tmp : tracker.findByName(tName)) {
                if (tmp != null) {
                    System.out.println(tmp.getName() + " | " + tmp.getDesc() + " | "
                            + dateFormat.format(tmp.getCreated()) + " | " + tmp.getId());
                } else {
                    System.out.println("No task's with this name.");
                }
            }
        }
        if (num == 7) {
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
        new StartUI(input).init();
    }
}

package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] ranges = menu.fillRange(menu.fillAction());
        do {
            menu.show();
            menu.select(input.ask("Select:", ranges));
        } while (!"y".equals(this.input.ask("Exit program? (y):")));
    }

    /**
     * Метод main - старт программы.
     * @param args - входной параметр.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker  = new Tracker();
        new StartUI(input, tracker).init();
    }
}

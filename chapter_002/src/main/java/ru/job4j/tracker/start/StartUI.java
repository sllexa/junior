package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

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
     * Поле для вывода.
     */
    private Consumer<String> output;

    /**
     * Конструктор класса.
     * @param input - ввод.
     * @param tracker - заявка.
     * @param output - вывод
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод инициализации.
     */
    void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        ArrayList<Integer> ranges = menu.fillRange(menu.fillAction().size());
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
        new StartUI(input, tracker, System.out::println).init();
    }
}

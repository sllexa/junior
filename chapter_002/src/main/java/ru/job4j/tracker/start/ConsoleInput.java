package ru.job4j.tracker.start;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс ConsoleInput.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.05.2017
 */
public class ConsoleInput implements Input {
    /**
     * Сканер для приема информации от пользователя в консоли.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод принимает информацию от пользователя.
     * @param question - строка с вопросом.
     * @return - возвращает ответ пользователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
     * Метод принимает информацию от пользователя.
     * @param question - строка с вопросом.
     * @param range - цифровой интервал.
     * @return - возвращает ответ пользователя.
     */
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int tmp : range) {
            if (tmp == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}

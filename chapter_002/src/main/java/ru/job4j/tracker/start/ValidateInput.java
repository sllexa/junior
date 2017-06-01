package ru.job4j.tracker.start;

import java.util.ArrayList;

/**
 * Класс ValidateInput.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 12.05.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод с обработкой ошибок.
     * @param question - строка с вопросом.
     * @param range - цифровой интервал.
     * @return - возвращает выбор поль
     */
    public int ask(String question, ArrayList<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please inter validate data again.");
            }
        } while (invalid);
        return value;
    }
}

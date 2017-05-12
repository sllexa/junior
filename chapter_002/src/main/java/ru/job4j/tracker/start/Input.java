package ru.job4j.tracker.start;

/**
 * Интерфейс Input.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.05.2017
 */
public interface Input {
    /**
     * Метод ask для интерфейса.
     * @param question - строка с вопросом.
     * @return - возвращает ответ в строковом формате.
     */
    String ask(String question);
    /**
     * Метод ask интерфейса.
     * @param question - строка с вопросом.
     * @param range - цифровой интервал.
     * @return - возвращает ответ в цифровом формате.
     */
    int ask(String question, int[] range);
}

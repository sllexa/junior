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
     * @return -
     */
    String ask(String question);
}

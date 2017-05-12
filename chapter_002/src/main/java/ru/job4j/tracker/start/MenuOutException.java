package ru.job4j.tracker.start;

/**
 * Класс MenuOutException.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 12.05.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Метод обработки ошибок.
     * @param msg - сообщение.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}

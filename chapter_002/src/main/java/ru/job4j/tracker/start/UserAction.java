package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;

/**
 * Интерфейс UserAction.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 10.05.2017
 */
public interface UserAction {
    /**
     * Метод key - определяет выбор пользователя.
     * @return - возвращает число выбранного пользователем меню.
     */
    int key();
    /**
     * Метод выполняет действие в зависимости от выбора пользователя.
     * @param input - ввод данных.
     * @param tracker - объект работы с заявками.
     */
    void execute(Input input, Tracker tracker);
    /**
     * Метод выводит информацию о действии.
     * @return - возвращает строку с информацией.
     */
    String info();
}

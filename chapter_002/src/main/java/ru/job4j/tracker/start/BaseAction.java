package ru.job4j.tracker.start;

/**
 * Класс BaseAction.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 13.05.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * Поле name.
     */
    private String name;
    /**
     * Поле key.
     */
    private int key;
    /**
     * Конструктор класса.
     * @param name - для изменения name.
     * @param key - для изменения key.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    /**
     * Метод вывода инфорации о меню.
     * @return - возвращает строку с информацией.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}

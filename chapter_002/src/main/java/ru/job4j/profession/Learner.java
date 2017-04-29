package ru.job4j.profession;

/**
 * Класс Learner описывает ученика.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Learner {
    /**
     * name - имя ученика.
     */
    private String name;

    /**
     * Конструктор класса Learner.
     *
     * @param name - имя ученика
     */
    public Learner(String name) {
        this.name = name;
    }

    /**
     * Метод получает имя ученика.
     *
     * @return - возвращает полученное имя
     */
    public String getName() {
        return this.name;
    }
}
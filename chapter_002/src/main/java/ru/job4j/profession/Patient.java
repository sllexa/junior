package ru.job4j.profession;

/**
 * Класс Patient описывает пациента.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Patient {
    /**
     * name - имя пациента.
     */
    private String name;

    /**
     * Конструктор класса Patient.
     *
     * @param name - имя пациента
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Метод получает имя пациента.
     *
     * @return - возвращает полученное имя
     */
    public String getName() {
        return this.name;
    }
}
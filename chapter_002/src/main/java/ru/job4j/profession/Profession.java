package ru.job4j.profession;

/**
 * Класс Profession описывает базовые характеристики профессий.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Profession {
    /**
     *  Основные характеристики профессии.
     *  specialization - профиль профессии
     */
    private String specialization;
    /**
     *  experience - стаж работы.
     */
    private int experience;
    /**
     *  name - имя.
     */
    private String name;
    /**
     * Основной конструктор инициализтрующий класс.
     * @param name - имя
     * @param specialization - профиль профессии
     * @param experience - опыт в годах, полученный по данной профессии
     */
    public Profession(String name, String specialization, int experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }
    /**
     * Метод возвращает имя.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод возвращает профиль професси.
     * @return specialization
     */
    public String getSpecialization() {
        return this.specialization;
    }
    /**
     * Метод возвращает стаж работы.
     * @return experience
     */
    public int getExperience() {
        return this.experience;
    }
}

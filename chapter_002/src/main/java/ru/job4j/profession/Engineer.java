package ru.job4j.profession;

/**
 * Класс Engineer описывает профессию доктора, наследует класс Profession.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Engineer extends Profession {
    /**
     * Конструктор вызывает поля родительского класса.
     *
     * @param name           - имя из родительского класса
     * @param specialization - профиль профессии из родительского класса
     * @param experience     - опыт в годах из родительского класса
     */
    public Engineer(String name, String specialization, int experience) {
        super(name, specialization, experience);
    }

    /**
     * Метод описывает увеличение мощности двигателя инженером.
     *
     * @param engine - двигатель
     * @return - возвращает строку с именами инженера и увеличенной мощностью двигателя
     */
    public String powerIncrease(Engine engine) {
        double result = engine.getPower() * 1.1;
        return String.format("Инженер %s %s увеличил мощность двигателя на 10% и теперь она составляет %.3f.",
                getSpecialization(), getName(), result);
    }

    /**
     * Метод описывает снижение потребления топлива двигателем.
     *
     * @param engine - двигатель
     * @return - возвращает строку с именами инженера и сниженным потреблением топлива
     */
    public String reductionFuelConsumption(Engine engine) {
        double result = engine.getFuelConsumption() / 1.1;
        return String.format("Инженер %s %s снизил потребление топлива двигателем на 10% и теперь она %.3f.",
                getSpecialization(), getName(), result);
    }
}
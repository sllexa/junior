package ru.job4j.profession;

/**
 * Класс Engine описывает двигатель.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Engine {
    /**
     * power - мощность двигателя.
     */
    private int power;
    /**
     * fuelConsumption - потребление топлива двигателем.
     */
    private int fuelConsumption;

    /**
     * Конструктор класса Engine.
     *
     * @param power           - мощность двигателя
     * @param fuelConsumption - потребление топлива двигателем
     */
    public Engine(int power, int fuelConsumption) {
        this.power = power;
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Метод получает мощность двигателя.
     *
     * @return - возвращает полученную мощность
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Метод получает количество потребление топлива двигателем.
     *
     * @return - возвращает количество потребление топлива двигателем
     */
    public int getFuelConsumption() {
        return this.fuelConsumption;
    }
}
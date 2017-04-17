package ru.job4j.calculator;
/**
*Class Calculator решение задачи урок2.
*@author Aleksey Slivko
*@version $1.0$
*@since 17.04.2017
*/
public class Calculator {
    /**
	 * Поле класса.
	 */
	private double result;
    /**
	 * Сложение.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
    public void add(double first, double second) {
		this.result = first + second;
    }
    /**
	 * Метод возвращает результат.
	 * @return результат.
	 */
    public double getResult() {
        return this.result;
    }
    /**
	 * Умножение.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
    /**
	 * Деление.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
}
package ru.job4j.condition;
/**
*Class Point проверяющий принадлежит ли точка функции y(x) = a * x + b.
*@author Aleksey Slivko
*@version $1.0$
*@since 18.04.2017
*/
public class Point {
	/**
	* Поле координаты Х.
	*/
	private int x;
	/**
	* Поле координаты Y.
	*/
	private int y;
	/**
	 * Констпуктор класса.
	 * @param x координата Х.
	 * @param y координата Y.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Получаем значение координаты Х.
	 * @return возвращает значение координаты Х.
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Получаем значение координаты Y.
	 * @return возвращает значение координаты Y.
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * Проверяем принадлежит ли точка функции y(x) = a * x + b.
	 * @param a значение функции
	 * @param b значение функции
	 * @return возвращает true если точка принадлежит функции.
	 */
	public boolean is(int a, int b) {
		return this.y == a * this.x + b;
	}
}
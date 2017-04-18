package ru.job4j.max;
/**
*Class Max нахождение маибольшего числа.
*@author Aleksey Slivko
*@version $1.0$
*@since 18.04.2017
*/
public class Max {
	/**
	 * Метод возвращает наибольшее из двух чисел.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 * @return возвращает результат.
	 */
	public int max(int first, int second) {
		return (first > second) ? first : second;
	}
}
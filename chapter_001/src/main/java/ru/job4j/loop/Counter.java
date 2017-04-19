package ru.job4j.loop;
/**
*Class Counter Подсчет суммы чётных чисел в диапазоне.
*@author Aleksey Slivko
*@version $1.0$
*@since 19.04.2017
*/
public class Counter {
	/**
	 * Метод возвращает сумму четных чисел в диапазоне.
	 * @param start начало диапазона
	 * @param finish конец диапазона
	 * @return возвращает результат
	 */
	public int add(int start, int finish) {
		int result = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}
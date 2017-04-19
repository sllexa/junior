package ru.job4j.loop;
/**
*Class Factorial Вычисляет факториал числа.
*@author Aleksey Slivko
*@version $1.0$
*@since 19.04.2017
*/
public class Factorial {
	/**
	 * Метод высчитывает факториал числа.
	 * @param num число
	 * @return возвращает результат
	 */
	public int calc(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
}
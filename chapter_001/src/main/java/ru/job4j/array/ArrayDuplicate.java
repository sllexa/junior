package ru.job4j.array;

import java.util.Arrays;
/**
*Class ArrayDuplicate Удаление дубликатов в массиве.
*@author Aleksey Slivko
*@version $1.0$
*@since 20.04.2017
*/
public class ArrayDuplicate {
	/**
	 * Метод удаляет дубликаты из массива.
	 * @param str входящий массив
	 * @return возвращает массив без дубликатов
	 */
	public String[] remove(String[] str) {
		int len = str.length - 1;
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (str[i].equals(str[j])) {
					str[i] = str[len];
					len--;
				}
			}
		}
		return Arrays.copyOf(str, len + 1);
	}
}
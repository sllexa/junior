package ru.job4j.array;
/**
* Class TaskSix Тестовы задания к 1 части.
* 1. Проверить упорядочинность массива.
* 2. Данны два отсортированных массива. Нужно соединить их в один, чтобы сортировка осталась.
* @author Aleksey Slivko
* @version $1.0$
* @since 24.04.2017
*/
public class TaskSix {
	/**
	* Метод проверяет, что массив отсортирован.
	* @param nums - входящий массив.
	* @return выводит результат.
	*/
	boolean proverka(int[] nums) {
		boolean result = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] <= nums[i]) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}
	/**
	* Метод соединяет два отсортированных целочисленных массива в один.
	* @param first - первый массив.
	* @param second - второй массив.
	* @return - результирующий массив.
	*/
	public int[] merge(int[] first, int[] second) {
		int[] third = new int[first.length + second.length];
		int fCout = 0;
		int sCout = 0;
		for (int i = 0; i < third.length; i++) {
			if (fCout < first.length && sCout < second.length) {
				if (first[fCout] < second[sCout]) {
					third[i] = first[fCout];
					fCout++;
				} else {
					third[i] = second[sCout];
					sCout++;
				}
			} else if (fCout >= first.length && sCout < second.length) {
				third[i] = second[sCout];
				sCout++;
			} else if (fCout < first[fCout] && sCout >= second.length) {
				third[i] = first[fCout];
				fCout++;
			}
		}
		return third;
	}
}
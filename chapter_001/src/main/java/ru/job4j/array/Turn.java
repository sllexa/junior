package ru.job4j.array;
/**
*Class Turn Переворачивает массив.
*@author Aleksey Slivko
*@version $1.0$
*@since 19.04.2017
*/
public class Turn {
	/**
	 * Метод переварачивает массив.
	 * @param nums входящий массив
	 * @return возвращает перевернутый массив
	 */
	public int[] reverce(int[] nums) {
	int temp;
	for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	return nums;
	}
}
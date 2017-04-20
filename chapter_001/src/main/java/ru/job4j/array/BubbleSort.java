package ru.job4j.array;
/**
*Class BubbleSort сортировка массива методом перестановки.
*@author Aleksey Slivko
*@version $1.0$
*@since 20.04.2017
*/
public class BubbleSort {
	/**
	 * Метод сортирует массив.
	 * @param nums входящий массив
	 * @return возвращает отсортированный массив
	 */
	 public int[] sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j - 1] > nums[j]) {
					int temp;
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	 }
}
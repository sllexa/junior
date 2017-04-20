package ru.job4j.array;
/**
*Class RotateArray поворота квадратного массива.
*@author Aleksey Slivko
*@version $1.0$
*@since 20.04.2017
*/
public class RotateArray {
	/**
	 * Метод поворачивает массив по часовой стрелке.
	 * @param nums входящий массив
	 * @return возвращает повернутый массив
	 */
	public int[][] rotate(int[][] nums) {
		int len = nums.length;
		for (int i = 0; i < (len + 1) / 2; i++) {
			for (int j = 0; j < len / 2; j++) {
				int temp;
				temp = nums[j][i];
				nums[j][i] = nums[len - 1 - i][j];
				nums[len - 1 - i][j] = nums[len - 1 - j][len - 1 - i];
				nums[len - 1 - j][len - 1 - i] = nums[i][len - 1 - j];
				nums[i][len - 1 - j] = temp;
			}
		}
		return nums;
	}
}
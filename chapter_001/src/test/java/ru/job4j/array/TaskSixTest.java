package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* TaskSixTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 24.04.2017
*/
public class TaskSixTest {
	/**
	* Тест проверяющий отсортирован массив или нет.
	*/
	@Test
	public void whenArrayToCheckThenTrueOrFalse() {
		TaskSix task = new TaskSix();
		boolean result = task.proverka(new int[] {1, 2, 3, 4, 5});
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	* Проверка слияния двух отсортированных целочисленных массивов в один.
	*/
	@Test
	public void whenMergeTwoSortedArraysThenOneSortedArray() {
		TaskSix task = new TaskSix();
		int[] result = task.merge(new int[] {1, 3}, new int[] {2, 4});
		int[] expected = new int[] {1, 2, 3, 4};
		assertThat(result, is(expected));
	}
}
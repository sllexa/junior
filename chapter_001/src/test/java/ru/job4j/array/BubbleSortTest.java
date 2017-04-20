package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* BubbleSortTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 20.04.2017
*/
public class BubbleSortTest {
	/**
	* Тест проверяющий сортировку массива из 10 элементов методом пузырька.
	*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort bubl = new BubbleSort();
		int[] result = bubl.sort(new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
		int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expected));
	}
}
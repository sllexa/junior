package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* RotateArrayTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 20.04.2017
*/
public class RotateArrayTest {
	/**
	* Тест проверяющий поворот массива размером 2 на 2.
	*/
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		RotateArray rota = new RotateArray();
		int[][] result = rota.rotate(new int[][] {{1, 2}, {3, 4}});
		int[][] expected = {{3, 1}, {4, 2}};
		assertThat(result, is(expected));
	}
	/**
	* Тест проверяющий поворот массива размером 3 на 3.
	*/
	@Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
		RotateArray rota = new RotateArray();
		int[][] result = rota.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(result, is(expected));
	}
}
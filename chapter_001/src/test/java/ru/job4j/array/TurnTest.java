package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* TurnTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 19.04.2017
*/
public class TurnTest {
	/**
	* Тест проверяющий переворот массива с чётным числом элементов.
	*/
	@Test
	public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
	Turn turn = new Turn();
	int[] result = turn.reverce(new int[] {2, 6, 1, 4});
	int[] expected = {4, 1, 6, 2};
	assertThat(result, is(expected));
	}
	/**
	* Тест проверяющий переворот массива с нечётным числом элементов.
	*/
	@Test
	public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
	Turn turn = new Turn();
	int[] result = turn.reverce(new int[] {1, 2, 3, 4, 5});
	int[] expected = {5, 4, 3, 2, 1};
	assertThat(result, is(expected));
	}
}
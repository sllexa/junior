package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* FactorialTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 19.04.2017
*/
public class FactorialTest {
	/**
	* Тест проверяющий, что факториал для числа 5 равен 120.
	*/
	@Test
	public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
		Factorial fact = new Factorial();
		int result = fact.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}
	/**
	* Тест проверяющий, что факториал для числа 0 равен 1.
	*/
	@Test
	public void whenCalculateFactorialForZeroThenOne() {
		Factorial fact = new Factorial();
		int result = fact.calc(0);
		int expected = 1;
		assertThat(result, is(expected));
	}
}
package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
*
* @author Aleksey Slivko
* @version $Id$
* @since 17.04.2017
*/
public class CalculatorTest {
	/**
	* Test add.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1.0, 1.0);
		double result = calc.getResult();
		double expected = 2.0;
		assertThat(result, is(expected));
	}
	/**
	* Test multiple.
	*/
	@Test
	public void whenMultipleOneUmnozhOneThenOne() {
		Calculator calc = new Calculator();
		calc.multiple(2D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
	/**
	* Test div.
	*/
	@Test
	public void whenDivTwoDelenOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(4D, 2D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
}
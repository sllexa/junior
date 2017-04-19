package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
*
* @author Aleksey Slivko
* @version $Id$
* @since 18.04.2017
*/
public class MaxTest {
	/**
	* Test max.
	*/
	@Test
	public void whenMaxThreeTwoThenThree() {
		Max maxi = new Max();
		int result = maxi.max(3, 2);
		int expected = 3;
		assertThat(result, is(expected));
	}
	/**
	* Test max.
	*/
	@Test
	public void whenMaxThreeTwoFiveThenFive() {
		Max maxi = new Max();
		int result = maxi.max(3, 2, 5);
		int expected = 5;
		assertThat(result, is(expected));
	}
}
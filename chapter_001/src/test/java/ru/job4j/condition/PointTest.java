package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* PointTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 18.04.2017
*/
public class PointTest {
	/**
	* Тест метода is.
	*/
	@Test
	public void setArgumentsOfFunctionAndSpecificPointHappyPath() {
		Point point = new Point(3, 9);
		boolean result = point.is(2, 3);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}
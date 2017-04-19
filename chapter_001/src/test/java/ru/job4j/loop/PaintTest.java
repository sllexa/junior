package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* PaintTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 19.04.2017
*/
public class PaintTest {
	/**
	* Тест проверяющий формирование пирамиды для высоты 2.
	*/
	@Test
	public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
	Paint paint = new Paint();
	String result = paint.piramid(2);
	String expected = String.format(" ^%s^^^", System.getProperty("line.separator"));
	assertThat(result, is(expected));
	}
	/**
	* Тест проверяющий формирование пирамиды для высоты 3.
	*/
	@Test
	public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
	Paint paint = new Paint();
	String result = paint.piramid(3);
	String expected = String.format("  ^%s ^^^%s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
	assertThat(result, is(expected));
	}
}
package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
* TriangleTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 18.04.2017
*/
public class TriangleTest {
	/**
	 * Тест метода area.
	 */
	@Test
	public void testTriangleArea() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(2, 1);
		Point pointC = new Point(1, 2);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		assertThat(triangle.area(), closeTo(0.5, 0.01));
	}
}
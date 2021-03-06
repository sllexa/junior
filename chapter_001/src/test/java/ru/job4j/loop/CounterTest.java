package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* CounterTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 19.04.2017
*/
public class CounterTest {
	/**
	* Тест метода add.
	*/
	@Test
	public void whenSumEvenNumbersFromOneToTenThenThirty() {
		Counter count = new Counter();
		int result = count.add(1, 10);
		int expected = 30;
		assertThat(result, is(expected));
	}
}
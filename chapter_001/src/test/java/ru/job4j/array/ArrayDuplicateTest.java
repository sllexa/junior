package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* ArrayDuplicateTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 20.04.2017
*/
public class ArrayDuplicateTest {
	/**
	* Тест проверяющий удаление дубликатов строк из массива строк.
	*/
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate dupl = new ArrayDuplicate();
		String[] result = dupl.remove(new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"});
		String[] expected = {"Привет", "Мир", "Супер"};
		assertThat(result, is(expected));
	}
}
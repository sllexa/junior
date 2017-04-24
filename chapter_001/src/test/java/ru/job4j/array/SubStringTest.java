package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* SubStringTest class.
*
* @author Aleksey Slivko
* @version $Id$
* @since 24.04.2017
*/
public class SubStringTest {
	/**
	* Cтрока sub является подстрокой origin.
	*/
	@Test
	public void whenSubIsSubstringOfOriginThenTrue() {
		SubString sstr = new SubString();
		boolean result = sstr.contains("Добро пожаловать на job4j.ru", "job4j");
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	* Cтрока sub не является подстрокой origin.
	*/
	@Test
	public void whenSubIsNotSubstringOfOriginThenFalse() {
		SubString sstr = new SubString();
		boolean result = sstr.contains("Колян танцует лучше всех", "Вася");
		boolean expected = false;
		assertThat(result, is(expected));
	}
}
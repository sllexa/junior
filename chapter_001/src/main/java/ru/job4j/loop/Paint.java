package ru.job4j.loop;
/**
*Class Paint Строим пирамиду в псевдографике.
*@author Aleksey Slivko
*@version $1.0$
*@since 19.04.2017
*/
public class Paint {
	/**
	 * Метод строит пирамиду из символа ^.
	 * @param h высота пирамиды
	 * @return строку с пирамидой
	 */
	public String piramid(int h) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= h; i++) {
			for (int j = 0; j < h - i; j++) {
				str.append(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				str.append("^");
			}
			if (i != h) {
				str.append(System.getProperty("line.separator"));
			}
		}
		return str.toString();
	}
}
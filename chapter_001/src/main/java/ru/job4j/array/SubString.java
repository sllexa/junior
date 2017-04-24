package ru.job4j.array;
/**
*Class SubString Создать программу проверяющую, что строка sub является подстрокой origin.
*@author Aleksey Slivko
*@version $1.0$
*@since 20.04.2017
*/
public class SubString {
	/**
	* Метод проверяет, что строка sub является подстрокой origin.
	* @param origin - строка.
	* @param sub - подстрока.
	* @return выводит результат.
	*/
	public boolean contains(String origin, String sub) {
		if (sub.length() > origin.length()) {
			return false;
		}
		boolean result = false;
		char[] aOrigin = origin.toCharArray();
		char[] aSub = sub.toCharArray();

		int originLen = aOrigin.length;
		int subLen = aSub.length;

		for (int i = 0; i <= (originLen - subLen); i++) {
			for (int j = 0; j < subLen; j++) {
				if (aOrigin[i + j] != aSub[j]) {
					break;
				}
				if (j == subLen - 1) {
					result = true;
				}
			}
		}
		return result;
	}
}
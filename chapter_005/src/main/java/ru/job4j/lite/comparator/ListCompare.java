package ru.job4j.lite.comparator;

import java.util.Comparator;
/**
 * Class ListCompare.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.06.2018
 */
public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        int result = 0, i = 0;
        while (i < lim) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            i++;
        }
        return result != 0 ? result : left.length() - right.length();
    }
}

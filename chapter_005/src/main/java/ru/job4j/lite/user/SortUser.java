package ru.job4j.lite.user;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.06.2018
 */
public class SortUser {
    /**
     * Convert List of users to TreeSet and sort users by age.
     * @param list of users.
     * @return TreeSet of users.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}

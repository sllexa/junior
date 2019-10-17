package ru.job4j.lite.user;

import java.util.Comparator;
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

    /**
     * Sort List by name length.
     * @param list of users.
     * @return - sorted list of users.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * Sort List by all fields.
     * @param list of user.
     * @return - sorted list of user.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}

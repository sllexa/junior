package ru.job4j.sort;

import java.util.*;

/**
 * Class SortUser.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.06.2017
 */
public class SortUser {
    /**
     * Convert List of users to TreeSet and sort users by age.
     * @param list of users.
     * @return TreeSet of users.
     */
    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        for (User user : list) {
            users.add(user);
        }
        return users;
    }

    /**
     * Sort List by hashCode.
     * @param list of users.
     * @return sorted list of users.
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode()));
        return list;
    }

    /**
     * Sort List by name length.
     * @param list of users.
     * @return sorted list of users.
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length()));
        return list;
    }
}

package ru.job4j.lite.generics;

import java.util.HashMap;
import java.util.List;

/**
 * Class ConvertUser.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.06.2017
 */
public class ConvertUser {
    /**
     * Convert List of users to HashMap.
     * @param list of Users.
     * @return HashMap with key - user ID and value - user.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}

package ru.job4j.pro.store;


import java.util.HashMap;
import java.util.List;

/**
 * Class Store.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.09.2018
 */
public class Store {
    /**
     * Method diff - return statistics between previous and current lists.
     * @param previous - initial list
     * @param current - modified list
     * @return - statistics
     */
    public Info diff(List<User> previous, List<User> current) {
        HashMap<Integer, String> prevUsers = new HashMap<>(previous.size());
        int addCount = 0;
        int changCount = 0;
        int delCount = 0;

        for (User user : previous) {
            prevUsers.put(user.id, user.name);
        }
        for (User user : current) {
            if (!prevUsers.containsKey(user.id)) {
                addCount++;
            } else if (!prevUsers.get(user.id).equals(user.name)) {
                changCount++;
            }
        }
        delCount = previous.size() + addCount - current.size();
        return new Info(addCount, changCount, delCount);
    }

    /**
     * Static class User.
     */
    static class User {
        /**
         * Id user.
         */
        private int id;
        /**
         * Name user.
         */
        private String name;

        /**
         * Constructor.
         * @param id - for id user
         * @param name - for name user
         */
        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return name.equals(user.name) && id == user.id;
        }

        @Override
        public int hashCode() {
            int result = 20;
            result = 31 * result + id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}

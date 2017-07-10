package ru.job4j.pro.map;

import java.util.Calendar;

/**
 * Class User.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 09.07.2017
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * Children.
     */
    private int children;
    /**
     * Date of birthday.
     */
    private Calendar birthday;

    /**
     * Constructor.
     * @param name - user name
     * @param children - number of children
     * @param birthday - date of birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    /**
//     * Override method equals.
//      * @param o - object
//     * @return - yes or not
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (children != user.children) return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
//    }

    /**
     * Override method hashCode.
     * @return - hashCode
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}

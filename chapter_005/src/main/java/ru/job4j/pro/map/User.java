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
}

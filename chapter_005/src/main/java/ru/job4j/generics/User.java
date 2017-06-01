package ru.job4j.generics;

/**
 * Class User.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.06.2017
 */
public class User {
    /**
     * Count id.
     */
    private int num = 0;
    /**
     * User id.
     */
    private int id = ++num;
    /**
     * User name.
     */
    private String name;
    /**
     * User city.
     */
    private String city;

    /**
     * Constructor.
     * @param name - user name.
     * @param city - user city.
     */
    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /**
     * Getter for id.
     * @return - id.
     */
    public int getId() {
        return this.id;
    }
}

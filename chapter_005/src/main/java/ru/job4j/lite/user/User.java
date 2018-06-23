package ru.job4j.lite.user;

/**
 * Class User.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.06.2018
 */
public class User implements Comparable<User> {
    /**
     * User name.
     */
    private String name;
    /**
     * User age.
     */
    private int age;

    /**
     * Constructor.
     * @param name - user name.
     * @param age - user age.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}

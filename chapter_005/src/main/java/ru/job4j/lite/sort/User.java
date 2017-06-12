package ru.job4j.lite.sort;

/**
 * Class User.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.06.2017
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
    /**
     * Comparing users by age.
     * @param o - other user.
     * @return - 1 if this user older than other, 0 if age is same and -1 if this user younger than other.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    /**
     * Getter name.
     * @return - name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter age.
     * @return - age.
     */
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

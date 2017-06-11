package ru.job4j.lite.bank;

/**
 * Class User.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 06.06.2017
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User passport number.
     */
    private int passport;
    /**
     * User constructor.
     * @param name of user.
     * @param passport number of user.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Name getter.
     * @return name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Pasport number getter.
     * @return passport number.
     */
    public int getPassport() {
        return this.passport;
    }
    /**
     * Comparing user's.
     * @param o other user.
     * @return true if name and passport are same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (passport != user.passport) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }
    /**
     * Generates a hash code.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }
}

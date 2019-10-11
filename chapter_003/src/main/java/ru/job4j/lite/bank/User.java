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
    private String passport;
    /**
     * User constructor.
     * @param name of user.
     * @param passport number of user.
     */
    public User(String name, String passport) {
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
    public String getPassport() {
        return this.passport;
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

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}

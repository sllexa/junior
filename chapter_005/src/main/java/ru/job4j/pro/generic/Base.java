package ru.job4j.pro.generic;

/**
 * Class Base.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.06.2017
 */
public abstract class Base {
    /**
     * id.
     */
    private final String id;

    /**
     * Constructor.
     * @param id - id.
     */
    public Base(final String id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return - id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Override Equals.
     * @param o - object.
     * @return - true or false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Base base = (Base) o;

        return id != null ? id.equals(base.id) : base.id == null;
    }

    /**
     * Override hashCode.
     * @return - number.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

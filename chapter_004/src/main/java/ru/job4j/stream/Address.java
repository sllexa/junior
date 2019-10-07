package ru.job4j.stream;

/**
 * Class Address.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 05.10.2019
 */
public class Address {
    /**
     * City.
     */
    private String city;
    /**
     * Street.
     */
    private String street;
    /**
     * Number home.
     */
    private int home;
    /**
     * Number apartment.
     */
    private int apartment;

    /**
     * Constructor.
     * @param city - city
     * @param street - street
     * @param home - number home
     * @param apartment - number apartment
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**
     * Getter city.
     * @return - city
     */
    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        if (home != address.home) {
            return false;
        }
        if (apartment != address.apartment) {
            return false;
        }
        if (city != null ? !city.equals(address.city) : address.city != null) {
            return false;
        }
        return street != null ? street.equals(address.street) : address.street == null;

    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + home;
        result = 31 * result + apartment;
        return result;
    }
}

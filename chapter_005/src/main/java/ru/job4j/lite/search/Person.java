package ru.job4j.lite.search;

/**
 * Class Person.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 18.06.2018
 */
public class Person {
    /**
     * Person name.
     */
    private String name;
    /**
     * Person surname.
     */
    private String surname;
    /**
     * Person phone.
     */
    private String phone;
    /**
     * Person address.
     */
    private String address;

    /**
     * Constructor.
     * @param name - Person name.
     * @param surname - Person surname.
     * @param phone - Person phone.
     * @param address - Person address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Getter name.
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter surname.
     * @return - surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getter phone.
     * @return - phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter address.
     * @return - address.
     */
    public String getAddress() {
        return address;
    }
}

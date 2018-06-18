package ru.job4j.lite.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 18.06.2018
 */
public class PhoneDictionary {

    /**
     * List person.
     */
    private List<Person> person = new ArrayList<Person>();

    /**
     * Method ađd.
     * @param person - person.
     */
    public void add(Person person) {
        this.person.add(person);
    }

    /**
     * Method find.
     * @param key - String key.
     * @return - List person.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        int ind = 0;
        for (Person people : person) {
            if (people.getName().contains(key) || people.getSurname().contains(key)
                    || people.getPhone().contains(key) || people.getAddress().contains(key)
                    ) {
                result.add(ind, people);
                ind++;
            }
        }
        return result;
    }
}

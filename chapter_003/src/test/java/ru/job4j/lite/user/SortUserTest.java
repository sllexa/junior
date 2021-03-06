package ru.job4j.lite.user;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 22.06.2018
 */
public class SortUserTest {
    /**
     * Test convert List of users to TreeSet and sort users by age.
     */
    @Test
    public void whenListOfUsersConvertToTreeSet() {
        List<User> users = new ArrayList<>(List.of(
                new User("Alex", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new TreeSet<>(Set.of(
                new User("Alex", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        assertThat(result, is(expect));
    }

    /**
     * Test sort List by name length.
     */
    @Test
    public void whenListOfUsersSortByNameLength() {
        List<User> users = new ArrayList<>(List.of(
                new User("Alexandr", 50),
                new User("Nik", 17),
                new User("Vasya", 25),
                new User("Ivan", 36)
        ));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = new ArrayList<>(List.of(
                new User("Nik", 17),
                new User("Ivan", 36),
                new User("Vasya", 25),
                new User("Alexandr", 50)
        ));
        assertThat(result, is(expect));
    }

    /**
     * Test sort List by all fields.
     */
    @Test
    public void whenListOfUserSortByAllFields() {
        List<User> users = new ArrayList<>(List.of(
                new User("Alexandr", 50),
                new User("Ivan", 36),
                new User("Alexandr", 25),
                new User("Ivan", 30)
        ));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = new ArrayList<>(List.of(
                new User("Alexandr", 25),
                new User("Alexandr", 50),
                new User("Ivan", 30),
                new User("Ivan", 36)
        ));
        assertThat(result, is(expect));
    }
}

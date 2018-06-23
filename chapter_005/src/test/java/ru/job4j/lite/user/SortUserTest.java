package ru.job4j.lite.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Alex", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new TreeSet<>();
        expect.addAll(Arrays.asList(
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
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Alexandr", 50),
                new User("Nik", 17),
                new User("Fedor", 25),
                new User("Ivan", 36)
        ));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLenght(users);
        List<User> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(
                new User("Nik", 17),
                new User("Ivan", 36),
                new User("Fedor", 25),
                new User("Alexandr", 50)
        ));
        assertThat(result, is(expect));
    }
}

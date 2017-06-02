package ru.job4j.sort;

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
 * @since 02.06.2017
 */
public class SortUserTest {
    /**
     * test convert List of users to TreeSet and sort users by age.
     */
    @Test
    public void whenListOfUsersConvertToTreeSet() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Ivan", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("Ivan", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        assertThat(result, is(expected));
    }
    /**
     * test sort List by hashCode.
     */
    @Test
    public void whenListOfUsersSortByUsersHashCode() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Ivan", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Sasha", 25)
        ));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortHash(users);
        List<User> expected = new ArrayList<>(users);
        for (int i = 0; i < expected.size() - 1; i++) {
            for (int j = i + 1; j < expected.size(); j++) {
                if (expected.get(i).hashCode() > expected.get(j).hashCode()) {
                    User tmp = expected.get(i);
                    expected.set(i, expected.get(j));
                    expected.set(j, tmp);
                }
            }
        }
        assertThat(result, is(expected));
    }
    /**
     * test sort List by name length.
     */
    @Test
    public void whenListOfUsersSortByNameLength() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Ivan", 50),
                new User("Nikola", 17),
                new User("Fedor", 45),
                new User("Alexandr", 25)
        ));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortLength(users);
        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                new User("Ivan", 50),
                new User("Fedor", 45),
                new User("Nikola", 17),
                new User("Alexandr", 25)
        ));
        assertThat(result, is(expected));
    }
}

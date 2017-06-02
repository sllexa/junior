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
}

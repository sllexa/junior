package ru.job4j.lite.generics;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertUserTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.06.2017
 */
public class ConvertUserTest {
    /**
     * test convert list of users to HashMap with key - user ID and value - user.
     */
    @Test
    public void whenConvertListOfUsersToHashMap() {
        List<User> users = List.of(
                new User("Ivan", "Piter"),
                new User("Maxim", "Tver"),
                new User("Roman", "Moscow")
        );
        ConvertUser conUser = new ConvertUser();
        HashMap<Integer, User> result = conUser.process(users);
        HashMap<Integer, User> expected = new HashMap<>();
        for (User user : users) {
            expected.put(user.getId(), user);
        }
        assertThat(result, is(expected));
    }
}

package ru.job4j.lite.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class UserTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.06.2017
 */
public class UserTest {
    /**
     * test compareTo if one user older than second.
     */
    @Test
    public void whenFirstUserOlderThanSecond() {
        User userFirst = new User("Maxim", 50);
        User userSecond = new User("Vova", 20);
        int result = userFirst.compareTo(userSecond);
        int expected = 1;
        assertThat(result, is(expected));
    }
    /**
     * test compareTo if one user and second are same age.
     */
    @Test
    public void whenOneUserAndSecondAreSameAge() {
        User userFirst = new User("Maxim", 50);
        User userSecond = new User("Vova", 50);
        int result = userFirst.compareTo(userSecond);
        int expected = 0;
        assertThat(result, is(expected));
    }
    /**
     * test compareTo if one user younger than second.
     */
    @Test
    public void whenOneUserYoungerThanSecond() {
        User userFirst = new User("Maxim", 20);
        User userSecond = new User("Vova", 50);
        int result = userFirst.compareTo(userSecond);
        int expected = -1;
        assertThat(result, is(expected));
    }
}

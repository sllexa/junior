package ru.job4j.pro.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class UserTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 09.07.2017
 */
public class UserTest {
    /**
     * Test create and add users in HashMap.
     * Method hashCode not override.
     * Method equals override.
     */
    @Test
    public void whenCreateTwoObjectAndAddInHashMapThenTwoUsers() {
        User firstUser = new User("Max", 2, new GregorianCalendar(1990, 0, 20));
        User secondUser = new User("Max", 2, new GregorianCalendar(1990, 0, 20));

        System.out.println("hashCode first user = " + firstUser.hashCode());
        System.out.println("hashCode second user = " + secondUser.hashCode());

        Map<User, String> map = new HashMap<>();
        map.put(firstUser, "first");
        map.put(secondUser, "second");

        System.out.println(map);

        assertThat(firstUser.equals(secondUser), is(true));
    }
}
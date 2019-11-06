package ru.job4j.pro.generic;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class UserStoreTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 24.06.2017
 */
public class UserStoreTest {
    /**
     * Test add method.
     */
    @Test
    public void whenAddUserInUserStoreTheGetUser() {
        UserStore usst = new UserStore(2);
        usst.add(new User("Alex"));
        User user = new User("Nina");
        usst.add(user);

        assertThat(usst.get("Nina"), is(user));
    }
    /**
     * Test update method.
     */
    @Test
    public void whenAddUserAndUpdateTheChangeUser() {
        UserStore usst = new UserStore(1);
        usst.add(new User("Alex"));
        User user = new User("Nina");
        usst.update("Alex", user);

        assertThat(usst.get("Nina"), is(user));
    }
    /**
     * Test delete method.
     */
    @Test
    public void whenAddUserAndDeleteTheDeleteUser() {
        UserStore usst = new UserStore(2);
        usst.add(new User("001"));
        User user = new User("002");
        usst.add(user);
        usst.delete("001");

        assertThat(usst.get("002"), is(user));
    }

    /**
     * Test delete method false.
     */
    @Test
    public void whenDeleteNotAddedShouldFalse() {
        UserStore userStore = new UserStore(2);
        User user1 = new User("001");
        User user3 = new User("003");
        userStore.add(user1);
        userStore.add(user3);
        assertFalse(userStore.delete("002"));
    }

    /**
     * Test get method exception.
     */
    @Test
    public void whenDeleteEmptyArrayShouldFalse() {
        UserStore userStore = new UserStore(0);
        assertFalse(userStore.delete("002"));
    }

    /**
     * Test update and get methods exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenReplaceAndGetReplacedShouldException() {
        UserStore userStore = new UserStore(3);
        User user1 = new User("001");
        User user2 = new User("002");
        User user3 = new User("003");
        User user4 = new User("004");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertTrue(userStore.update("003", user4));
        assertThat(userStore.get("004"), is(user4));
        userStore.get("003");
    }
}
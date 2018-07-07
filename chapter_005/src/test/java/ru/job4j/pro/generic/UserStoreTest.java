package ru.job4j.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
        usst.add(new User("Nina"));

        assertThat(usst.get("Nina"), is(new User("Nina")));
    }
    /**
     * Test update method.
     */
    @Test
    public void whenAddUserAndUpdateTheChangeUser() {
        UserStore usst = new UserStore(1);
        usst.add(new User("Alex"));
        usst.update("Alex", new User("Nina"));

        assertThat(usst.get("Nina"), is(new User("Nina")));
    }
    /**
     * Test delete method.
     */
    @Test
    public void whenAddUserAndDeleteTheDeleteUser() {
        UserStore usst = new UserStore(2);
        usst.add(new User("001"));
        usst.add(new User("002"));
        usst.delete("001");

        assertThat(usst.get("002"), is(new User("002")));
    }
}
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
        UserStore usst = new UserStore(1);
        usst.add(new User("001"));

        assertThat(usst.get(0), is(new User("001")));
    }
    /**
     * Test update method.
     */
    @Test
    public void whenAddUserAndUpdateTheChangeUser() {
        UserStore usst = new UserStore(1);
        usst.add(new User("001"));
        usst.update(0, new User("005"));

        assertThat(usst.get(0), is(new User("005")));
    }
    /**
     * Test delete method.
     */
    @Test
    public void whenAddUserAndDeleteTheDeleteUser() {
        UserStore usst = new UserStore(2);
        usst.add(new User("001"));
        usst.add(new User("002"));
        usst.delete(0);

        assertThat(usst.get(0), is(new User("002")));
    }
}
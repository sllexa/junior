package ru.job4j.pro.generic;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class RoleStoreTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.11.2019
 */
public class RoleStoreTest {

    /**
     * Test add method.
     */
    @Test
    public void whenAddRoleInRoleStoreTheGetRole() {
        RoleStore roleStore = new RoleStore(2);
        roleStore.add(new Role("Alex"));
        Role role = new Role("Nina");
        roleStore.add(role);

        assertThat(roleStore.get("Nina"), is(role));
    }
    /**
     * Test update method.
     */
    @Test
    public void whenAddRoleAndUpdateTheChangeRole() {
        RoleStore roleStore = new RoleStore(1);
        roleStore.add(new Role("Alex"));
        Role role = new Role("Nina");
        roleStore.update("Alex", role);

        assertThat(roleStore.get("Nina"), is(role));
    }
    /**
     * Test delete method.
     */
    @Test
    public void whenAddRoleAndDeleteTheDeleteRole() {
        RoleStore roleStore = new RoleStore(2);
        roleStore.add(new Role("001"));
        Role role = new Role("002");
        roleStore.add(role);
        roleStore.delete("001");

        assertThat(roleStore.get("002"), is(role));
    }

    /**
     * Test delete method false.
     */
    @Test
    public void whenDeleteNotAddedShouldFalse() {
        RoleStore roleStore = new RoleStore(2);
        Role role1 = new Role("001");
        Role role3 = new Role("003");
        roleStore.add(role1);
        roleStore.add(role3);
        assertFalse(roleStore.delete("002"));
    }

    /**
     * Test delete method false.
     */
    @Test
    public void whenDeleteEmptyArrayShouldFalse() {
        RoleStore roleStore = new RoleStore(0);
        assertFalse(roleStore.delete("002"));
    }

    /**
     * Test get method exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetNotPresentShouldException() {
        RoleStore roleStore = new RoleStore(2);
        Role role2 = new Role("002");
        Role role3 = new Role("003");
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.get("004");
    }

    /**
     * Test update and get methods exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenReplaceAndGetReplacedShouldException() {
        RoleStore roleStore = new RoleStore(3);
        Role role1 = new Role("001");
        Role role2 = new Role("002");
        Role role3 = new Role("003");
        Role role4 = new Role("004");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertTrue(roleStore.update("003", role4));
        assertThat(roleStore.get("004"), is(role4));
        roleStore.get("003");
    }
}
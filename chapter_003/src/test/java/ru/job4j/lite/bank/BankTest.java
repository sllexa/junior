package ru.job4j.lite.bank;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BankTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 06.06.2017
 */
public class BankTest {
    /**
     * Object bank.
     */
    private Bank bank = new Bank();
    /**
     * It is expected to receive.
     */
    private Map<User, List<Account>> expected = new HashMap<>();
    /**
     * List users.
     */
    private List<User> users = Arrays.asList(
            new User("Maxim", "45098775"),
            new User("Nikola", "72814612"),
            new User("Mary", "20015088"),
            new User("Nikola", "72814612")
    );

    /**
     * Test method get user account.
     */
    @Test
    public void whenGetAccountThenAccount() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        this.bank.addAccountToUser("72814612", new Account("000445"));
        Account acc = this.bank.getAccountByPassportAndDetails("72814612", "000445");
        Account expect = new Account("000445");
        assertThat(acc, is(expect));
    }

    /**
     * test adding client to bank.
     */
    @Test
    public void whenAddClientToBank() {
        for (User user : this.users) {
            bank.addUser(user);
            this.expected.putIfAbsent(user, new ArrayList<>());
        }
        Map<User, List<Account>> result = bank.getMap();
        assertThat(result, is(this.expected));
    }
    /**
     * test deleting client from bank.
     */
    @Test
    public void whenDeleteClientFromBank() {
        for (User user : this.users) {
            bank.addUser(user);
            this.expected.putIfAbsent(user, new ArrayList<>());
        }
        User duser = new User("Nikola", "72814612");
        this.bank.deleteUser(duser);
        Map<User, List<Account>> result = bank.getMap();
        this.expected.remove(duser);
        assertThat(result, is(this.expected));
    }
    /**
     * test adding account to bank client.
     */
    @Test
    public void whenAddAccountToClient() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        this.bank.addAccountToUser("72814612", new Account("000445"));
        Map<User, List<Account>> result = bank.getMap();
        this.expected.put(firstUser, new ArrayList<>());
        this.expected.put(secondUser, Collections.singletonList(new Account("000445")));
        assertThat(result, is(this.expected));
    }
    /**
     * test deleting account from client's account list.
     */
    @Test
    public void whenDeleteAccountFromClient() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        bank.addAccountToUser("72814612", new Account("000445"));
        bank.addAccountToUser("72814612", new Account("000333"));
        bank.deleteAccountFromUser("72814612", new Account("000445"));
        Map<User, List<Account>> result = bank.getMap();
        expected.put(firstUser, new ArrayList<>());
        List<Account> list = new ArrayList<>();
        list.add(new Account("000333"));
        expected.put(secondUser, list);
        assertThat(result, is(expected));
    }
    /**
     * test getting client's account list.
     */
    @Test
    public void whenGetListOfAccountsFromClient() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        bank.addAccountToUser("72814612", new Account("000445"));
        bank.addAccountToUser("72814612", new Account("000333"));
        bank.addAccountToUser("72814612", new Account("000111"));
        List<Account> result = null;
        result = bank.getUserAccounts("72814612");
        List<Account> expected = Arrays.asList(new Account("000445"),
                new Account("000333"), new Account("000111"));
        assertThat(result, is(expected));
    }
    /**
     * test transfer money.
     * Transfer from account to other, when balance of source account more than transfer value.
     */
    @Test
    public void transferWhenOneAccountsMoreThanTransferValue() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        Account firstAcc = new Account("000445");
        firstAcc.setValue(500D);
        Account secondAcc = new Account("000333");
        secondAcc.setValue(100D);
        bank.addAccountToUser("45098775", firstAcc);
        bank.addAccountToUser("72814612", secondAcc);
        boolean result = bank.transferMoney("45098775", "000445", "72814612", "000333", 100D);
        assertThat(result, is(true));
        assertThat(firstAcc.getValue(), is(400.0));
        assertThat(secondAcc.getValue(), is(200.0));
    }
    /**
     * test transfer money.
     * Transfer from account to other, when balance of source account less than destination.
     */
    @Test
    public void transferWhenOneAccountsLessThanTransferValue() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        Account firstAcc = new Account("000445");
        firstAcc.setValue(300D);
        Account secondAcc = new Account("000333");
        secondAcc.setValue(100D);
        bank.addAccountToUser("45098775", firstAcc);
        bank.addAccountToUser("72814612", secondAcc);
        boolean result = bank.transferMoney("45098775", "000445", "72814612", "000333", 350D);
        assertThat(result, is(false));
    }
    /**
     * test transfer money.
     * Transfer from account to other, when no source account in client's account list.
     */
    @Test
    public void transferWhenNoSourceAccount() {
        User firstUser = new User("Maxim", "45098775");
        User secondUser = new User("Nikola", "72814612");
        this.bank.addUser(firstUser);
        this.bank.addUser(secondUser);
        Account firstAcc = new Account("000445");
        firstAcc.setValue(500D);
        Account secondAcc = new Account("000333");
        secondAcc.setValue(100D);
        Account thirdAcc = new Account("000111");
        thirdAcc.setValue(300D);
        bank.addAccountToUser("45098775", firstAcc);
        bank.addAccountToUser("72814612", secondAcc);
        bank.addAccountToUser("45098775", thirdAcc);
        boolean result = false;
        result = bank.transferMoney("45098775", "000111", "72814612", "000333", 50D);
        assertThat(result, is(true));
    }
}

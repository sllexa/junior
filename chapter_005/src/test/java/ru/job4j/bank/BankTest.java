package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * test adding client to bank.
     */
    @Test
    public void whenAddClientToBank() {
        Bank bank = new Bank();
        bank.addUser(new User("Maxim", 45098775));
        bank.addUser(new User("Nikola", 72814612));
        bank.addUser(new User("Mary", 20015088));
        Map<User, List<Account>> result = bank.map;
        Map<User, List<Account>> expected = new HashMap<>();
        expected.put(new User("Maxim", 45098775), new ArrayList<>());
        expected.put(new User("Nikola", 72814612), new ArrayList<>());
        expected.put(new User("Mary", 20015088), new ArrayList<>());
        assertThat(result, is(expected));
    }
    /**
     * test deleting client from bank.
     */
    @Test
    public void whenDeleteClientFromBank() {
        Bank bank = new Bank();
        bank.addUser(new User("Maxim", 45098775));
        bank.addUser(new User("Nikola", 72814612));
        bank.addUser(new User("Mary", 20015088));
        bank.deleteUser(new User("Nikola", 72814612));
        Map<User, List<Account>> result = bank.map;
        Map<User, List<Account>> expected = new HashMap<>();
        expected.put(new User("Maxim", 45098775), new ArrayList<>());
        expected.put(new User("Mary", 20015088), new ArrayList<>());
        assertThat(result, is(expected));
    }
    /**
     * test adding account to bank client.
     */
    @Test
    public void whenAddAccountToClient() {
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        bank.addAccountToUser(secondUser, new Account(000445));
        Map<User, List<Account>> result = bank.map;
        Map<User, List<Account>> expected = new HashMap<>();
        expected.put(firstUser, new ArrayList<>());
        List<Account> list = new ArrayList<>();
        list.add(new Account(000445));
        expected.put(secondUser, list);
        assertThat(result, is(expected));
    }
    /**
     * test deleting account from client's account list.
     */
    @Test
    public void whenDeleteAccountFromClient() {
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        bank.addAccountToUser(secondUser, new Account(000445));
        bank.addAccountToUser(secondUser, new Account(000333));
        bank.deleteAccountFromUser(secondUser, new Account(000445));
        Map<User, List<Account>> result = bank.map;
        Map<User, List<Account>> expected = new HashMap<>();
        expected.put(firstUser, new ArrayList<>());
        List<Account> list = new ArrayList<>();
        list.add(new Account(000333));
        expected.put(secondUser, list);
        assertThat(result, is(expected));
    }
    /**
     * test getting client's account list.
     */
    @Test
    public void whenGetListOfAccountsFromClient() {
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        bank.addAccountToUser(secondUser, new Account(000445));
        bank.addAccountToUser(secondUser, new Account(000333));
        bank.addAccountToUser(secondUser, new Account(000111));
        List<Account> result = null;
        result = bank.getUserAccounts(secondUser);
        List<Account> expected = new ArrayList<>();
        expected.add(new Account(000445));
        expected.add(new Account(000333));
        expected.add(new Account(000111));
        assertThat(result, is(expected));
    }
    /**
     * test transfer money.
     * Transfer from account to other, when balance of source account more than transfer value.
     */
    @Test
    public void transferWhenOneAccountsMoreThanTransferValue() {
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        Account firstAcc = new Account(000445);
        firstAcc.setValue(500D);
        Account secondAcc = new Account(000333);
        secondAcc.setValue(100D);
        bank.addAccountToUser(firstUser, firstAcc);
        bank.addAccountToUser(secondUser, secondAcc);
        boolean result = false;
        result = bank.transferMoney(firstUser, firstAcc, secondUser, secondAcc, 100D);
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
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        Account firstAcc = new Account(000445);
        firstAcc.setValue(300D);
        Account secondAcc = new Account(000333);
        secondAcc.setValue(100D);
        bank.addAccountToUser(firstUser, firstAcc);
        bank.addAccountToUser(secondUser, secondAcc);
        boolean result = false;
        result = bank.transferMoney(firstUser, firstAcc, secondUser, secondAcc, 350D);
        assertThat(result, is(false));
    }
    /**
     * test transfer money.
     * Transfer from account to other, when no source account in client's account list.
     */
    @Test
    public void transferWhenNoSourceAccount() {
        User firstUser = new User("Maxim", 45098775);
        User secondUser = new User("Nikola", 72814612);
        Bank bank = new Bank();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        Account firstAcc = new Account(000445);
        firstAcc.setValue(500D);
        Account secondAcc = new Account(000333);
        secondAcc.setValue(100D);
        Account thirdAcc = new Account(000111);
        thirdAcc.setValue(300D);
        bank.addAccountToUser(firstUser, firstAcc);
        bank.addAccountToUser(secondUser, secondAcc);
        boolean result = false;
        result = bank.transferMoney(firstUser, thirdAcc, secondUser, secondAcc, 50D);
        assertThat(result, is(false));
    }
}

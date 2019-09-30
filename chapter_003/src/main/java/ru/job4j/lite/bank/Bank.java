package ru.job4j.lite.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 06.06.2017
 */
public class Bank {
    /**
     * map with key - user and value - list of user accounts.
     */
    private Map<User, List<Account>> map = new HashMap<>();
    /**
     * Add client to bank.
     * @param user - bank client.
     */
    public void addUser(User user) {
        this.map.put(user, new ArrayList<Account>());
    }
    /**
     * Delete client from bank.
     * @param user for deleting.
     */
    public void deleteUser(User user) {
        if (this.map.containsKey(user)) {
            this.map.remove(user);
        }
    }
    /**
     * Add account to client from bank.
     * @param user for adding account.
     * @param account for adding to user's account list.
     */
    public void addAccountToUser(User user, Account account) {
        if (this.map.containsKey(user)) {
            this.map.get(user).add(account);
        }
    }
    /**
     * Delete account from client's account list.
     * @param user for deleting account.
     * @param account for deleting from user's account list.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (this.map.containsKey(user)) {
            List<Account> list = this.map.get(user);
            if (list.contains(account)) {
                list.remove(account);
            } else {
                System.out.println("Client hasn't this account");
            }
        }
    }
    /**
     * Get client's account list.
     * @param user for getting account list.
     * @return user's account list.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> list = null;
        if (this.map.containsKey(user)) {
            list = map.get(user);
        }
        return list;
    }
    /**
     * Transfer money from one account to other. Return false if bank hasn't source or destination accounts
     * and if source account's balance is less than transfer value.
     *
     * @param srcUser - source client.
     * @param srcAccount - source client's account.
     * @param dstUser - destination client.
     * @param dstAccount - destination client's account.
     * @param amount - value of money for transfer.
     * @return true if transfer is made.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transfer = false;
        if (this.map.containsKey(srcUser) && this.map.containsKey(dstUser)) {
            List<Account> srcAccountList = this.map.get(srcUser);
            List<Account> dstAccountList = this.map.get(dstUser);
            if (srcAccountList.contains(srcAccount) && dstAccountList.contains(dstAccount)) {
                Account srcAcc = this.getAccountFromList(srcUser, srcAccount);
                Account dstAcc = this.getAccountFromList(dstUser, dstAccount);
                if (srcAcc.getValue() >= amount) {
                    srcAcc.setValue(srcAcc.getValue() - amount);
                    dstAcc.setValue(dstAcc.getValue() + amount);
                    transfer = true;
                }
            }
        }
        return transfer;
    }
    /**
     * Get reference to client's account.
     * @param user for getting reference to account.
     * @param account for getting reference.
     * @return reference to user's account.
     */
    private Account getAccountFromList(User user, Account account) {
        Account result = null;
        for (Account tmp : this.map.get(user)) {
            if (tmp.equals(account)) {
                result = tmp;
            }
        }
        return result;
    }
    /**
     * Getter copy of map.
     * @return copy of map.
     */
    Map<User, List<Account>> getMap() {
        return this.map;
    }
}

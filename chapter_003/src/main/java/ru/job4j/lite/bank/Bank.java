package ru.job4j.lite.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private boolean acc;

    /**
     * Add client to bank.
     * @param user - bank client.
     */
    public void addUser(User user) {
        this.map.putIfAbsent(user, new ArrayList<Account>());
    }
    /**
     * Delete client from bank.
     * @param user for deleting.
     */
    public void deleteUser(User user) {
        this.map.remove(user);
    }
    /**
     * Add account to client from bank.
     * @param passport for adding account.
     * @param account for adding to user's account list.
     */
    public void addAccountToUser(String passport, Account account) {
        this.map.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findFirst()
                .map(user -> this.map.get(user.getKey()))
                .ifPresent(accounts -> accounts.add(account));
            /*for (User user : this.map.keySet()) {
                if (user.getPassport().equals(passport)) {
                    this.map.get(user).add(account);
                }
            }*/
    }
    /**
     * Delete account from client's account list.
     * @param passport for deleting account.
     * @param account for deleting from user's account list.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.map.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findFirst()
                .map(user -> this.map.get(user.getKey()))
                .ifPresent(accounts -> accounts.remove(account));
        /*for (User user : this.map.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.map.get(user).remove(account);
            }
        }*/
    }
    /**
     * Get client's account list.
     * @param passport for getting account list.
     * @return user's account list.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = null;
        list = this.map.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findFirst()
                .map(u -> this.map.get(u.getKey()))
                .get();
        /*for (User user : this.map.keySet()) {
            if (user.getPassport().equals(passport)) {
                list = map.get(user);
            }
        }*/
        return list;
    }

    /**
     * Transfer money from one account to other. Return false if bank hasn't source or destination accounts
     * and if source account's balance is less than transfer value.
     * @param srcPassport - source client passport
     * @param srcRequisite - source client account requisites
     * @param destPassport - destination client passport
     * @param dstRequisite - destination client account requisites
     * @param amount - value of money for transfer
     * @return - true if transfer is made
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean transfer = false;
        Account srcAcc = getAccountByPassportAndDetails(srcPassport, srcRequisite);
        Account destAcc = getAccountByPassportAndDetails(destPassport, dstRequisite);
        if (srcAcc.getValue() >= amount) {
            srcAcc.setValue(srcAcc.getValue() - amount);
            destAcc.setValue(destAcc.getValue() + amount);
            transfer = true;
        }
        return transfer;
    }

    /**
     * Get reference to client's account.
     * @param passport - for getting reference to account
     * @param requisites - for getting reference
     * @return - reference to user's account
     */
    Account getAccountByPassportAndDetails(String passport, String requisites) {
        Account result = null;
        List<Account> list;
        list = this.map.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();
        result = list.stream()
                .filter(account -> account.getRequisites().equals(requisites))
                .findFirst()
                .get();
        /*for (Map.Entry entry : this.map.entrySet()) {
            User user = (User) entry.getKey();
            if (user.getPassport().equals(passport)) {
                List<Account> listAcc = (List<Account>) entry.getValue();
                for (Account acc : listAcc) {
                    if (acc.getRequisites().equals(requisites)) {
                        result = acc;
                        break;
                    }
                }
            }
            if (result != null) {
                break;
            }
        }*/
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

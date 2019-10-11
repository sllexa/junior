package ru.job4j.lite.bank;

/**
 * Class Account.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 06.06.2017
 */
public class Account {
    /**
     * Account balance.
     */
    private double value;
    /**
     * Account requisites.
     */
    private String requisites;
    /**
     * Account constructor.
     * @param requisites of account.
     */
    public Account(String requisites) {
        this.requisites = requisites;
    }
    /**
     * Account value getter.
     * @return value of money.
     */
    public double getValue() {
        return this.value;
    }
    /**
     * Account value setter.
     * @param value of money.
     */
    public void setValue(double value) {
        this.value = value;
    }
    /**
     * Account requisites getter.
     * @return account requisites.
     */
    public String getRequisites() {
        return this.requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }
}

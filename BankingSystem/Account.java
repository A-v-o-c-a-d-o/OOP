package BankingSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {}

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void doWithdrawing(double n) throws BankException {}

    public void doDepositing(double n) throws BankException {}

    public abstract void withdraw(double n);

    public abstract void deposit(double n);

    /** History. */
    public String getTransactionHistory() {
        String ans = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (Transaction i: transactionList) {
            ans += "\n" + i.getTransactionSummary();
        }
        return ans;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        if (accountNumber != other.accountNumber) {
            return false;
        }
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (transactionList == null) {
            if (other.transactionList != null) {
                return false;
            }
        } else if (!transactionList.equals(other.transactionList)) {
            return false;
        }
        return true;
    }
}
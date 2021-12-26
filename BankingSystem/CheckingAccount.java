package BankingSystem;

public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void doWithdrawing(double n) throws BankException {
        if (n < 0) {
            throw new InvalidFundingAmountException(n);
        } else if (n > balance) {
            throw new InsufficientFundsException(n);
        }
        addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
                        n, balance, balance - n));
        balance -= n;
    }

    @Override
    public void doDepositing(double n) throws BankException {
        if (n < 0) {
            throw new InvalidFundingAmountException(n);
        }
        addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                        n, balance, balance + n));
        balance += n;
    }


    @Override
    public void withdraw(double n) {
        try {
            doWithdrawing(n);
        } catch (BankException e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void deposit(double n) {
        try {
            doDepositing(n);
        } catch (BankException e) {
            System.out.print(e.getMessage());
        }
    }
}

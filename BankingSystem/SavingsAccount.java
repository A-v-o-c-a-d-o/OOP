package BankingSystem;

public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void doWithdrawing(double n) throws BankException {
        if (n < 0) {
            throw new InvalidFundingAmountException(n);
        } else if (n > balance) {
            throw new InsufficientFundsException(n);
        } else if (balance < 5000) {
            throw new InsufficientFundsException(5000);
        } else if (n > 1000) {
            throw new InvalidFundingAmountException(n);
        }
        
        addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                        n, balance, balance - n));
        balance -= n;
    }

    @Override
    public void doDepositing(double n) throws BankException {
        if (n < 0) {
            throw new InvalidFundingAmountException(n);
        }
        addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
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
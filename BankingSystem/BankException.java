package BankingSystem;

public abstract class BankException extends Exception {
    public BankException(String mes) {
        super(mes);
    }

    public BankException() {}
}
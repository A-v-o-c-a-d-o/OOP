package BankingSystem;

public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double n) {
        super(String.format("Số tiền không hợp lệ: $%.2f", n));
    }
}
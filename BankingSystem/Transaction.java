package BankingSystem;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /** create. */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }
    
    /** type. */
    public String getTransactionTypeString(int n) {
        String ans = "";
        
        switch (n) {
            case TYPE_DEPOSIT_CHECKING:
                ans = "Nạp tiền vãng lai";
                break;
            case TYPE_DEPOSIT_SAVINGS:
                ans = "Nạp tiền tiết kiệm";
                break;
            case TYPE_WITHDRAW_CHECKING:
                ans = "Rút tiền vãng lai";
                break;
            case TYPE_WITHDRAW_SAVINGS:
                ans = "Rút tiền tiết kiệm";
                break;
            default:
                break;
        }

        return ans;
    }

    /** toString. */
    public String getTransactionSummary() {
        return String.format("- Kiểu giao dịch: " + getTransactionTypeString(type)
            + ". Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
            initialBalance, amount, finalBalance);
    }
}
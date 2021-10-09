package Transaction;

import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
            transitionList.add(new Transaction("deposit", amount, balance));            
        }
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transitionList.add(new Transaction("withdraw", amount, balance));
        }
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void addTransaction(double amount, String operation) {
        if (operation == Transaction.DEPOSIT) {
            deposit(amount);
        } else if (operation == Transaction.WITHDRAW) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void printTransaction() {
        int num = 1;
        for (Transaction i: transitionList) {
            System.out.print("Giao dich " + num);
            System.out.print(i.getOperation().equals(Transaction.DEPOSIT)
                            ? ": Nap tien $" : ": Rut tien $");
            System.out.printf("%.2f", i.getAmount());
            System.out.print(". So du luc nay: $");
            System.out.printf("%.2f", i.getBalance());
            System.out.println(".");
            num++;
        }
    }
}
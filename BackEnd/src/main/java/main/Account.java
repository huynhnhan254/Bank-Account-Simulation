package main;

public class Account {
    private String accountID;
    private double balance;

    public Account(String accountID) {
        this.accountID = accountID;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Does not have enough balance");
        }
        balance -= amount;
    }

    public void transferMoney(Account recipent, double amount) {
        if (amount < 0 || recipent == null) {
            throw new IllegalArgumentException("Amount cannot be negative or received a null object");
        }
        withdraw(amount);
        recipent.deposit(amount);
    }
}

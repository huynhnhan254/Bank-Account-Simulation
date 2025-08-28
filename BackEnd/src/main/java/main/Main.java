package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Bank bank = new Bank();

        //Create account
        bank.createAccount("account1");
        bank.createAccount("account2");

        //Deposit
        Account account1 = bank.getAccount("account1");
        if (account1 == null) {
            System.out.println("Account not found");
        } else {
            account1.deposit(1000);
            System.out.println("Account deposit: $" + account1.getBalance());
        }
        Account account2 = bank.getAccount("account2");
        if (account2 == null) {
            System.out.println("Account not found");
        } else {
            account2.deposit(1000);
            System.out.println("Account deposit: $" + account2.getBalance());
        }

        //Withdraw
        account1.withdraw(50);
        System.out.println("Withdraw successful!!!");
        System.out.println("Account 1 balance: $" + account1.getBalance());
        account2.withdraw(50);
        System.out.println("Account 2 balance: $" + account2.getBalance());

        //Transfer 50 from account1 to account 2
        account1.transferMoney(account2, 50);
        System.out.println("Transfer successful!!!");
        System.out.println("Account 1 balance: $" + account1.getBalance());
        System.out.println("Account 2 balance: $" + account2.getBalance());

    }
}

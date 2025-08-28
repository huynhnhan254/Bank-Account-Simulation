package main;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accountManage = new HashMap<>();

    public Account createAccount(String accountID) {
        //Check whether account already exists
        if (accountManage.containsKey(accountID)) {
            throw new IllegalArgumentException("Account already exists");
        } else {
            // Create account
            Account account = new Account(accountID);
            accountManage.put(accountID, account);
            return account;
        }
    }

    //Return account
    public Account getAccount(String accountID) {
        if (accountManage.containsKey(accountID)) {
            return accountManage.get(accountID);
        }
        return null;
    }
}

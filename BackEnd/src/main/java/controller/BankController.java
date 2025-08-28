package controller;

import main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    private Bank bankService;

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam String accountName) {
        bankService.createAccount(accountName);
        return "Account created: " + accountName;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountName, @RequestParam double amount) {
        Account account = bankService.getAccount(accountName);
        if (account == null) return "Account not found";
        account.deposit(amount);
        return "Deposited $" + amount + " to " + accountName;
    }

    // Similarly, implement withdraw, transfer, etc.
}

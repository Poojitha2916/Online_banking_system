package online_banking.services;

import java.util.HashMap;
import java.util.Map;

import online_banking.models.BankAccount;
import online_banking.exceptions.*;

public class BankService {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String id, String name, double initialDeposit) {
        BankAccount account = new BankAccount(id, name, initialDeposit);
        accounts.put(id, account);
    }

    public void deposit(String id, double amount) throws InvalidAccountException {
        BankAccount account = getAccount(id);
        account.deposit(amount);
    }

    public void withdraw(String id, double amount) throws InvalidAccountException, InsufficientFundsException {
        BankAccount account = getAccount(id);
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough balance.");
        }
        account.withdraw(amount);
    }

    public double getBalance(String id) throws InvalidAccountException {
        return getAccount(id).getBalance();
    }

    public BankAccount getAccount(String id) throws InvalidAccountException {
        BankAccount account = accounts.get(id);
        if (account == null) throw new InvalidAccountException("Account ID not found.");
        return account;
    }
}

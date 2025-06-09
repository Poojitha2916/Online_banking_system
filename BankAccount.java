package online_banking.models;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountId;
    private String holderName;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountId, String holderName, double balance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

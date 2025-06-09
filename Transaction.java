package online_banking.models;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return date + " - " + type + ": ₹" + amount;
    }
}

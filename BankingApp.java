package online_banking.main;

import java.util.Scanner;

import online_banking.exceptions.*;
import online_banking.services.BankService;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n--- Online Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account ID: ");
                        String id = sc.next();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Initial Deposit: ");
                        double deposit = sc.nextDouble();
                        bank.createAccount(id, name, deposit);
                        System.out.println("Account created successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Account ID: ");
                        id = sc.next();
                        System.out.print("Amount to deposit: ");
                        deposit = sc.nextDouble();
                        bank.deposit(id, deposit);
                        System.out.println("Deposit successful. New Balance: ₹" + bank.getBalance(id));
                        break;

                    case 3:
                        System.out.print("Enter Account ID: ");
                        id = sc.next();
                        System.out.print("Amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        bank.withdraw(id, withdraw);
                        System.out.println("Withdrawal successful. New Balance: ₹" + bank.getBalance(id));
                        break;

                    case 4:
                        System.out.print("Enter Account ID: ");
                        id = sc.next();
                        System.out.println("Current Balance: ₹" + bank.getBalance(id));
                        break;

                    case 5:
                        System.out.println("Thank you for using Online Banking System!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

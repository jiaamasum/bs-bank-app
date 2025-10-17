package thebankapp;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private Customer customer;
    private double balance;
    private List<Transactions> transactions;

    public Account(String accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.transactions = new ArrayList<Transactions>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Invalid amount. Try again");
            return;
        }

        balance += amount;

        Transactions t = new Transactions("DEPOSIT", amount, null, accountNumber);
        transactions.add(t);
        System.out.println("Deposited " + amount + " Successfully");
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
            if (amount > balance) {
                throw new Exception("Insufficient balance!");
            }
            balance -= amount;
            transactions.add(new Transactions("WITHDRAW", amount, accountNumber, null));
            System.out.println("Withdrawn " + amount + " successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: I " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: J " + e.getMessage());
        }
    }

    public void transfer(Account target, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        if (target == null) {
            System.out.println("Target account not found!");
            return;
        }

        // perform transfer
        this.balance -= amount;
        target.balance += amount;

        // log both transactions
        this.transactions.add(new Transactions("TRANSFER_OUT", amount, this.accountNumber, target.getAccountNumber()));
        target.transactions.add(new Transactions("TRANSFER_IN", amount, this.accountNumber, target.getAccountNumber()));

        System.out.println("Transferred " + amount + " to account " + target.getAccountNumber() + " successfully.");
    }

    public void showBalance() {
        System.out.println("Account " + accountNumber + " | Balance: " + balance);
    }

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction history for " + accountNumber + ":");
            for (Transactions t : transactions) {
                System.out.println(t);
            }
        }

    }
}

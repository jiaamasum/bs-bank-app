package thebankapp;

public class Bank {
    public static void main(String[] args) {
        Customer c1 = new Customer(101, "Masum", "masum@email.com");
        Customer c2 = new Customer(102, "Rahim", "rahim@email.com");


        Account a1 = new Account("A1001", c1,1000000000);
        Account a2 = new Account("A1002", c2,500000000);

        a1.deposit(1000);
        a2.withdraw(500000000);
        a1.transfer(a2, 988);


        a1.showBalance();
        a2.showBalance();

        a1.printTransactions();
        a2.printTransactions();


    }
}
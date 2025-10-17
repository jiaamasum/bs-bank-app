package thebankapp;

import java.time.LocalDate;

public class Transactions {

    private String type;
    private double amount;
    private LocalDate timeStamp;
    private String sourceAccount;
    private String destinationAccount;

    public Transactions(String type, double amount, String sourceAccount, String destinationAccount) {
        this.type = type;
        this.amount = amount;
        this.timeStamp = timeStamp.now();
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString () {
        String text = "[" + timeStamp + "]" + type + " - " + amount;

        if(sourceAccount != null){
            text += " (to " + destinationAccount + " )";
        }

        if(destinationAccount != null){
            text += " (from " + sourceAccount + " )";
        }

        return text;

    }
}
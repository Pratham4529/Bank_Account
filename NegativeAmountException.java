package com.aurionpro.model;

public class NegativeAmountException extends RuntimeException {

    private final double amount;

    public NegativeAmountException(double amount) {
        super("THE AMOUNT YOU ENTERED IS NEGATIVE: " + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

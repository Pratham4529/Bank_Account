package com.aurionpro.model;

public class MinBalanceVoilationException extends RuntimeException {

    private final double amount;

    public MinBalanceVoilationException(double amount) {
        super("You have to maintain a minimum balance of 10k. Debit denied.");
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

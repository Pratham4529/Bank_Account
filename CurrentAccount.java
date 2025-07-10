package com.aurionpro.model;

public class CurrentAccount extends BankAccount {

    private final int OVERDRAFT_LIMIT = 50000;

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double credit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        balance += amount;
        System.out.println(amount + " credited. New Balance: " + balance);
        return balance;
    }

    @Override
    public final double debit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println(amount + " debited. New Balance: " + balance);
        } else {
            throw new OverdraftLimitExceededException(amount);
        }
        return balance;
    }
}

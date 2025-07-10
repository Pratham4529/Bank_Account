package com.aurionpro.model;

public final class SavingsAccount extends BankAccount implements Comparable<SavingsAccount> {

    private final double MIN_BALANCE = 10000;

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public final double credit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        balance += amount;
        System.out.println(amount + " credited. New Balance: " + balance);
        return amount;
    }

    @Override
    public double debit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(amount + " debited. New Balance: " + balance);
        } else {
            throw new MinBalanceVoilationException(amount);
        }
        return amount;
    }

    @Override
    public int compareTo(SavingsAccount other) {
        return Integer.compare(this.getAccountNumber(), other.getAccountNumber());
    }
}

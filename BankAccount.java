package com.aurionpro.model;

public abstract class BankAccount {

    private int accNo;
    private String name;
    protected double balance;

    public BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public abstract double debit(double amount);
    public abstract double credit(double amount);

    public int getAccountNumber() {
        return accNo;
    }

    public void setAccountNumber(int accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [accNo=" + accNo + ", name=" + name + ", balance=" + balance + "]";
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Name         : " + name);
        System.out.println("Balance      : " + balance);
    }
}

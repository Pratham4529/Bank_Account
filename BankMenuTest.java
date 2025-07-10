package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.MinBalanceVoilationException;
import com.aurionpro.model.NegativeAmountException;
import com.aurionpro.model.OverdraftLimitExceededException;
import com.aurionpro.model.SavingsAccount;

public class BankMenuTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        List<CurrentAccount> currentAccounts = new ArrayList<>();

        savingsAccounts.add(new SavingsAccount(101, "Tejaswini", 40000));
        savingsAccounts.add(new SavingsAccount(100, "Pratham", 20000));
        currentAccounts.add(new CurrentAccount(201, "Tejaswini", 10000));
        currentAccounts.add(new CurrentAccount(200, "Pratham", 25000));

        int choice;
        do {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Display Current Account Details");
            System.out.println("2. Display Savings Account Details");
            System.out.println("3. Credit to Current Account");
            System.out.println("4. Debit from Current Account");
            System.out.println("5. Credit to Savings Account");
            System.out.println("6. Debit from Savings Account");
            System.out.println("7. Sort and Display Savings Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        for (CurrentAccount acc : currentAccounts)
                            System.out.println(acc);
                        break;

                    case 2:
                        for (SavingsAccount acc : savingsAccounts)
                            System.out.println(acc);
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        int cCreditAcc = scanner.nextInt();
                        System.out.print("Enter amount to credit: ");
                        double cCreditAmount = scanner.nextDouble();
                        for (CurrentAccount acc : currentAccounts) {
                            if (acc.getAccountNumber() == cCreditAcc) {
                                acc.credit(cCreditAmount);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int cDebitAcc = scanner.nextInt();
                        System.out.print("Enter amount to debit: ");
                        double cDebitAmount = scanner.nextDouble();
                        for (CurrentAccount acc : currentAccounts) {
                            if (acc.getAccountNumber() == cDebitAcc) {
                                acc.debit(cDebitAmount);
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Enter account number: ");
                        int sCreditAcc = scanner.nextInt();
                        System.out.print("Enter amount to credit: ");
                        double sCreditAmount = scanner.nextDouble();
                        for (SavingsAccount acc : savingsAccounts) {
                            if (acc.getAccountNumber() == sCreditAcc) {
                                acc.credit(sCreditAmount);
                            }
                        }
                        break;

                    case 6:
                        System.out.print("Enter account number: ");
                        int sDebitAcc = scanner.nextInt();
                        System.out.print("Enter amount to debit: ");
                        double sDebitAmount = scanner.nextDouble();
                        for (SavingsAccount acc : savingsAccounts) {
                            if (acc.getAccountNumber() == sDebitAcc) {
                                acc.debit(sDebitAmount);
                            }
                        }
                        break;

                    case 7:
                        Collections.sort(savingsAccounts); // Uses compareTo in SavingsAccount
                        System.out.println("Sorted Savings Accounts:");
                        for (SavingsAccount acc : savingsAccounts)
                            System.out.println(acc);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            catch (MinBalanceVoilationException | NegativeAmountException | OverdraftLimitExceededException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        } while (choice != 0);

        scanner.close();
    }
}

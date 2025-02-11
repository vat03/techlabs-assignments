package com.aurionpro.test;

import com.aurionpro.model.BankAccount;
import java.util.HashSet;
import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<BankAccount> accounts = new HashSet<>(); 

        while (true) {
            System.out.println("\n1. Add Account\n2. Display Accounts\n3. Find Max Balance Account\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    if (isAccountNumberExists(accounts, accNumber)) {
                        System.out.println("Error: Account number already exists!");
                        break;
                    }

                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();

                    accounts.add(new BankAccount(accNumber, name, balance));
                    System.out.println("Account added successfully.");
                    break;

                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("\nList of Accounts:");
                        for (BankAccount acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;

                case 3:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        BankAccount maxAccount = findMaxBalanceAccount(accounts);
                        System.out.println("\nAccount with Maximum Balance: " + maxAccount);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }

    private static boolean isAccountNumberExists(HashSet<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public static BankAccount findMaxBalanceAccount(HashSet<BankAccount> accounts) {
        BankAccount maxAccount = null;
        double maxBalance = Double.MIN_VALUE;

        for (BankAccount account : accounts) {
            if (account.getBalance() > maxBalance) {
                maxBalance = account.getBalance();
                maxAccount = account;
            }
        }
        return maxAccount;
    }
}

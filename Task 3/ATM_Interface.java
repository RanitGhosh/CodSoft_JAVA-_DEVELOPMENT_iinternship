// TASK 3
// ATM INTERFACE

// 1.Create a class to represent the ATM machine.
// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
// 4. Create a class to represent the user's bank account, which stores the account balance.
// 5. Connect the ATM class with the user's bank account class to access and modify the account balance.
// 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// 7. Display appropriate messages to the user based on their chosen options and the success or failure of their transactions.


import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Represents an ATM interface for user interaction
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n--- ATM MENU ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your balance is: Rs. %.2f\n", account.getBalance());
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdrawal();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: Rs. ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter withdrawal amount: Rs. ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

// Main class to run the program
public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000); // Starting with Rs. 1,00,000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

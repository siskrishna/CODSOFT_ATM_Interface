import java.util.Scanner;

// Define a class to represent a bank account
class BankAccount {
    private double balance; // Private variable to store the account balance

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current account balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        if (amount > 0) { // Check if the deposit amount is positive
            balance += amount; // Add the amount to the balance
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw funds from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Check if withdrawal amount is valid
            balance -= amount; // Subtract the amount from the balance
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true; // Return true to indicate a successful withdrawal
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false; // Return false to indicate an unsuccessful withdrawal
        }
    }
}

// Define a class to represent an ATM machine
class ATM {
    private BankAccount userAccount;

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Method to display ATM options to the user
    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to run the ATM and handle user interactions
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    // Method to check and display the account balance
    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Current balance: $" + balance);
    }

    // Method to handle deposit operation
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    // Method to handle withdrawal operation
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
}

// Main class to run the ATM simulation
public class AtmMachine {
    public static void main(String[] args) {
        // Create a user's bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000.0);
        // Create an ATM instance and pass the user's account to it
        ATM atm = new ATM(userAccount);
        // Run the ATM simulation
        atm.run();
    }
}

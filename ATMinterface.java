import java.util.Scanner;

// BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
            return false;
        }
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear the invalid input
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a valid number.");
                        scanner.next(); // clear invalid input
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a valid number.");
                        scanner.next(); // clear invalid input
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }
}

// Main class
public class ATMinterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
package Chapter_9_OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNo;
    private String name;
    private double balance;
    private String password;

    public Account(String accountNo, String name, double balance, String password) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    // Getters and setters for the attributes
    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class EX4 {
    // Declare variables
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static HashMap<String, HashMap<String, HashMap<String, String>>> transactions = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);

    // Main function
    public static void main(String[] args) {
        initializeAccounts();
        while (true) {
            String accountNo = prompt("Enter account number: ");
            String password = prompt("Enter password: ");
            if (isValidPassword(password) && login(accountNo, password)) {
                System.out.println("Welcome to ATM, " + accounts.get(accountNo).getName() + "!");
                showMenu(accountNo);
            } else {
                System.out.println("Login failed. Try again.");
            }
        }
    }

    // prompt() function
    private static String prompt(String message) {
        System.out.print(message);
        return scan.nextLine();
    }

    private static void initializeAccounts() {
        accounts.put("001", new Account("001", "Dom", 1000, "LihorXDom@bdom421"));
        accounts.put("002", new Account("002", "Lihor", 1500, "DomXlihor@ohor124"));
        accounts.put("003", new Account("003", "Chea", 2000, ""));
        accounts.put("004", new Account("004", "Thiya", 2500, "Slkemnek@124"));
        accounts.put("005", new Account("005", "Ramy", 3000, "Ramymossne@135"));

        // Initialize transactions HashMap for each account
        for (String accountNo : accounts.keySet()) {
            transactions.put(accountNo, new HashMap<>());
        }
    }

    private static boolean login(String accountNo, String password) {
        return accounts.containsKey(accountNo) && accounts.get(accountNo).getPassword().equals(password);
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    private static void showMenu(String accountNo) {
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("a. Balance");
            System.out.println("b. Withdraw");
            System.out.println("c. Deposit");
            System.out.println("d. Transfer");
            System.out.println("e. Change Password");
            System.out.println("f. View Transaction History");
            System.out.println("g. Exit");
            String choice = prompt("Enter your choice: ");
            switch (choice) {
                case "a":
                    checkBalance(accountNo);
                    break;
                case "b":
                    withdraw(accountNo);
                    break;
                case "c":
                    deposit(accountNo);
                    break;
                case "d":
                    transfer(accountNo);
                    break;
                case "e":
                    changePassword(accountNo);
                    break;
                case "f":
                    viewTransactionHistory(accountNo);
                    break;
                case "g":
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void checkBalance(String accountNo) {
        System.out.println("Balance: " + accounts.get(accountNo).getBalance() + " USD");
    }

    private static void withdraw(String accountNo) {
        while (true) {
            String amountStr = prompt("Enter amount to withdraw: ");
            double amount = Double.parseDouble(amountStr);
            double balance = accounts.get(accountNo).getBalance();
            if (amount > balance) {
                System.out.println("Insufficient balance. Try a different amount.");
            } else {
                balance -= amount;
                accounts.get(accountNo).setBalance(balance);
                logTransaction(accountNo, accountNo, amount, "Withdraw");
                System.out.println("Withdrawal successful. New balance: " + balance + " USD");
                break;
            }
        }
    }

    private static void deposit(String accountNo) {
        String amountStr = prompt("Enter amount to deposit: ");
        double amount = Double.parseDouble(amountStr);
        double balance = accounts.get(accountNo).getBalance();
        balance += amount;
        accounts.get(accountNo).setBalance(balance);
        logTransaction(accountNo, accountNo, amount, "Deposit");
        System.out.println("Deposit successful. New balance: " + balance + " USD");
    }

    private static void transfer(String accountNo) {
        String targetAccountNo = prompt("Enter target account number: ");
        if (!accounts.containsKey(targetAccountNo)) {
            System.out.println("Target account number not found.");
            return;
        }

        String password = prompt("Enter your password to confirm transfer: ");
        if (!accounts.get(accountNo).getPassword().equals(password)) {
            System.out.println("Incorrect password. Transfer failed.");
            return;
        }

        String amountStr = prompt("Enter amount to transfer: ");
        double amount = Double.parseDouble(amountStr);
        double balance = accounts.get(accountNo).getBalance();
        if (amount > balance) {
            System.out.println("Insufficient balance. Transfer failed.");
            return;
        }

        balance -= amount;
        accounts.get(accountNo).setBalance(balance);

        double targetBalance = accounts.get(targetAccountNo).getBalance();
        targetBalance += amount;
        accounts.get(targetAccountNo).setBalance(targetBalance);

        logTransaction(accountNo, targetAccountNo, amount, "Transfer");
        System.out.println("Transfer successful. Your new balance: " + balance + " USD");
    }

    private static void changePassword(String accountNo) {
        String currentPassword = prompt("Enter current password: ");
        if (!accounts.get(accountNo).getPassword().equals(currentPassword)) {
            System.out.println("Incorrect current password.");
            return;
        }

        String newPassword = prompt("Enter new password: ");
        if (isValidPassword(newPassword)) {
            accounts.get(accountNo).setPassword(newPassword);
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password does not meet security criteria.");
        }
    }

    private static void viewTransactionHistory(String accountNo) {
        HashMap<String, HashMap<String, String>> accountTransactions = transactions.get(accountNo);
        if (accountTransactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String transactionId : accountTransactions.keySet()) {
                HashMap<String, String> transactionDetails = accountTransactions.get(transactionId);
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("From account: " + transactionDetails.get("fromAccount"));
                System.out.println("To account: " + transactionDetails.get("toAccount"));
                System.out.println("Amount: " + transactionDetails.get("amount") + " USD");
                System.out.println("Transaction Date: " + transactionDetails.get("date"));
                System.out.println("Transaction Time: " + transactionDetails.get("time"));
                System.out.println("Transaction Type: " + transactionDetails.get("type"));
                System.out.println("------------");
            }
        }
    }

    private static void logTransaction(String fromAccount, String toAccount, double amount, String type) {
        String transactionId = generateTransactionId();
        String date = new SimpleDateFormat("MMM dd, yyyy").format(new Date());
        String time = new SimpleDateFormat("hh:mm:ss a").format(new Date());

        HashMap<String, String> transactionDetails = new HashMap<>();
        transactionDetails.put("fromAccount", fromAccount);
        transactionDetails.put("toAccount", toAccount);
        transactionDetails.put("amount", String.valueOf(amount));
        transactionDetails.put("date", date);
        transactionDetails.put("time", time);
        transactionDetails.put("type", type);

        transactions.get(fromAccount).put(transactionId, transactionDetails);
        if (!fromAccount.equals(toAccount)) {
            transactions.get(toAccount).put(transactionId, transactionDetails);
        }
    }

    private static String generateTransactionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}


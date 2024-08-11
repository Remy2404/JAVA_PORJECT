package Chapter11_Reading.src;
import Chapter11_Reading.myDB.DatabaseManager;
import java.util.*;

public class EX9 {
    public int accountNo;
    public String name;
    public int password;
    public double balance;

    public EX9(int accountNo, String name, int password, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance + " USD");
    }

    public void withdraw(double amount, DatabaseManager dbManager) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw Successful. Remaining Balance: " + balance + " USD");
            dbManager.updateBalance(accountNo, balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void deposit(double amount, DatabaseManager dbManager) {
        balance += amount;
        System.out.println("Deposit Successful. New Balance: " + balance + " USD");
        dbManager.updateBalance(accountNo, balance);
    }

    public void transfer(EX9 toAccount, double amount, DatabaseManager dbManager) {
        if (balance >= amount) {
            withdraw(amount, dbManager);
            toAccount.deposit(amount, dbManager);
            System.out.println("Transfer Successful. Remaining Balance: " + balance + " USD");
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    int getMaxAccountNumber(DatabaseManager dbManager) {
        // Implement logic to get the maximum account number from the database
        // and return it
        return 100; // Placeholder for demonstration purposes
    }

    public EX9 getAccount(int accountNo, int password, DatabaseManager dbManager) {
        // Implement logic to retrieve the account with the given account number and password
        // from the database and return it
        // Placeholder for demonstration purposes
        return new EX9(12345, "John Doe", 1234, 1000.0);
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        // dbManager.createTable(); // Commented out as the method is undefined

        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Banking System!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter your account number: ");
                    int accountNo = input.nextInt();
                    System.out.print("Enter your password: ");
                    int password = input.nextInt();
                    EX9 foundAccount = dbManager.getAccount(accountNo, password);

                    if (foundAccount != null) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("Welcome, " + foundAccount.name + "!");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Deposit");
                            System.out.println("4. Transfer");
                            System.out.println("5. Logout");
                            System.out.println("Enter your choice: ");
                            int choice2 = input.nextInt();
                            switch (choice2) {
                                case 1:
                                    foundAccount.displayBalance();
                                    break;
                                case 2:
                                    System.out.print("Enter the amount to withdraw: ");
                                    double withdrawAmount = input.nextDouble();
                                    foundAccount.withdraw(withdrawAmount, dbManager);
                                    break;
                                case 3:
                                    System.out.print("Enter the amount to deposit: ");
                                    double depositAmount = input.nextDouble();
                                    foundAccount.deposit(depositAmount, dbManager);
                                    break;
                                case 4:
                                    System.out.print("Enter the account number to transfer to: ");
                                    int transferToAccountNo = input.nextInt();
                                    System.out.print("Enter the password of the account to transfer to: ");
                                    int transferToPassword = input.nextInt();
                                    EX9 transferToAccount = dbManager.getAccount(transferToAccountNo, transferToPassword);
                                    if (transferToAccount != null) {
                                        System.out.print("Enter the amount to transfer: ");
                                        double transferAmount = input.nextDouble();
                                        foundAccount.transfer(transferToAccount, transferAmount, dbManager);
                                    } else {
                                        System.out.println("Account not found.");
                                    }
                                    break;
                                case 5:
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Please check your account number and password.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = input.next();
                    System.out.print("Enter your password: ");
                    int newPassword = input.nextInt();
                    System.out.print("Enter your initial balance: ");
                    double initialBalance = input.nextDouble();

                    int newAccountNo = dbManager.getMaxAccountNumber() + 1;
                    EX9 newAccount = new EX9(newAccountNo, name, newPassword, initialBalance);
                    dbManager.addAccount(newAccount.accountNo, newAccount.name, newAccount.password, newAccount.balance);
                    System.out.println("Account created successfully!");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }
}

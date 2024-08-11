package Chapter11_Reading.src;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;

public class EX9_file_txt {
    //data fields:
    int accountNo;
    String name;
    int password;
    double balance;

    // constructor:
    public EX9_file_txt(int accountNo, String name, int password, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.password = password;
        this.balance = balance; // initialize balance
    }

    // method:
    boolean login(int accountNo, int password) {
        if (this.accountNo == accountNo && this.password == password) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }

    void displayBalance() {
        System.out.println("Balance: " + balance + " USD");
    }

    // withdraw(double amount)
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount; // update balance
            System.out.println("Withdraw Successful. Remaining Balance: " + balance + " USD");
            try {
                FileWriter writer = new FileWriter("../Account.txt", true);
                writer.write("Withdrawn: " + amount + " USD\n");
                writer.write("Remaining Balance: " + balance + " USD\n");
                writer.close();
            } catch (Exception e) {
                System.out.println("An error occurred while updating the account file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // deposit(double amount)
    void deposit(double amount) {
        balance += amount; // update balance
        System.out.println("Deposit Successful. New Balance: " + balance + " USD");
        try {
            FileWriter writer = new FileWriter("../Account.txt", true);
            writer.write("Deposited: " + amount + " USD\n");
            writer.write("New Balance: " + balance + " USD\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred while updating the account file.");
            e.printStackTrace();
        }
    }

    void transfer(EX9_file_txt toAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer Successful. Remaining Balance: " + balance + " USD");
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    // main method:
    public static void main(String[] args) {
        // menu: For the test program, store the data of five users in a file called Account.txt. When the program starts,
        Scanner input = new Scanner(System.in);
        ArrayList<EX9_file_txt> accounts = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("../Account.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                if (parts.length == 4) {  // Only process lines with 4 parts
                    try {
                        int accountNo = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        int password = Integer.parseInt(parts[2]);
                        double balance = Double.parseDouble(parts[3]);
                        accounts.add(new EX9_file_txt(accountNo, name, password, balance));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while reading the account file.");
            e.printStackTrace();
        }
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
                                    EX9_file_txt foundAccount = null;
                                    for (EX9_file_txt account : accounts) {
                                        if (account.accountNo == accountNo && account.password == password) {
                                            foundAccount = account;
                                            break;
                                        }
                                    }                    
                                    
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
                                    foundAccount.withdraw(withdrawAmount);
                                    break;
                                case 3:
                                    System.out.print("Enter the amount to deposit: ");
                                    double depositAmount = input.nextDouble();
                                    foundAccount.deposit(depositAmount);
                                    break;
                                case 4:
                                    System.out.print("Enter the account number to transfer to: ");
                                    int transferToAccountNo = input.nextInt();
                                    EX9_file_txt transferToAccount = null;
                                    for (EX9_file_txt account : accounts) {
                                        if (account.accountNo == transferToAccountNo) {
                                            transferToAccount = account;
                                            break;
                                        }
                                    }
                                    if (transferToAccount != null) {
                                        System.out.print("Enter the amount to transfer: ");
                                        double transferAmount = input.nextDouble();
                                        foundAccount.transfer(transferToAccount, transferAmount);
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
                    EX9_file_txt newAccount = new EX9_file_txt(accounts.size() + 1, name, newPassword, initialBalance);
                    accounts.add(newAccount);
                    try {
                        FileWriter writer = new FileWriter("../Account.txt", true);
                        writer.write(newAccount.accountNo + ": " + newAccount.name + ": " + newAccount.password + ": " + newAccount.balance + "\n");
                        writer.close();
                    } catch (Exception e) {
                        System.out.println("An error occurred while writing to the account file.");
                        e.printStackTrace();
                    }
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

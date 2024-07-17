package Chapter_9_OOP;
 class CreditCard {
    // Attributes of a credit card
     String cardNumber;
     String cardHolderName;
     String expirationDate;
     double balance;
     double creditLimit;
     int ccv;


    // Constructor to initialize the credit card
    public CreditCard(String cardNumber, String cardHolderName, String expirationDate, double creditLimit , int ccv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.balance = 0.0; // Initial balance is 0
        this.creditLimit = creditLimit;
        this.ccv = ccv;
    }

    // Method to make a purchase
    public boolean makePurchase(double amount) {
        if (amount > 0 && balance + amount <= creditLimit) {
            // Check if the amount is greater than 0 and if the balance plus the amount is less than or equal to the credit limit
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to make a payment
    public void makePayment(double amount) {
        if (amount > 0) {
            balance -= amount;
            if (balance < 0) {
                balance = 0;
            }
        }
    }

    // Method to get the current balance
    public double getBalance() {
    
        return balance;
    }

    // Method to get the credit limit
    public double getCreditLimit() {
        return creditLimit;
    }

    // Method to get the card details
    public String getCardDetails() {
        return "Card Number: " + cardNumber + "\nCard Holder: " + cardHolderName + "\nExpiration Date: " + expirationDate + "\nBalance: " + balance + "\nCredit Limit: " + creditLimit;
    }
}

public class EX6 {
    public static void main(String[] args) {
        // Create a credit card object
        CreditCard myCard = new CreditCard("1234-5678-9876-5432", "John Doe", "12/25", 5000.0, 123);

        // Display card details
        System.out.println(myCard.getCardDetails());

        // Make a purchase
        if (myCard.makePurchase(1500.0)) {
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Purchase failed! Not enough credit.");
        }

        // Display balance after purchase
        System.out.println("Balance after purchase: " + myCard.getBalance());

        // Make a payment
        myCard.makePayment(500.0);
        System.out.println("Balance after payment: " + myCard.getBalance());

        // Attempt to make a purchase exceeding the credit limit
        if (myCard.makePurchase(4000.0)) {
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Purchase failed! Not enough credit.");
        }

        // Display final card details
        System.out.println(myCard.getCardDetails());
    }
}

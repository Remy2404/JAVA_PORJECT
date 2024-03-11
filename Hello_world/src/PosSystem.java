
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Transaction {
    int productId;
    int quantity;
    long timestamp;

    public Transaction(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis() / 1000L;
    }
}

public class PosSystem {
    private List<Product> products;
    private List<Transaction> transactions;
    private final String dataFilePath = "pos_data.txt";

    public PosSystem() {
        readDataFromFile();
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println("POS system Started On: " + dateFormat.format(currentTime));
    }

    public void addProduct(int id, String name, double price) {
        Product product = new Product(id, name, price);
        products.add(product);
        writeDataToFile();
        System.out.println("Product added successfully.");
    }

    public void displayProducts() {
        System.out.println("Product List:");
        System.out.println("+-----+----------------------+----------+");
        System.out.println("| ID  | Name                 | Price    |");
        System.out.println("+-----+----------------------+----------+");
        for (Product product : products) {
            System.out.printf("| %-3d | %-20s | %-8.2f |\n", product.id, product.name, product.price);
        }
        System.out.println("+-----+----------------------+----------+");
    }

    public void processTransaction(int productId, int quantity) {
        Transaction transaction = new Transaction(productId, quantity);
        transactions.add(transaction);
        writeDataToFile();
        System.out.println("Transaction processed successfully.");
    }

    public void generateReceipt() {
        double totalAmount = 0.0;
        double totalWithDiscount;

        System.out.println("\nReceipt:");
        System.out.println("+----------------------+----------+-------------------------+");
        System.out.println("| Product              | Quantity | Price      | Total      |");
        System.out.println("+----------------------+----------+-------------------------+");

        for (Transaction transaction : transactions) {
            Product product = getProductById(transaction.productId);
            double subtotal = transaction.quantity * product.price;
            totalAmount += subtotal;

            System.out.printf("| %-20s | %-8d | %-10.2f | %-12.2f |\n", product.name, transaction.quantity, product.price, subtotal);
        }

        totalWithDiscount = calculateTotalWithDiscount(totalAmount);

        System.out.println("+----------------------+----------+-------------------------+");
        System.out.printf("\nTotal Amount: $%.2f\n", totalAmount);
        System.out.printf("Total Amount with Discount: $%.2f\n", totalWithDiscount);
    }

    public void deleteProduct(int productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.id == productId) {
                iterator.remove();
                writeDataToFile();
                System.out.println("Product deleted successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void updateProduct(int productId, String newName, double newPrice) {
        for (Product product : products) {
            if (product.id == productId) {
                product.name = newName;
                product.price = newPrice;
                writeDataToFile();
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private Product getProductById(int productId) {
        for (Product product : products) {
            if (product.id == productId) {
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public void readDataFromFile() {
        try (Scanner scanner = new Scanner(new File(dataFilePath))) {
            products = new ArrayList<>();
            transactions = new ArrayList<>();

            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                double price = scanner.nextDouble();
                Product product = new Product(id, name, price);
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty system.");
            products = new ArrayList<>();  // Initialize products list
            transactions = new ArrayList<>();  // Initialize transactions list
        }
    }


    public void writeDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))) {
            for (Product product : products) {
                writer.printf("%d %s %.2f\n", product.id, product.name, product.price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nOptions:");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Process Transaction");
            System.out.println("4. Generate Receipt");
            System.out.println("5. Delete Product");
            System.out.println("6. Update Product");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    addProductFromInput();
                    break;
                case '2':
                    displayProducts();
                    break;
                case '3':
                    processTransactionFromInput();
                    break;
                case '4':
                    generateReceipt();
                    break;
                case '5':
                    deleteProductFromInput();
                    break;
                case '6':
                    updateProductFromInput();
                    break;
                case '7':
                    System.out.println("Exiting the POS system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != '7');
        scanner.close();
    }

    private void addProductFromInput() {
      try ( Scanner scanner = new Scanner(System.in)) {
        int id;
        String name;
        double price;

        System.out.print("Enter product ID: ");
        id = scanner.nextInt();

        System.out.print("Enter product name: ");
        scanner.nextLine(); // Consume newline left from previous input
        name = scanner.nextLine();

        System.out.print("Enter product price: ");
        price = scanner.nextDouble();

        addProduct(id, name, price);
    }
}

    private void processTransactionFromInput() {
      try (Scanner scanner = new Scanner(System.in)){
        int productId;
        int quantity;

        System.out.print("Enter product ID for the transaction: ");
        productId = scanner.nextInt();

        System.out.print("Enter quantity for the transaction: ");
        quantity = scanner.nextInt();

        processTransaction(productId, quantity);
    }
    }
    private void deleteProductFromInput() {
       try (Scanner scanner = new Scanner(System.in)){
        int productId;

        System.out.print("Enter product ID to delete: ");
        productId = scanner.nextInt();

        deleteProduct(productId);
    }
}
    private void updateProductFromInput() {
       try (Scanner scanner = new Scanner(System.in)){
        int productId;
        String newName;
        double newPrice;

        System.out.print("Enter product ID to update: ");
        productId = scanner.nextInt();

        System.out.print("Enter new name for the product: ");
        scanner.nextLine(); // Consume newline left from previous input
        newName = scanner.nextLine();

        System.out.print("Enter new price for the product: ");
        newPrice = scanner.nextDouble();

        updateProduct(productId, newName, newPrice);
    }
}
    private double calculateTotalWithDiscount(double totalAmount) {
        if (totalAmount >= 100.0) {
            return totalAmount - (totalAmount * 0.25);
        } else if (totalAmount >= 50.0) {
            return totalAmount - (totalAmount * 0.15);
        } else {
            return totalAmount;
        }
    }

    public static void main(String[] args) {
        PosSystem posSystem = new PosSystem();
        posSystem.run();
    }
}

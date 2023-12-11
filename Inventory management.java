import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getName(), product);
    }

    public Product getProduct(String productName) {
        return inventory.get(productName);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class ComplexInventorySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();

        // Adding initial products to the inventory
        inventoryManager.addProduct(new Product("Laptop", 999.99, 10));
        inventoryManager.addProduct(new Product("Smartphone", 499.99, 20));
        inventoryManager.addProduct(new Product("Headphones", 79.99, 30));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Display Inventory\n2. Get Product Information\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventoryManager.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    scanner.nextLine(); // Consume newline left from previous nextInt()
                    String productName = scanner.nextLine();
                    Product requestedProduct = inventoryManager.getProduct(productName);
                    if (requestedProduct != null) {
                        System.out.println(requestedProduct);
                    } else {
                        System.out.println("Product not found in the inventory.");
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}

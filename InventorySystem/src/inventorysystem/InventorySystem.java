/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author shaun
 */
import java.util.Scanner;
public class InventorySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner scanner = new Scanner(System.in);
        InventoryManager inventory = new InventoryManager(5);
        
        // Allow user to add new items
        while (true) {
            System.out.println("\nAdd a new item? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) break;

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Stock Level: ");
            int stockLevel = Integer.parseInt(scanner.nextLine());
            System.out.print("Is it perishable? (yes/no): ");
            String isPerishable = scanner.nextLine().trim().toLowerCase();

            if (isPerishable.equals("yes")) {
                System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                String expiryDate = scanner.nextLine();
                inventory.addProduct(new PerishableProduct(id, name, stockLevel, expiryDate));
            } else {
                inventory.addProduct(new Product(id, name, stockLevel));
            }
            
            System.out.println("Item added successfully!");
        }

        // Initial items for demonstration
        inventory.addProduct(new Product(1, "Laptop", 10));
        inventory.addProduct(new PerishableProduct(2, "Milk", 5, "2025-10-01"));
        inventory.restockProduct(1, 5);
        
        // Generate report and calculate total value
        double totalValue = calculateTotalValue(inventory);
        inventory.generateReport();
        System.out.println("Total Inventory Value: $" + totalValue);

        scanner.close();
    }

    /**
     * Calculates the total value of all products (assuming a fixed price for simplicity).
     * @param inventory The inventory manager
     * @return The total value
     */
    private static double calculateTotalValue(InventoryManager inventory) {
        double total = 0;
        for (int i = 0; i < inventory.getProductCount(); i++) {
            Product p = inventory.products[i];
            total += p.getStockLevel() * (p.getId() == 1 ? 1000 : 2); // $1000 for Laptop, $2 for Milk
        }
        return total;
    }
    
}

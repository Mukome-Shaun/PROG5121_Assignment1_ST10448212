/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author shaun
 */
import java.util.Arrays;
public class InventoryManager {
    
    Product[] products; // Array to store products
    private int productCount;   // Current number of products

    /**
     * Constructs an InventoryManager with a specified capacity.
     * @param capacity The maximum number of products
     */
    public InventoryManager(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }

    public int getProductCount() { return productCount; } // Added for testing

    /**
     * Adds a product to the inventory if space is available.
     * @param product The product to add
     */
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        }
    }

    /**
     * Restocks a product by ID with the specified quantity.
     * @param id The product ID
     * @param quantity The quantity to add
     */
    public void restockProduct(int id, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId() == id) {
                products[i].setStockLevel(products[i].getStockLevel() + quantity);
                return;
            }
        }
    }

    /**
     * Generates a detailed inventory report to the console and notifies about low stock.
     */
    public void generateReport() {
        System.out.println("Inventory Report - " + java.time.LocalDate.now());
        System.out.println("---------------");
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() +
                             ", Stock: " + p.getStockLevel());
            if (p instanceof PerishableProduct) {
                System.out.println("Expiry Date: " + ((PerishableProduct) p).getExpiryDate());
            }
            if (p.getStockLevel() < 10) {
                System.out.println("WARNING: This product (ID: " + p.getId() + ", Name: " + p.getName() + ") needs to buy new inventory!");
            }
        }
    }
}

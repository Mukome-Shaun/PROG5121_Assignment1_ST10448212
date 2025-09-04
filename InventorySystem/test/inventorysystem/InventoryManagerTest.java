/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package inventorysystem;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shaun
 */
public class InventoryManagerTest {
    
    public InventoryManagerTest() {
    }

    @Test
    public void testGetProductCount() {
        InventoryManager inventory = new InventoryManager(2);
        assertEquals(0, inventory.getProductCount(), "Initial product count should be 0");
        inventory.addProduct(new Product(1, "Test", 10));
        assertEquals(1, inventory.getProductCount(), "Product count should be 1 after adding");
    }

    @Test
    public void testAddProduct() {
        InventoryManager inventory = new InventoryManager(2);
        Product product = new Product(1, "Test", 10);
        inventory.addProduct(product);
        assertEquals(1, inventory.getProductCount(), "Product count should be 1");
        assertEquals(product, inventory.products[0], "Added product should match");
        assertEquals(10, product.getStockLevel(), "Stock level should be 10");
        
    }

    @Test
    public void testRestockProduct() {
        InventoryManager inventory = new InventoryManager(2);
        Product product = new Product(1, "Test", 10);
        inventory.addProduct(product);
        inventory.restockProduct(1, 5);
        assertEquals(15, product.getStockLevel(), "Stock level should be 15 after restock");
    }
    @Test
    public void testRestockProduct_ProductNotFound() {
        InventoryManager inventory = new InventoryManager(2);
        Product product = new Product(1, "Test", 10);
        inventory.addProduct(product);
        inventory.restockProduct(2, 5); // Non-existent ID
        assertEquals(10, product.getStockLevel(), "Stock level should remain 10 for non-existent ID");
    }

    @Test
    public void testGenerateReport_Execution() {
        InventoryManager inventory = new InventoryManager(2);
        inventory.addProduct(new Product(1, "Laptop", 15));
        inventory.addProduct(new PerishableProduct(2, "Milk", 5, "2025-10-01"));
        // Since we can't capture output, test that the method runs without exception
        assertDoesNotThrow(() -> inventory.generateReport(), "generateReport should execute without errors");
        // Test internal state remains unchanged
        assertEquals(15, inventory.products[0].getStockLevel(), "Laptop stock should remain 15");
        assertEquals(5, inventory.products[1].getStockLevel(), "Milk stock should remain 5");
    }

    @Test
    public void testPerishableProduct() {
        PerishableProduct product = new PerishableProduct(2, "Milk", 50, "2025-10-01");
        assertEquals("2025-10-01", product.getExpiryDate(), "Expiry date should be 2025-10-01");
        assertEquals(50, product.getStockLevel(), "Stock level should be 50");
        assertEquals(2, product.getId(), "ID should be 2");
        assertEquals("Milk", product.getName(), "Name should be Milk");
    }

    @Test
    public void testPerishableProduct_Inheritance() {
        PerishableProduct product = new PerishableProduct(2, "Milk", 50, "2025-10-01");
        assertTrue(product instanceof Product, "PerishableProduct should be instance of Product");
        assertEquals(50, ((Product) product).getStockLevel(), "Stock level via Product should be 50");
    }

}

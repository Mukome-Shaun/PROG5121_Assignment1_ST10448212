/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author shaun
 */
public class Product {
    private int id;         // Unique identifier for the product
    private String name;    // Name of the product
    private int stockLevel; // Current stock level of the product
    
    public Product(int id, String name, int stockLevel) {
        this.id = id;
        this.name = name;
        this.stockLevel = stockLevel;
    }
      // Getters and Setters with comments
    public int getId() { return id; }
    public String getName() { return name; }
    public int getStockLevel() { return stockLevel; }
    public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
    
}

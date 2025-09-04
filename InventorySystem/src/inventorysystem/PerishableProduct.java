/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author shaun
 */
public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(int id, String name, int stockLevel, String expiryDate) {
        super(id, name, stockLevel);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
}
package com.example.market_place.Inventories;

import com.example.market_place.Products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "inventory_table")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int inStockQuantity;

    // Default constructor
    public Inventory() {}

    // Parameterized constructor
    public Inventory(Product product, int inStockQuantity) {
        this.product = product;
        this.inStockQuantity = inStockQuantity;
    }

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and setter for inStockQuantity
    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", product=" + product +
                ", inStockQuantity=" + inStockQuantity +
                '}';
    }
}

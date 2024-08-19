package com.example.market_place.Products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "product_table")
public class Product {
    @Id
    @GeneratedValue
    @JsonProperty("product_id")
    private int id;

    @Size(min = 3,message = "product name should have at least 3 letters")
    @JsonProperty("product_name")
    private String name;

    @Size(min = 5,message = "you should write a description with at least one word")
    private String shortDescription;

    @Size(min = 5,message = "you should give a full description of the product")
    private String longDescription;

    private double price;

    public Product(){}
    public Product(int id, String name, String shortDescription, String longDescription, double price) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", price=" + price +
                '}';
    }
}


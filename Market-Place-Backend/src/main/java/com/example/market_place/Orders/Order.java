package com.example.market_place.Orders;

import com.example.market_place.Addresses.Address;
import com.example.market_place.Products.Product;
import com.example.market_place.Users.User;
import jakarta.persistence.*;


@Entity(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int quantity;

    public Order(){}
    public Order(int id, User user, Address address, Product product, int quantity) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", address=" + address +
                ", product=" + product +
                ", quantities=" + quantity +
                '}';
    }
}

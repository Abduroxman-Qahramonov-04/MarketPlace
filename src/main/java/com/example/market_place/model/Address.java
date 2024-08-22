package com.example.market_place.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @NotBlank(message = "Address Line 1 is mandatory")
    @Size(max = 100, message = "Address Line 1 can have a maximum of 100 characters")
    private String addressLine1;

    @Size(max = 100, message = "Address Line 2 can have a maximum of 100 characters")
    private String addressLine2;

    @NotBlank(message = "City is mandatory")
    @Size(max = 50, message = "City can have a maximum of 50 characters")
    private String city;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 50, message = "Country can have a maximum of 50 characters")
    private String country;

    @NotBlank(message = "PostCode is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9]{5,10}$", message = "PostCode must be alphanumeric and 5-10 characters long")
    private String postCode;

    private boolean active;

    public Address(Long id, User user, String addressLine1, String addressLine2, String city, String country, String postCode, boolean active) {
        this.id = id;
        this.user = user;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.active = active;
    }

    public Address() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user=" + user +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                ", active=" + active +
                '}';
    }
}
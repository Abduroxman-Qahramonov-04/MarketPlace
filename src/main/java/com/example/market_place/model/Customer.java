package com.example.market_place.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotNull(message = "First Name cannot be NULL")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in first name")
    private String firstName;

    @NotNull(message = "Last Name cannot be NULL")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in last name")
    private String lastName;

    @Column(unique = true)
    @NotNull(message = "Please enter the mobile Number")
    private String mobileNumber;

    @Column(unique = true)
    @NotNull(message = "Please enter the emaild id")
    @Email
    private String emailId;

    @NotNull(message = "Please enter the password")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    private String password;

    private LocalDateTime createdOn;

    @Embedded
    private CreditCard creditCard;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_address_mapping",
            joinColumns = {
                @JoinColumn(name="customer_id",referencedColumnName = "customerId")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "address_id",referencedColumnName = "addressId")
            })
    private Map<String,Address> address = new HashMap<>();

}

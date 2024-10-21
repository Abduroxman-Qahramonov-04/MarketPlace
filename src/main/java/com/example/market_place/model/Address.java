package com.example.market_place.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;

    private String city;
    private String region;
    private String neighborhood;
    private String streetNo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Customer customer;

}

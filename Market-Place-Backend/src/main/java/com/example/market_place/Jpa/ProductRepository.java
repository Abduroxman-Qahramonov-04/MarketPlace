package com.example.market_place.Jpa;

import com.example.market_place.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}

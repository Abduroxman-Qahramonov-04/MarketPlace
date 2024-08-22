package com.example.market_place.jpa;

import com.example.market_place.model.Inventory;
import com.example.market_place.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Product> {
}

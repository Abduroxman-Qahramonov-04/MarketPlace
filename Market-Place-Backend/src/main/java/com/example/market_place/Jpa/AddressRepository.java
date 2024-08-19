package com.example.market_place.Jpa;

import com.example.market_place.Addresses.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}

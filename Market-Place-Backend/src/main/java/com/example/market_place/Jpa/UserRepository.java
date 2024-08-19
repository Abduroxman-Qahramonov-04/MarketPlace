package com.example.market_place.Jpa;

import com.example.market_place.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

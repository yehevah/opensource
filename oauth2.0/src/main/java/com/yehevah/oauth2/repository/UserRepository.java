package com.yehevah.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yehevah.oauth2.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);

}

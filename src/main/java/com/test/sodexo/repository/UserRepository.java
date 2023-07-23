package com.test.sodexo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sodexo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

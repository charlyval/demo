package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {	
	
}

package com.shrestha.chat.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrestha.chat.dal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

}

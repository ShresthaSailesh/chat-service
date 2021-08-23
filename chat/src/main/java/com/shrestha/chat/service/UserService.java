package com.shrestha.chat.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrestha.chat.dal.User;
import com.shrestha.chat.dal.repository.UserRepository;
import com.shrestha.chat.exception.AlreadyFoundException;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(final User user) throws AlreadyFoundException  {
		if(checkUser(user.getUserName())) {
			throw new AlreadyFoundException(user.getUserName() +" user already exists!");
		}
		userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	public boolean checkUser(String userName) throws AlreadyFoundException {
		List<User> users = getUsers();
		if(!users.isEmpty()) {
			for(User user: users) {
				if(user.getUserName().equals(userName)) {
					return true;
				}
			}
		}
		return false;
	}

}

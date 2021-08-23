package com.shrestha.chat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shrestha.chat.dal.User;
import com.shrestha.chat.dto.UserDTO;
import com.shrestha.chat.exception.AlreadyFoundException;
import com.shrestha.chat.service.UserService;

@RestController
@RequestMapping("/rest/v1/user")
@CrossOrigin
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/registration")
	public ResponseEntity<Void> register(@RequestBody UserDTO userDTO) throws AlreadyFoundException{
		if(userService.checkUser(userDTO.getUserName())){
			throw new AlreadyFoundException(userDTO.getUserName() + "  already exists!");
		}
		User user = new User();
		user.setUserName(userDTO.getUserName());
		userService.save(user);
		return ResponseEntity.ok().build();

	}

	@GetMapping("")
	public List<User> getAllUsers(){

		return userService.getUsers();
	}

}

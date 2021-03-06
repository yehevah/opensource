package com.yehevah.opensource.intelligentfactory.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yehevah.opensource.intelligentfactory.userservice.dao.UserRepository;
import com.yehevah.opensource.intelligentfactory.userservice.entities.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		User findOne=this.userRepository.findOne(id);
		return findOne;
	}

}

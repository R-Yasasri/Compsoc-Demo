package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/")
	public String saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	@GetMapping("/getusersbyname/{name}")
	public List<User> getUsersByName(@PathVariable String name){
		return userService.getUsersByName(name);
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public String saveUser(User user) {
		userRepository.save(user);
		System.out.println("saveUser- "+user);
		return "Success";
	}
	
	
	public String updateUser(User user) {
		
		User avlUser=userRepository.findById(user.getId()).orElse(null);
		
		if(avlUser!=null) {
			avlUser.setAge(user.getAge());
			avlUser.setName(user.getName());
			avlUser.setAddress(user.getAddress());
			
			userRepository.save(avlUser);
			
			System.out.println("updateUser- "+avlUser);
			
			return "Updated successfully!";
		}else {
			return "No such user";
		}
	}
	
	public String deleteUser(int id) {
		User avlUser=userRepository.findById(id).orElse(null);
		
		if(avlUser!=null) {
			userRepository.deleteById(id);
			
			System.out.println("deleteUser- "+avlUser);
			
			return "Successfully removed";
		}else {
			return "No such user";
		}
	}
	
	public List<User> getUsersByName(String name){
		return userRepository.getUsersByName(name);
	}
}

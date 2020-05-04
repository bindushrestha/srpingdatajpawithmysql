package com.example.springdatajpa.springdatajpapractice.accessingmysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "saved";
	}
	
	@GetMapping(path="/user")
	public @ResponseBody Optional<User> getUserById(@RequestParam Integer id) {
		return userRepository.findById(id);
		
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> findAll(){
		return userRepository.findAll();
		}
}

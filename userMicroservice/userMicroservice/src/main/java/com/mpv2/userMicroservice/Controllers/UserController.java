package com.mpv2.userMicroservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpv2.userMicroservice.Entity.User;
import com.mpv2.userMicroservice.Service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String UserId){
		 User user = userService.getUser(UserId);
		 return ResponseEntity.ok(user);
	}
	
	 //for getting the all users
	 @GetMapping
	 public ResponseEntity<List<User>> getAllUser() {
	 List<User> allUser = userService.getAllUser();
	 return ResponseEntity.ok(allUser);
	   
	 }


}

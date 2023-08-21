package com.mpv2.userMicroservice.ServiceImple;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mpv2.userMicroservice.Entity.User;
import com.mpv2.userMicroservice.Service.UserService;
import com.mpv2.userMicroservice.repositories.UserRepository;

@Service
public class ServiceImple implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public User saveUser(User user) {
		//for generate unique userid
		String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

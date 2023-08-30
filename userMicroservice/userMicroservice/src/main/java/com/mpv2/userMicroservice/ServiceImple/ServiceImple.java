package com.mpv2.userMicroservice.ServiceImple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mpv2.userMicroservice.Entity.Hotel;
import com.mpv2.userMicroservice.Entity.Ratings;
import com.mpv2.userMicroservice.Entity.User;
import com.mpv2.userMicroservice.Exception.ResourceNotFoundException;
import com.mpv2.userMicroservice.Service.UserService;
import com.mpv2.userMicroservice.repositories.UserRepository;

@Service
public class ServiceImple implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(ServiceImple.class);
	
	@Override
	public User saveUser(User user) {
//		String randomUserId = UUID.randomUUID().toString();
//        user.setUserId(randomUserId);
        return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();		
	}

	@Override
	public User getUser(String userId) {
	   //get data from database with the help of user repo
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user Not found with this id"+ userId));
	   //fetch rating of the above user from rating service
	   //http://localhost:8081/ratings/users/0314c0b7-78f9-4abc-84d4-06040acf166a
	   Ratings[] RatingOfUser = restTemplate.getForObject("http://rating-service/ratings/users/"+user.getUserId(), Ratings[].class);
	   logger.info("{}",RatingOfUser);
	   List<Ratings> ratings = Arrays.stream(RatingOfUser).toList();
	   
	   List<Ratings> ratingList = ratings.stream().map(Rating->{
		 //api calling hotel service to get the hotel
	   ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://hotel-service/hotels/"+Rating.getHotelId(),Hotel.class);
	   Hotel hotel = forEntity.getBody();
	   logger.info("response status code{}",forEntity.getStatusCode());
	   
	   //set the hotel rating
	   Rating.setHotel(hotel);
	   return Rating;
	  }).collect(Collectors.toList());
	   
	   //return rating
	   user.setRatings(ratingList);
	   return user;
	
	}

}

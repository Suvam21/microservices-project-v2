package com.mpv2.ratingMicroservice.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpv2.ratingMicroservice.Entity.Rating;
import com.mpv2.ratingMicroservice.Service.RatingService;
import com.mpv2.ratingMicroservice.repository.ratingRepository;

@Service
public class RatingServiceImple implements RatingService{
	
	@Autowired
	private ratingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
//	String randomratingId = UUID.randomUUID().toString();
//	rating.setUserId(randomratingId);
	 return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}
	
	
	
	

}

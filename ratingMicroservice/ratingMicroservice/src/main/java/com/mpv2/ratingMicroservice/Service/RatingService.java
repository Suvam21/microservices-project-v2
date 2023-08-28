package com.mpv2.ratingMicroservice.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.mpv2.ratingMicroservice.Entity.Rating;

public interface RatingService {
	
	Rating saveRating(@RequestBody Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

    
}

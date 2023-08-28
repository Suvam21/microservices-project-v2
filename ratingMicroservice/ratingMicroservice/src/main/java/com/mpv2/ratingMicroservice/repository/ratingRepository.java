package com.mpv2.ratingMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpv2.ratingMicroservice.Entity.Rating;

@Repository
public interface ratingRepository extends JpaRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}		



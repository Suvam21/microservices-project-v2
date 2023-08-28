package com.mpv2.userMicroservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
	
	 private String rating;
	 private String ratingId;
	 private String feedback;
	 private String userId;
	 private String hotelId;
	 
	 private Hotel hotel;


}

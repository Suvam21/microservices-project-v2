package com.mpv2.ratingMicroservice.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_ratings")
public class Rating {
	
	@Id
	private String ratingId;
	private String userId;	
	private String hotelId;
	private String rating;
	private String feedback;
	

} 

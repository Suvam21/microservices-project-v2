package com.mpv2.userMicroservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	
	private String hotelId;
	private String name;
	private String location;
	private String star;

}

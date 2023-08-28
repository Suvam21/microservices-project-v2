package com.mpv2.hotelMicroservice.Service;

import java.util.List;

import com.mpv2.hotelMicroservice.Entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel getuser(String hotelId);


}

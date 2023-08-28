package com.mpv2.hotelMicroservice.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpv2.hotelMicroservice.Entity.Hotel;
import com.mpv2.hotelMicroservice.Exceptions.ResourceNotFoundException;
import com.mpv2.hotelMicroservice.Service.HotelService;
import com.mpv2.hotelMicroservice.repository.HotelRepository;

@Service
public class HotelServiceImple implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	 
	
	@Override
	public Hotel create(Hotel hotel) {
//		String hotelId = UUID.randomUUID().toString();
//        hotel.setHotelId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

//	@Override
//	public Hotel get(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Hotel getuser(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("with with id is not found"));
	}
}

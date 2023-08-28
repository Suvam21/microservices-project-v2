package com.mpv2.hotelMicroservice.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpv2.hotelMicroservice.Entity.Hotel;
import com.mpv2.hotelMicroservice.Service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

	
	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
		
	}

//	@GetMapping("/{hotelId}")
//	public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId) {
//	return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	
	@GetMapping("/{hotelId}")
    public Hotel getUserById(@PathVariable("hotelId") String hotelId){
    LOGGER.info("User found at ID: " + hotelId);
    return hotelService.getuser(hotelId);
    }	

	@GetMapping
	public ResponseEntity<List<Hotel>> getAll() {
		return ResponseEntity.ok(hotelService.getAll());
	}

}

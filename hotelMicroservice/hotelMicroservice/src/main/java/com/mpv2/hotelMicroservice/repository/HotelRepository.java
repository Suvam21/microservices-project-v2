package com.mpv2.hotelMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpv2.hotelMicroservice.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}

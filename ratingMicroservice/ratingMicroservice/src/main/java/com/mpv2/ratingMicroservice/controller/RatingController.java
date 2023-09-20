package com.mpv2.ratingMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpv2.ratingMicroservice.entity.Rating;
import com.mpv2.ratingMicroservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    
    @Autowired
    RatingService ratingService;

    //create controller
    @PostMapping("/addrating")
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }

    //Get all ratings
    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    //Get rating by User id
    @GetMapping("/users/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable String userId){
        return ratingService.getRatingByUserId(userId);
    }

    @GetMapping("/hotels/{hotelId}")
    public List<Rating> getRatingByHotelId(@PathVariable String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }

    // Updating ratings
    @PutMapping("/updaterating/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating updatedRating) {
        Rating existingRating = ratingService.getRatingById(ratingId);

        if (existingRating == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the fields you want to change
        existingRating.setHotelId(updatedRating.getHotelId());
        existingRating.setRating(updatedRating.getRating());
        existingRating.setFeedback(updatedRating.getFeedback());

        Rating updated = ratingService.saveRating(existingRating);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    //delete rating
    @DeleteMapping("/deleterating/{ratingid}")
    public ResponseEntity<Rating> deleteRating(@PathVariable("ratingid") String ratingId){
        Rating existingRating = ratingService.getRatingById(ratingId);         
        if (existingRating == null) {             
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);         
        }         
        ratingService.deleteRating(ratingId);         
        System.out.println("rating deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

    


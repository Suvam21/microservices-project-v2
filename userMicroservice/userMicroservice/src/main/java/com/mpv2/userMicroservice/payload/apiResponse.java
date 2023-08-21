package com.mpv2.userMicroservice.payload;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class apiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	

}

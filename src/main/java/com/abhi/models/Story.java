package com.abhi.models;

import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
public class Story {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@ManyToOne
	private User user;
	
	private String captions;
	
	private String image;
	
	private LocalDateTime timestamp;
	
	
	
	
}

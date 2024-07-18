package com.abhi.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
@NoArgsConstructor
@Data
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	
	private String chat_name;
	
	private String chat_image;
	
	
	@ManyToMany
	private List<User> users = new ArrayList<>();
	
	private LocalDateTime timestamp;
 
	@OneToMany(mappedBy = "chat")
	private List<Message>  messages = new ArrayList<>();
}

package com.abhi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Reels;

@RestController
public class ReelsController {
	
	

		
		@GetMapping("/reels")
		public List<Reels> getReels(){
			
			List<Reels> reels = new ArrayList<>();
			
			
			Reels reel1= new Reels("1 reel");
			Reels reel2 = new Reels("2 reel");
			
			reels.add(reel1);
			reels.add(reel2);
			
			return reels;
		}
		
	}



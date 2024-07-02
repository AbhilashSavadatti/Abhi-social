package com.abhi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Stories;

@RestController
public class StoriesController {
	@GetMapping("/stories")
	public List<Stories> getStories(){
		
		List<Stories> Stories = new ArrayList<>();
		
		
		Stories reel1= new Stories("1 reel");
		Stories reel2 = new Stories("2 reel");
		
		Stories.add(reel1);
		Stories.add(reel2);
		
		return Stories;
	}
}

package com.abhi.service;

import java.util.List;

import com.abhi.models.Reels;
import com.abhi.models.User;

public interface ReelsService {
	
	
	public Reels createReel(Reels reel , User user );
	
	public List<Reels> findAllReels();
	
	
	public List<Reels> findUsersReel(Integer userId) throws Exception;
		
		
	
	

}

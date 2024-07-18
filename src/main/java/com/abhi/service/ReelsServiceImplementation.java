package com.abhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.models.Reels;
import com.abhi.models.User;
import com.abhi.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService {
	
	@Autowired
	ReelsRepository reelsRepository;
	
	@Autowired
	UserService userService;

	@Override
	public Reels createReel(Reels reel, User user) {
		// TODO Auto-generated method stub
		Reels createReel = new Reels();
		
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		
		createReel.setVideo(reel.getVideo());
		
		
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		// TODO Auto-generated method stub
		
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		
		userService.findUserById(userId);
		return reelsRepository.findByUserId(userId);
	}

}

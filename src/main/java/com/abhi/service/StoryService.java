package com.abhi.service;

import java.util.List;

import com.abhi.models.Story;
import com.abhi.models.User;

public interface StoryService {

	
	public Story createStory(Story story, User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;
	
}

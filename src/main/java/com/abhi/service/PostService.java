package com.abhi.service;

import java.util.List;

import com.abhi.models.Post;

public interface PostService {

	Post createNewPost(Post post, Integer userId) throws Exception;
	
	
	String deletePost(Integer postId, Integer UserId) throws Exception;
	
	List<Post> findPostByUserId(Integer userId);
	
	Post findPostById(Integer postId) throws Exception;
	
	List<Post> findAllPost();
	
	Post savedPost(Integer postId, Integer userId) throws Exception;
	
	Post likedPost(Integer postId,Integer userId) throws Exception;
	
	
	
}

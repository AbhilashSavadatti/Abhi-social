package com.abhi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Comment;
import com.abhi.models.User;
import com.abhi.service.CommentService;
import com.abhi.service.UserService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/comments/post/{postId}")
	public Comment createComment(@PathVariable Integer postId,
			@RequestBody Comment comment, 
			@RequestHeader("Authorization") String jwt) throws Exception {
		
		
		User user = userService.findUserByJwt(jwt);
		
		Comment createdComment = commentService.createComment(comment, postId, user.getId());
		
		return createdComment;
	}

	@PutMapping("/api/comments/like/{commentId}")
	public Comment likeComment(@PathVariable Integer commentId,
			@RequestHeader("Authorization") String jwt) throws Exception {
		
		
		User user = userService.findUserByJwt(jwt);
		
		Comment likedComment = commentService.likeComment(commentId,user.getId());
		
		return likedComment;
	}

	
}



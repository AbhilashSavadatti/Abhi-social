package com.abhi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.models.Comment;
import com.abhi.models.Post;
import com.abhi.models.User;
import com.abhi.repository.CommentRepository;
import com.abhi.repository.PostRepository;


@Service
public class CommentServiceImplementation implements CommentService{
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		
		User user = userService.findUserById(userId);
		
		
		Post post = postService.findPostById(postId);
		
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		
		Comment savedComment = commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Comment> opt = commentRepository.findById(commentId);
		
		
		if(opt.isEmpty()) {
			throw new Exception("Comment not exists!");
			
		}
		return opt.get();
	}

	@Override
	public Comment likeComment(Integer CommentId, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		
		Comment comment = findCommentById(CommentId);
		
		User user = userService.findUserById(userId);
		
		if(!comment.getLiked().contains(user))
			comment.getLiked().add(user);
		else
			comment.getLiked().remove(user);
		
		
		return commentRepository.save(comment);
	}

}

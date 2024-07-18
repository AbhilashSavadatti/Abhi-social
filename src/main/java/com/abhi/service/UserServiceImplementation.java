package com.abhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.config.JwtProvider;
import com.abhi.models.User;
import com.abhi.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository userRepository;
	
	
	
	
	
	@Override
	public User findUserById(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent())
		 return user.get();
			
		
		throw new Exception("user not exists with user Id : " + userId);
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws Exception {
		// TODO Auto-generated method stub
		
		
		User  reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
		
		user2.getFollowers().add( reqUser.getId());
		reqUser.getFollowings().add(user2.getId());
		
		userRepository.save(reqUser);
		userRepository.save(user2);
		
		
		return reqUser;
	}

	@Override
	public User updateUser(User user,Integer userId) throws Exception {
		Optional<User> user1 = userRepository.findById(userId);
		
		
		if(user1.isEmpty())
			throw new Exception("User not exists with user Id" + userId);
		
		
		User oldUser = user1.get();
			
		
		
		if(user.getFirstName()!=null) {		
			oldUser.setFirstName(user.getFirstName());
			
		}
		
		
		if(user.getLastName()!=null) {
			
			oldUser.setLastName(user.getLastName());
			
		}
		
	if(user.getEmail() !=null) {
			
			oldUser.setEmail(user.getEmail());
			
		}
	
	if(user.getGender()!=null)
		oldUser.setGender(user.getGender());
		
	User UpdatedUser = userRepository.save(oldUser);

		return UpdatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		
		
		return userRepository.searchUser(query);
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByJwt(String jwt) {
		
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		
		return user;
	}

}

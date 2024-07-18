package com.abhi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.config.JwtProvider;
import com.abhi.models.User;
import com.abhi.repository.UserRepository;
import com.abhi.request.LoginRequest;
import com.abhi.response.AuthResponse;
import com.abhi.service.CustomerUserDetailService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailService customerUserDetails;
	
	
	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user) throws Exception {
		
		User isExist = userRepository.findByEmail(user.getEmail());
		
		if(isExist!=null)
			throw new Exception("This email is already used with another account ");
		
		
		
		User newUser = new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		
		User savedUser = userRepository.save(newUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		
		
		String token = JwtProvider.generateToken(authentication);
		
		
		AuthResponse res = new AuthResponse(token, "Register success");
		
		return res;
		
	}
	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		
		
		String token = JwtProvider.generateToken(authentication);
		
		
		AuthResponse res = new AuthResponse(token, "Login success");
		
		return res;
		
	}
	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		
		UserDetails userDetails = customerUserDetails.loadUserByUsername(email);
		
		if(userDetails == null)
			throw new BadCredentialsException("Invalid UserName");
		
		if(!passwordEncoder.matches(password, userDetails.getPassword()))
		throw new BadCredentialsException("Password not matched!!!");
		
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
	
}

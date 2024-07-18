package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.models.Reels;

public interface ReelsRepository extends JpaRepository<Reels, Integer>{

	
	public List<Reels> findByUserId(Integer UserId);
	
	
}

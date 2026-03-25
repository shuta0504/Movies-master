package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Like;
import com.example.demo.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeService{
	
	private final LikeRepository likeRepository;
	
	@Transactional
	public Integer toggleLike(Integer userId,Integer postId) {
		Optional<Like> existingLike = likeRepository.findByUserIdAndPostId(userId, postId);
		
		if(existingLike.isPresent()) {
			likeRepository.delete(existingLike.get());
			return 0;}
			else {
				Like like = new Like();
				like.setUserId(userId);
				like.setPostId(postId);
				likeRepository.save(like);
			 return 1;	
			}
			}
	public long getLikeCount(Integer postId) {
		return likeRepository.countByPostId(postId);
	}
		}

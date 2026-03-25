package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
    // 既存のメソッド（もしあれば）
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.likes")
    List<Post> findAllWithLikes();

    // ★これを追加：キーワード検索用のメソッド
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.likes WHERE p.movieTitle LIKE %:keyword% OR p.content LIKE %:keyword%")
    List<Post> searchByKeyword(@Param("keyword") String keyword);
}
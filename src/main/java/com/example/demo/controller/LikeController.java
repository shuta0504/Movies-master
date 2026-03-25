package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LikeService;

import lombok.RequiredArgsConstructor;

@RestController // APIとして数値を返すため RestController が適しています
@RequestMapping("/post")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{id}/like")
    @ResponseBody
    public Long like(@PathVariable("id") Integer id) {
        Integer loginUserId = 1; // 暫定
        likeService.toggleLike(loginUserId, id);
        return likeService.getLikeCount(id);
    }
}
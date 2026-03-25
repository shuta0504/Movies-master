package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String password) {
		userService.register(username, password);
		// 登録後はログイン画面へリダイレクト。成功メッセージ用のパラメータを付与
		return "redirect:/login?register_success";
	}
}

package com.emgc.jobhunters.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emgc.jobhunters.dto.Member;
import com.emgc.jobhunters.serviceimpl.LoginServiceImpl;

@Controller
public class MainController {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@PostMapping("/login")
	public String showAfterLogin(Member member) {
		if(loginServiceImpl.checkPassword(member.getId(), member.getPassword())) return "main";
		else return "error";
	}
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerMember(@Valid @ModelAttribute Member member) throws Exception {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getEmail());
		return "register";
	}
	
}

package com.emgc.jobhunters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emgc.jobhunters.serviceimpl.EmailServiceImpl;

@Controller
public class CertificationController {
	
	@Autowired
	EmailServiceImpl emailServiceImpl;
	
	private int num;
	
	@GetMapping("/mail")
	@ResponseBody
	public void sendNumber(@RequestParam String email) {
		num = (int)(Math.random() * 999999) + 100000;
		emailServiceImpl.sendOnlyText(email, "인증번호", Integer.toString(num));
	}
	
	@GetMapping("/mail/{num}")
	@ResponseBody
	public boolean checkNumber(@PathVariable Integer num) {
		return this.num==num?true:false;
	}
}

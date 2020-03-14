package com.emgc.jobhunters.serviceimpl;

import org.springframework.stereotype.Service;
import com.emgc.jobhunters.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private String id = "Lim";
	private String password = "1234";
	
	@Override
	public boolean checkId(String id) {
		return id.equals(id);
	}

	@Override
	public boolean checkPassword(String id, String password) {
		return id.equals(this.id)&&password.equals(this.password);
	}
}
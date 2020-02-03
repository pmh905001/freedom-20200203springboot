package com.pmh.freedom.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pmh.freedom.springboot.entity.MyUser;
import com.pmh.freedom.springboot.services.MyUserServices;

@RestController
@RequestMapping("/user")
public class MyUserController {
	@Autowired
	private MyUserServices myUserServices;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			MyUser user = new MyUser();
			user.setUserName(userName);
			user.setPassword(password);
			return myUserServices.insertUser(user) + "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/findAllUser")
	public List<MyUser> findAllUser() {
		return myUserServices.selectUser();
	}
}

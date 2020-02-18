package com.pmh.freedom.springboot.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.pmh.freedom.springboot.entity.MyUser;
import com.pmh.freedom.springboot.page.PageBean;
import com.pmh.freedom.springboot.page.PageModel;
import com.pmh.freedom.springboot.page.ResponseResult;
import com.pmh.freedom.springboot.services.MyUserServices;

@RestController
@RequestMapping("/user")
public class MyUserController {
	@Autowired
	private MyUserServices myUserServices;
	
	private static AtomicInteger count=new AtomicInteger(0);

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
		List<MyUser> result = myUserServices.selectUser();
		System.err.println(count.incrementAndGet()); 
		return result;
		
	}

	@RequestMapping("/findAllUser2")
	public ResponseResult<PageBean> findAllUser2(PageModel pageModel) {
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		PageHelper.orderBy("id desc");
		List<MyUser> myUsers = myUserServices.selectUser();
		PageBean<MyUser> pageBean = new PageBean<>(myUsers);
		return new ResponseResult<>(200, "success", pageBean);
	}
}

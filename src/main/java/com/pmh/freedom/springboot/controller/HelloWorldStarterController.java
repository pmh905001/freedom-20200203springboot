package com.pmh.freedom.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmh.freedom.helloword.HelloWorldService;
import com.pmh.freedom.springboot.entity.BlogModel;

@RestController
@RequestMapping("/starter")
public class HelloWorldStarterController {
	@Autowired(/* required=false */)
	private HelloWorldService service;

	@RequestMapping("/hello")
	public String add(BlogModel view) {
		service.sayHello();
		return "success";
	}

}

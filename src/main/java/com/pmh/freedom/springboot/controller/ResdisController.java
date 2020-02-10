package com.pmh.freedom.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmh.freedom.springboot.services.RedisService;

@RestController
@RequestMapping("/redis")
public class ResdisController {
	@Autowired
	private RedisService redisService;

	@RequestMapping("/set")
	public String set(String key, String msg) {
		return redisService.setMsg(key, msg);
	}

	@RequestMapping("/get")
	public String get(String key) {
		return redisService.getMsg(key);
	}
}

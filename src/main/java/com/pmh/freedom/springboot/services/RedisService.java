package com.pmh.freedom.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	public String setMsg(String key, String msg) {
		redisTemplate.opsForValue().set(key, msg);
		return "success";
	}	

	public String getMsg(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}

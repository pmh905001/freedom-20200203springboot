package com.pmh.freedom.springboot.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pmh.freedom.springboot.entity.MyUser;
import com.pmh.freedom.springboot.mapper.MyUserMapper;

@Service
public class MyUserServices {

	@Resource
	private MyUserMapper userMapper;

	public Integer insertUser(MyUser user) {
		return userMapper.insertUser(user);
	}

	public Integer insertUser(List<MyUser> users) {
		return userMapper.batchInsertUser(users);
	}

	public MyUser deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

	public MyUser updateUser(MyUser user) {
		return userMapper.updateUser(user);
	}

	public MyUser selectUser(Integer id) {
		return userMapper.selectUser(id);
	}

	public List<MyUser> selectUser() {
		return userMapper.selectAllUser();
	}

	public List<MyUser> selectUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

}

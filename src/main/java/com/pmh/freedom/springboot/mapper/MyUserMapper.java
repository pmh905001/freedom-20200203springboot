package com.pmh.freedom.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.pmh.freedom.springboot.entity.MyUser;

public interface MyUserMapper {
	Integer insertUser(MyUser user);

    Integer batchInsertUser(List<MyUser> users);

    MyUser deleteUser(Integer id);

    MyUser updateUser(MyUser user);

    MyUser selectUser(Integer id);

    List<MyUser> selectAllUser();

    @Select("select * from user_t where username like CONCAT('%',#{0},'%')")
    @ResultMap("com.pmh.freedom.springboot.mapper.MyUserMapper.userMap")
    List<MyUser> selectUserByName(String name);
}

package com.hejj.mapper;

import com.hejj.bean.User;
import com.hejj.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addUser(User user);
    int delUser(Integer id);
    int updateUser(User user);
    User selectByName(String name);
    User selectById(Integer id);
    List<User> selectByParam(UserQuery query);
}

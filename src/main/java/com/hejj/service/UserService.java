package com.hejj.service;

import com.hejj.bean.User;
import com.hejj.query.UserQuery;

import java.util.List;

public interface UserService {
    int addUser(User user);
    int updateUser(User user);
    int delUser(Integer id);
    User findByName(String name);
    User findById(Integer id);
    List<User> findByQuery(UserQuery query);
}

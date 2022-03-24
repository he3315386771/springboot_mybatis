package com.hejj.service;

import com.github.pagehelper.PageInfo;
import com.hejj.bean.User;
import com.hejj.query.UserQuery;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void delUser(Integer id);
    User findByName(String name);
    User findById(Integer id);
    PageInfo<User> findByQuery(UserQuery query);
}

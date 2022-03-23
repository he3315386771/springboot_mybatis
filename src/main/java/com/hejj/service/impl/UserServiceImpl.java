package com.hejj.service.impl;

import com.hejj.bean.User;
import com.hejj.mapper.UserMapper;
import com.hejj.query.UserQuery;
import com.hejj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delUser(Integer id) {
        return userMapper.delUser(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> findByQuery(UserQuery query) {
        return userMapper.selectByParam(query);
    }
}

package com.hejj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejj.bean.User;
import com.hejj.mapper.UserMapper;
import com.hejj.query.UserQuery;
import com.hejj.service.UserService;
import com.hejj.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        AssertUtil.isTrue(userMapper.selectByName(user.getUserName())!=null,"用户已存在");
        AssertUtil.isTrue(userMapper.addUser(user)<1,"添加失败");
    }

    @Override
    public void updateUser(User user) {
        AssertUtil.isTrue(user.getUserId()==null,"ID不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        User temp = userMapper.selectByName(user.getUserName());
        AssertUtil.isTrue(temp!=null && !user.getUserId().equals(temp.getUserId()),"用户已存在");
        AssertUtil.isTrue(userMapper.selectById(user.getUserId())==null,"用户不存在");
        AssertUtil.isTrue(userMapper.updateUser(user)<1,"添加失败");
    }

    @Override
    public void delUser(Integer id) {
        AssertUtil.isTrue(id==null,"待删除数据不存在");
        AssertUtil.isTrue(userMapper.delUser(id)<1,"删除失败");
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
    public  PageInfo<User> findByQuery(UserQuery query) {
        //初始分页单位
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        //查询数据
        List<User> users = userMapper.selectByParam(query);
        //开始分页
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}

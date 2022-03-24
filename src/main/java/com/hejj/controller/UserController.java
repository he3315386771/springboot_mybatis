package com.hejj.controller;

import com.hejj.bean.User;
import com.hejj.exception.ParamsException;
import com.hejj.query.UserQuery;
import com.hejj.service.UserService;
import com.hejj.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController//每个方法上都加上@Responsebody
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findUser/{uname}")
    public User sayName(@PathVariable String uname){
        return userService.findByName(uname);
    }

    @RequestMapping("findUserId/{id}")
    public User sayId(@PathVariable Integer id){
        return userService.findById(id);
    }

    @RequestMapping("del/{id}")
    public ResultInfo sayDel(@PathVariable Integer id){
        ResultInfo result = new ResultInfo();
        try{
            userService.delUser(id);
        }catch (ParamsException pe){
            pe.printStackTrace();
            result.setCode(pe.getCode());
            result.setMsg(pe.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("删除失败");
        }
        return result;
    }
    @RequestMapping("add")
    public ResultInfo sayDel(User user){
        ResultInfo result = new ResultInfo();
        try{
            userService.addUser(user);
        }catch (ParamsException pe){
            pe.printStackTrace();
            result.setCode(pe.getCode());
            result.setMsg(pe.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("添加失败");
        }
        return result;
    }
    @RequestMapping("update")
    public ResultInfo sayUp(User user){
        ResultInfo result = new ResultInfo();
        try{
            userService.updateUser(user);
        }catch (ParamsException pe){
            pe.printStackTrace();
            result.setCode(pe.getCode());
            result.setMsg(pe.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("修改失败");
        }
        return result;
    }
    @RequestMapping("page")
    public ResultInfo sayPage(UserQuery user){
        ResultInfo result = new ResultInfo();
        try{
            result.setObject(userService.findByQuery(user));
        }catch (ParamsException pe){
            pe.printStackTrace();
            result.setCode(pe.getCode());
            result.setMsg(pe.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("查询失败");
        }
        return result;
    }
}

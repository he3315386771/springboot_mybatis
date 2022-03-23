package com.hejj.controller;

import com.hejj.bean.User;
import com.hejj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findUser/{uname}")
    @ResponseBody
    public User sayName(@PathVariable String uname){
        return userService.findByName(uname);
    }

    @RequestMapping("findUserId/{id}")
    @ResponseBody
    public User sayId(@PathVariable Integer id){
        return userService.findById(id);
    }
}

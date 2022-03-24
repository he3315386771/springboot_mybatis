package com.hejj.controller;

import com.github.pagehelper.PageInfo;
import com.hejj.bean.User;
import com.hejj.exception.ParamsException;
import com.hejj.query.UserQuery;
import com.hejj.service.UserService;
import com.hejj.vo.ResultInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//每个方法上都加上@Responsebody
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiImplicitParam(name = "uname",value = "查询参数",required = true,type = "path")
    @GetMapping("findUser/{uname}")
    public User sayName(@PathVariable String uname){
        return userService.findByName(uname);
    }

    @GetMapping("findUserId/{id}")
    @ApiOperation(value = "根据ID查询用户记录")
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true,type = "path")
    public User sayId(@PathVariable Integer userId){
        return userService.findById(userId);
    }

    @DeleteMapping("del/{id}")
    @ApiOperation(value = "根据ID删除用户记录")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,type = "path")
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
    @PostMapping("add")
    @ApiOperation(value = "添加用户记录")
    @ApiImplicitParam(name = "user",value = "添加的用户",required = true,type = "form")
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
    @PostMapping("update")
    @ApiOperation(value = "修改用户记录")
    @ApiImplicitParam(name = "user",value = "修改的用户",required = true,type = "form")
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
    @PostMapping("page")
    @ApiOperation(value = "分页查询用户记录")
    @ApiImplicitParam(name = "userQuery",value = "查询参数对象",required = true,type = "form")
    public PageInfo<User> sayPage(UserQuery userQuery){
        return userService.findByQuery(userQuery);
    }
}

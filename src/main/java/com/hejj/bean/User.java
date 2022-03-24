package com.hejj.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户数据")
public class User {
    @ApiModelProperty(name = "userId",value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    private String userPwd;
    public User(){}

    public User(Integer userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}

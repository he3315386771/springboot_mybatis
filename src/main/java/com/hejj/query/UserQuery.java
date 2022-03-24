package com.hejj.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户模块条件查询")
public class UserQuery {
    @ApiModelProperty(name = "pageNum",value = "分页页码",example = "1")
    private Integer pageNum=1;
    @ApiModelProperty(value = "分页大小",example = "10")
    private Integer pageSize=10;
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", userName='" + userName + '\'' +
                '}';
    }
}

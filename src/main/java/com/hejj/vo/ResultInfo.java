package com.hejj.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回响应数据")
public class ResultInfo {
    @ApiModelProperty(name = "code",value = "响应状态码")
    private Integer code = 200;
    @ApiModelProperty(value = "响应提示信息")
    private String msg = "操作成功";
    @ApiModelProperty(value = "响应数据")
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

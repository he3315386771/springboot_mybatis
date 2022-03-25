package com.hejj.exception;

import com.hejj.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobaleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo sayException(Exception e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg("操作异常");
        if(e instanceof ParamsException){
            ParamsException paramsException = (ParamsException)e;
            resultInfo.setCode(paramsException.getCode());
            resultInfo.setMsg(paramsException.getMsg());
        }
        return resultInfo;
    }
}

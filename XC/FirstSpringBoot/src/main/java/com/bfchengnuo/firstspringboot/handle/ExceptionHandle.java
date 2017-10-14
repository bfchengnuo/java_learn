package com.bfchengnuo.firstspringboot.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 * 异常捕获处理
 */
@ControllerAdvice
public class ExceptionHandle {

    // 要捕获那个异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody  // 转成 json....额
    public String handle(Exception e) {
        return e.getMessage();
    }
}

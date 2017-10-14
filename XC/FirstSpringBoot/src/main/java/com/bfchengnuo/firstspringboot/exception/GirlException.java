package com.bfchengnuo.firstspringboot.exception;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 * 记得一定继承 RuntimeException ，否则 boot 不会进行回滚事务
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

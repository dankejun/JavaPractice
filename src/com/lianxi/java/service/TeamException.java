package com.lianxi.java.service;

/**
 * @author dankejun
 * @create 2020-02-05 20:47
 * @description 自定义异常类
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -3213486574624187L;

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }
}

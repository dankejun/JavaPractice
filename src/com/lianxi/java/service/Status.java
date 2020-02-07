package com.lianxi.java.service;

/**
 * @author dankejun
 * @create 2020-02-05 19:27
 * @description 员工状态
 */
public class Status {

    private final String NAME;
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    private Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}

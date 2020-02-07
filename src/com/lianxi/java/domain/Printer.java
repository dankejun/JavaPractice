package com.lianxi.java.domain;

/**
 * @author dankejun
 * @create 2020-02-05 19:07
 * @description 打印机类
 */
public class Printer implements Equipment {

    private String name;//表示机器的名称
    private String type;//表示机器的类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

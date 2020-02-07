package com.lianxi.java.domain;

/**
 * @author dankejun
 * @create 2020-02-05 19:00
 * @description PC类
 */
public class PC implements Equipment {

    private String model;//表示机器的型号
    private String display;//表示显示器名称

    public PC() {
    }

    public PC(String model, String desplay) {
        this.model = model;
        this.display = desplay;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesplay() {
        return display;
    }

    public void setDesplay(String desplay) {
        this.display = desplay;
    }
}

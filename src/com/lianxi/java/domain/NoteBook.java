package com.lianxi.java.domain;

/**
 * @author dankejun
 * @create 2020-02-05 19:04
 * @description NoteBook类
 */
public class NoteBook implements Equipment {

    private String model;//表示机器的型号
    private double price;//价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

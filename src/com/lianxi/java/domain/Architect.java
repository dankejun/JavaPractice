package com.lianxi.java.domain;

/**
 * @author dankejun
 * @create 2020-02-05 19:38
 * @description 架构师类
 */
public class Architect extends Designer {

    private int stock;//公司奖励的股票数量

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
         return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}

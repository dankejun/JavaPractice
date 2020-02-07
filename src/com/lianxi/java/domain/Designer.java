package com.lianxi.java.domain;

/**
 * @author dankejun
 * @create 2020-02-05 19:34
 * @description 设计师类
 */
public class Designer extends Progrommer {

    private double bonus;//奖金

    public Designer() {

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Designer(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getTeamBaseDetails() + "\t设计师\t" + getBonus();
    }
}

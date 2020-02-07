package com.lianxi.java.domain;

import com.lianxi.java.service.Status;

/**
 * @author dankejun
 * @create 2020-02-05 19:18
 * @description 程序员类
 */
public class Progrommer extends Employee{

    private int memberid;//用来记录成员在加入开发团队后在团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;//表示该成员领用的设备

    public Progrommer() {
    }

    public Progrommer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getTeamBaseDetails(){
        return memberid + "/" + getId() + "\t\t" + getName() + "\t" + getAge() + "\t\t" + getSalary();
    }

    public String getDetailsForTeam(){
        return getTeamBaseDetails() + "\t程序员\t";
    }
}

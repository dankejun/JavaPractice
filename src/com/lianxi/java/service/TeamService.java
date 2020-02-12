package com.lianxi.java.service;

import com.lianxi.java.domain.Architect;
import com.lianxi.java.domain.Designer;
import com.lianxi.java.domain.Employee;
import com.lianxi.java.domain.Progrommer;

/**
 * @author dankejun
 * @create 2020-02-06 18:21
 * @description 关于开发团队人员的管理，添加、删除等
 */
public class TeamService {

    private int counter = 1;//用来为开发团队成员自动生成唯一的ID,即memberid
    private final int MAX_MEMBER = 5;//表示开发团队最大成员数
    private Progrommer[] team = new Progrommer[MAX_MEMBER];//用来保存当前团队中的各成员对象
    private int total;//记录团队成员的实际人数

    public TeamService() {
    }

    /**
     *  获取开发团队中的所有成员
     * @return
     */
    public Progrommer[] getMember() {
        Progrommer[] team = new Progrommer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定的员工添加到开发团队中
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
//        成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加！");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Progrommer)){
            throw new TeamException("该成员不是开发人员，无法添加!");
        }
//        该员工已在本开发团队中
        if (isExist(e)){
            throw new TeamException("该员工已在本开发团队中!");
        }
//        该员工已是某团队成员
//        该员正在休假，无法添加
        Progrommer progrommer = (Progrommer)e;//不会出现ClassCastException
//        if ("BUSY".equalsIgnoreCase(progrommer.getStatus().getNAME())) {
//            throw new TeamException("该员工已是某团队成员!");
//        }
//        if ("VOCATION".equalsIgnoreCase(progrommer.getStatus().getNAME())) {
//            throw new TeamException("该员正在休假，无法添加!");
//        }
        switch (progrommer.getStatus()) {//byte\short\char\int\String\枚举类
            case BUSY:
                throw new TeamException("该员工已是某团队成员!");
            case VOCATION:
                throw new TeamException("该员正在休假，无法添加!");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numOfArch = 0,numOfDes = 0,numOfPro = 0;
        //获取team中已有成员中架构师、设计设和程序员的人数
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Progrommer) {
                numOfPro++;
            }
        }
        if (progrommer instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师!");
            }
        } else if (progrommer instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师!");
            }
        } else if (progrommer instanceof Progrommer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员!");
            }
        }

        //将指定员工progrommer添加到team中
        team[total] = progrommer;
        total++;
        //progrommer的属性赋值
        progrommer.setStatus(Status.BUSY);
        progrommer.setMemberid(counter++);
    }

    /**
     * 判断指定员工是否已经存在于现有的开发团队中
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;

    }

    /**
     * 从团队中删除成员
     * @param memberId
     */
    public void remvoeMember(int memberId) throws TeamException {
        //遍历是否存在指定memberId的成员
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberid() == memberId) {//若存在
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //若不存在
        if (i == total) {
            throw new TeamException("找不到指定员工，删除失败！");
        }
        //用后一个成员覆盖前一个
        for (int j = i+1; j < total; j++) {
            team[j - 1] = team[j];
        }
        //将最后一个元素赋值为null
        team[total-1] = null;
        total--;

    }
}

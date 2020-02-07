package com.lianxi.java.view;

import com.lianxi.java.domain.Employee;
import com.lianxi.java.domain.Progrommer;
import com.lianxi.java.service.NameLisrService;
import com.lianxi.java.service.TeamException;
import com.lianxi.java.service.TeamService;
import com.lianxi.java.util.TSUtility;

/**
 * @author dankejun
 * @create 2020-02-06 19:46
 * @description 主界面
 */
public class TeamView {

    private NameLisrService listSvc = new NameLisrService();
    private TeamService teamSvc = new TeamService();

    /**
     * 主界面显示以及控制方法
     */
    public void enterMainMenu() {

        boolean loopFlag = true;
        char menuSelection = 0;
        while (loopFlag) {
            if (menuSelection != '1') {
                listAllEmployee();
            }

            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");

            menuSelection = TSUtility.readMenuSelection();
            switch (menuSelection) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否要退出（Y/N)：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * 以表格形式列出公司的所有成员
     */
    private void listAllEmployee() {
        System.out.println("--------------------------------开发团队调度软件------------------------------\n");
        Employee[] allEmployees = listSvc.getAllEmployees();
        if (allEmployees == null || allEmployees.length == 0) {
            System.out.println("公司中没有任何员工信息！");
        } else {
            System.out.println("ID\t姓名\t年龄 工资\t职位\t状态\t奖金\t股票\t领用设备\t");
            for (int i = 0; i < allEmployees.length; i++) {
                System.out.println(allEmployees[i]);
            }
        }

        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 显示团队成员操作
     */
    private void getTeam() {
        System.out.println("------------------------------团队成员列表-------------------------------------\n");

        Progrommer[] team = teamSvc.getMember();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }

        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * 实现添加成员操作
     */
    private void addMember() {

        System.out.println("---------------------------------添加成员---------------------------------------");
        System.out.print("请输入添加成员的ID：");
        int id = TSUtility.readInt();

        Employee employee = null;
        try {
            employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        //按回车健继续........
        TSUtility.readReturn();
    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember() {
        System.out.println("---------------------------------添加成员---------------------------------------");
        System.out.print("请输入删除成员的TID：");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除（Y/N)：");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSvc.remvoeMember(memberId);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        //按回车健继续........
        TSUtility.readReturn();

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}

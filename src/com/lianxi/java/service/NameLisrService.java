package com.lianxi.java.service;

import com.lianxi.java.domain.*;

import static com.lianxi.java.service.Data.*;

/**
 * @author dankejun
 * @create 2020-02-05 19:43
 * @description 负责将Data中的数据封装到Employeep[]数组中，同时提供相关操作Employee[]的方法
 */
public class NameLisrService {

    private Employee[] employees;

    /**
     * 给employee及数组元素进行初始化
     */
    public NameLisrService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的四种属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Progrommer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        //获取设备类型
        int type = Integer.parseInt(EQIPMENTS[index][0]);

        switch (type){
            case PC:
                return new PC(EQIPMENTS[index][1], EQIPMENTS[index][2]);

            case NOTEBOOK:
                double price = Double.parseDouble(EQIPMENTS[index][2]);
                return new NoteBook(EQIPMENTS[index][1], price);

            case PRINTER:
                return new Printer(EQIPMENTS[index][1], EQIPMENTS[index][2]);

        }
        return null;
    }

    /**
     * 获取当前所有员工
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定id的员工
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
       throw new TeamException("找不到指定员工！");
    }
}

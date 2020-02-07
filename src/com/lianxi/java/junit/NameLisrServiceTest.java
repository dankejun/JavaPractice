package com.lianxi.java.junit;

import com.lianxi.java.domain.Employee;
import com.lianxi.java.service.NameLisrService;
import com.lianxi.java.service.TeamException;
import org.junit.Test;

/**
 * @author dankejun
 * @create 2020-02-05 20:56
 * @description 对NameListService进行测试
 */
public class NameLisrServiceTest {

    @Test
    public void getAllEmployeesTest() {
        NameLisrService nameLisrService = new NameLisrService();
        Employee[] employees = nameLisrService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void getEmployee() {
        NameLisrService service = new NameLisrService();
        int id = 5;//指定员工id
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
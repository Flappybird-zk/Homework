package com.ssm.service;

import com.ssm.converter.MyDateConverter;
import com.ssm.entity.Employee;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * EmployeeService测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest extends TestCase {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testFindAll() {
        List<Employee> list = employeeService.findAll();
        for(Employee l: list){
            System.out.println(l);
        }
    }

    @Test
    public void testAddEmployee() {
        MyDateConverter converter = new MyDateConverter();
        Employee employee = new Employee("张三", 1, "销售经理", converter.convert("2021-02-21"), "13728936745");
        System.out.println(employee);
        employeeService.addEmployee(employee);
    }
}
package com.ssm.service;

import com.ssm.entity.Department;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * DepartmentService测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest extends TestCase {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testFindAll() {
        List<Department> list = departmentService.findAll();
        for(Department l: list){
            System.out.println(l);
        }

    }

    @Test
    public void testFindDeptById() {
        Department dept = departmentService.findDeptById(1);
        System.out.println(dept);
    }
}
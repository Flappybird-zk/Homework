package com.ssm.dao;

import com.ssm.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 查询所有员工
     * @return
     */
    List<Employee> findAll();

    /**
     * 新增员工
     * @param employee
     */
    void addEmployee(Employee employee);

}

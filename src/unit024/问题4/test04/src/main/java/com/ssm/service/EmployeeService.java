package com.ssm.service;

import com.ssm.entity.Employee;

import java.util.List;

/**
 * 员工服务
 */
public interface EmployeeService {
    /**
     * 查询所有员工过
     * @return
     */
    List<Employee> findAll();

    /**
     * 新增员工
     * @param employee
     */
    void addEmployee(Employee employee);
}

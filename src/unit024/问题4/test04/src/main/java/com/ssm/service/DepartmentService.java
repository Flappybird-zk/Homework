package com.ssm.service;

import com.ssm.entity.Department;

import java.util.List;

/**
 * 部门服务
 */
public interface DepartmentService {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> findAll();

    /**
     * 根据部门ID查询信息
     * @param deptId
     * @return
     */
    Department findDeptById(Integer deptId);
}

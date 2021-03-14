package com.ssm.dao;

import com.ssm.entity.Department;

import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> findAll();

    /**
     * 通过ID查询部门
     * @param deptId
     * @return
     */
    Department findDeptById(Integer deptId);
}

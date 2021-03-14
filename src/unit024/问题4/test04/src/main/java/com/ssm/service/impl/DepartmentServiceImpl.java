package com.ssm.service.impl;

import com.ssm.dao.DepartmentDao;
import com.ssm.entity.Department;
import com.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findDeptById(Integer deptId) {
        return departmentDao.findDeptById(deptId);
    }
}

package com.ssm.controller;

import com.ssm.entity.Department;
import com.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有部门信息
     * @return
     */
    @GetMapping("dept/all")
    @ResponseBody
    public List<Department> findAll(){
        return departmentService.findAll();
    }
}

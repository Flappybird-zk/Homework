package com.ssm.controller;

import com.ssm.entity.Department;
import com.ssm.entity.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工管理首页
     * @param model
     * @return
     */
    @RequestMapping("/employee/index")
    public String findAllEmployee(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "/employee/index";
    }

    /**
     * 新增员工
     * @param empName
     * @param deptId
     * @param jobName
     * @param joinDate
     * @param telephone
     * @return
     */
    @PostMapping("/employee/add")
    public String addEmployee(String empName, Integer deptId, String jobName, Date joinDate, String telephone){
        Employee employee = new Employee(empName, deptId, jobName, joinDate, telephone);
        employeeService.addEmployee(employee);
        return "redirect:/employee/index";
    }
}

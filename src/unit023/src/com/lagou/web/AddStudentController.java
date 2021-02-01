package com.lagou.web;

import com.lagou.entity.Student;
import com.lagou.entity.User;
import com.lagou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

public class AddStudentController extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         doPost(req, resp);
//     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        Date dateBirthday = java.sql.Date.valueOf(birthday);

        Student stu = new Student();
        stu.setId(id);
        stu.setUsername(username);
        stu.setGender(gender);
        stu.setBirthday(dateBirthday);
        System.out.println(stu);

        boolean result = false;
        UserService service = new UserService();
        try {
            result = service.addStudent(stu);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        if(result){
            out.println("添加学生信息成功！");
        }else{
            out.println("添加学生信息失败！");
        }

    }
}

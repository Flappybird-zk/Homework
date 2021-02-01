package com.lagou.web;

import com.lagou.entity.Student;
import com.lagou.entity.User;
import com.lagou.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         doPost(req, resp);
//     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
//         out.println("username:" + username + ", password:" + password);
        UserService service = new UserService();
        try {
            User user = service.login(username, password);
            if(user != null){
                out.println("ok！！！");
                HttpSession sess = req.getSession();
                sess.setAttribute("user", user);
                resp.sendRedirect("success.html");
            }else{
                out.println("用户名或密码错误！！！");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}

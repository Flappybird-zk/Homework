package com.lagou.service;

import com.lagou.dao.UserDao;
import com.lagou.entity.Student;
import com.lagou.entity.User;

import java.sql.SQLException;

public class UserService implements IUserService {
    @Override
    public User login(String username, String password) throws SQLException {
        UserDao dao = new UserDao();
        return dao.login(username, password);
    }

    @Override
    public boolean addStudent(Student student) throws SQLException{
        UserDao dao = new UserDao();
        int rowCount = dao.insertStudent(student);
        return rowCount > 0;
    }
}

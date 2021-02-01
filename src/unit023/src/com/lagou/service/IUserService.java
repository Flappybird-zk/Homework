package com.lagou.service;

import com.lagou.entity.Student;
import com.lagou.entity.User;

import java.sql.SQLException;

public interface IUserService {
    public User login(String username, String password) throws SQLException;

    public boolean addStudent(Student student) throws SQLException, SQLException;
}

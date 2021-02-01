package com.lagou.dao;

import com.lagou.entity.Student;
import com.lagou.entity.User;

import java.sql.SQLException;

public interface IUserDao {

    // 登陆
    public User login(String username, String password) throws SQLException;

    // 插入
    public int insertStudent(Student student) throws SQLException;
}

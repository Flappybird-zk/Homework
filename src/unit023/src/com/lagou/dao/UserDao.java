package com.lagou.dao;

import com.lagou.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.lagou.entity.Student;
import com.lagou.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDao implements IUserDao {
    @Override
    public User login(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
        String sql = "SELECT * FROM `user` WHERE `username`=? AND `password`=?";
        Object[] param = new Object[]{username, password};
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public int insertStudent(Student stu) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
        String sql = "INSERT INTO `student`(`id`,`username`,`gender`,`birthday`) values(?,?,?,?)";
        Object[] param = new Object[]{stu.getId(), stu.getUsername(), stu.getGender(), stu.getBirthday()};
        int rowCount = qr.update(sql, param);
        return rowCount;
    }
}

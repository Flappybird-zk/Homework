package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.common.ServerResponse;
import com.lagou.model.User;
import com.mysql.fabric.Server;

public interface IUserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public ServerResponse<User> login(String username, String password);

    ServerResponse<PageInfo> getUsers(int pageNum, int pageSize);

    ServerResponse<String> add(User user);

    ServerResponse<String> deleteByPrimary(int id);

    /**
     * 获取用户信息
     * @param id 用户ID
     * @return
     */
    public ServerResponse<User> getInformation(int id);

    /**
     * 修改用户
     * @param user User信息
     * @return
     */
    public ServerResponse<String> editUser(User user);
}

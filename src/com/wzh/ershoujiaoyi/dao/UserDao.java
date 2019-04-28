package com.wzh.ershoujiaoyi.dao;

import com.wzh.ershoujiaoyi.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/7
 * Time: 15:11
 * Description: User类的Dao,包含添加，查询方法
 */
public interface UserDao {
    //注册功能
    int add(User user);
    //登录功能
    User findOne(String userName);
    //用户更新个人信息
    int update(User user);
}

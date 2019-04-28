package com.wzh.ershoujiaoyi.service;

import com.wzh.ershoujiaoyi.bean.User;
import com.wzh.ershoujiaoyi.dao.UserDao;
import com.wzh.ershoujiaoyi.dao.daoImpl.UserDaoImpl;
/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/7
 * Time: 15:37
 * Description: User的service层
 */
public class UserService {
    private UserDao userDao=new UserDaoImpl();
    public int add(User user){
        return userDao.add(user);
    }
    public User findOne(String userName){
        return userDao.findOne(userName);
    }
    public int update(User user){
        return userDao.update(user);
    }
}

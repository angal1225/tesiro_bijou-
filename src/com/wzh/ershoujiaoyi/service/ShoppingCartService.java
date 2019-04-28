package com.wzh.ershoujiaoyi.service;

import com.wzh.ershoujiaoyi.bean.ShoppingCart;
import com.wzh.ershoujiaoyi.dao.ShoppingCartDao;
import com.wzh.ershoujiaoyi.dao.daoImpl.ShoppingCartDaoImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/26
 * Time: 9:06
 * Description: No Description
 */
public class ShoppingCartService {
    private ShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
    public int add(ShoppingCart shoppingCart){
        return shoppingCartDao.add(shoppingCart);
    }
    public List<ShoppingCart> findAll(String user){
        return shoppingCartDao.findAll(user);
    }
    public int delete(Integer id,String user){
        return shoppingCartDao.delete(id,user);
    }
}

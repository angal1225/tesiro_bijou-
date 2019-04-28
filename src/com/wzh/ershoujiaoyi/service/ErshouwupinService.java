package com.wzh.ershoujiaoyi.service;


import com.wzh.ershoujiaoyi.bean.Ershouwupin;
import com.wzh.ershoujiaoyi.dao.ErshouwupinDao;
import com.wzh.ershoujiaoyi.dao.daoImpl.ErshouwupinDaoImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:36
 * Description: No Description
 */
public class ErshouwupinService {
    private ErshouwupinDao ershouwupinDao=new ErshouwupinDaoImpl();
    public List<Ershouwupin> search(String title){
        return ershouwupinDao.search(title);
    }

    public Ershouwupin queryDetail(int id){
        return ershouwupinDao.queryDetail(id);
    }

    public List<Ershouwupin> findOneSale(String username){
        return ershouwupinDao.findOneSale(username);
    }
}

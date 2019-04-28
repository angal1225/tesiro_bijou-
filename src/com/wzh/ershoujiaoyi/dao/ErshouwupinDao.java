package com.wzh.ershoujiaoyi.dao;

import com.wzh.ershoujiaoyi.bean.Ershouwupin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:17
 * Description: No Description
 */
public interface ErshouwupinDao {
//    List<Ershouwupin> findAll();
    List<Ershouwupin> search(String title);
    Ershouwupin queryDetail(int id);
    List<Ershouwupin> findOneSale(String username);
}

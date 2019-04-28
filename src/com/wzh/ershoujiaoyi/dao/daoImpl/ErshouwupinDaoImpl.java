package com.wzh.ershoujiaoyi.dao.daoImpl;

import com.wzh.ershoujiaoyi.bean.Ershouwupin;
import com.wzh.ershoujiaoyi.dao.ErshouwupinDao;
import com.wzh.ershoujiaoyi.utils.DateUtil;
import com.wzh.ershoujiaoyi.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:18
 * Description: 搜索，获得全部
 */
public class ErshouwupinDaoImpl implements ErshouwupinDao {
    @Override
    public List<Ershouwupin> search(String title) {
        String sql="SELECT * FROM ershouwupin WHERE title like '%"+title+"%'";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                int price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                int date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate);
                list.add(ershouwupin);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ershouwupin queryDetail(int id) {
        String sql="SELECT * FROM ershouwupin WHERE id=?";
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                int price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                int date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate);
                return ershouwupin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ershouwupin> findOneSale(String username) {
        String sql="SELECT * FROM ershouwupin WHERE sell_user=?";
        Connection conn = JdbcUtils.getConnection();
        List<Ershouwupin> list=new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                int price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                int date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate);
                list.add(ershouwupin);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

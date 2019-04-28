package com.wzh.ershoujiaoyi.dao.daoImpl;

import com.wzh.ershoujiaoyi.bean.ShoppingCart;
import com.wzh.ershoujiaoyi.dao.ShoppingCartDao;
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
 * Date: 2019/4/26
 * Time: 9:00
 * Description: No Description
 */
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public int add(ShoppingCart shoppingCart) {
        String sql="insert into shopping_cart(id,user,image,title,price,date) values (?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shoppingCart.getId());
            ps.setString(2,shoppingCart.getUser());
            ps.setString(3,shoppingCart.getImage());
            ps.setString(4,shoppingCart.getTitle());
            ps.setInt(5,shoppingCart.getPrice());
            int newDate = DateUtil.stringToTimeStamp(shoppingCart.getDate());
            ps.setInt(6,newDate);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return 0;
    }

    @Override
    public List<ShoppingCart> findAll(String user) {
        String sql="select * from shopping_cart where user=?";
        List<ShoppingCart> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String image = rs.getString("image");
                String title = rs.getString("title");
                Integer price = rs.getInt("price");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new ShoppingCart(id,user,image,title,price,newDate));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return null;
    }

    @Override
    public int delete(Integer id,String user) {
        String sql="delete from shopping_cart where id=? and user=?";
        PreparedStatement ps=null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,user);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return 0;
    }

    @Override
    public ShoppingCart findOne(Integer id) {
        return null;
    }
}

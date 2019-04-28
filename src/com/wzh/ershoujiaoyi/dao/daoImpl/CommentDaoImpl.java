package com.wzh.ershoujiaoyi.dao.daoImpl;

import com.wzh.ershoujiaoyi.bean.Comment;
import com.wzh.ershoujiaoyi.dao.CommentDao;
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
 * Date: 2019/4/24
 * Time: 21:49
 * Description: No Description
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> findAll(Integer id) {
        String sql="select * from comment where id=?";
        List<Comment> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                String user = rs.getString("user");
                String comment = rs.getString("comment");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new Comment(id,user,comment,newDate));
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
    public int add(Comment comment) {
        String sql="insert into comment(id,user,comment,date) values (?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //将加密后的密码存入数据库
            ps.setInt(1,comment.getId());
            ps.setString(2,comment.getUser());
            ps.setString(3,comment.getComment());
            String date = comment.getDate();
            int newDate = DateUtil.stringToTimeStamp(date);
            ps.setInt(4,newDate);
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
    public int report(Comment comment) {
        String sql="update comment set is_reported=1 where id=? and user=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //将加密后的密码存入数据库
            ps.setInt(1,comment.getId());
            ps.setString(2,comment.getUser());
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
}

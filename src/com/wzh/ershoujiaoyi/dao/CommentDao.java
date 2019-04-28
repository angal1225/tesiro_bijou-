package com.wzh.ershoujiaoyi.dao;

import com.wzh.ershoujiaoyi.bean.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/24
 * Time: 21:49
 * Description: No Description
 */
public interface CommentDao {
    List<Comment> findAll(Integer id);
    int add(Comment comment);
    int report(Comment comment);
}

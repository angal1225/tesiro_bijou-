package com.wzh.ershoujiaoyi.controller;

import com.wzh.ershoujiaoyi.bean.Comment;
import com.wzh.ershoujiaoyi.service.CommentService;
import com.wzh.ershoujiaoyi.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/25
 * Time: 14:56
 * Description: No Description
 */
@WebServlet(name = "CommentServlet",urlPatterns = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    private CommentService commentService=new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("add".equals(action)){
            add(request,response);
        }else if("report".equals(action)){
            report(request,response);
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        Date date = new Date(System.currentTimeMillis());
        //将日期格式化成String类型
        String newDate = DateUtil.dateToString(date);
        int i = commentService.add(new Comment(Integer.parseInt(id), username, comment, newDate));
        if(i!=0){
            String msg="评论成功!";
            response.getWriter().print(msg);
        }
    }

    protected void report(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("commentId");
        String username = request.getParameter("username");
        int i = commentService.report(new Comment(Integer.parseInt(id), username));
        if(i!=0){
            response.getWriter().print("举报成功!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

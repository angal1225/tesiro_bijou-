package com.wzh.ershoujiaoyi.controller;

import com.wzh.ershoujiaoyi.bean.Comment;
import com.wzh.ershoujiaoyi.bean.Ershouwupin;
import com.wzh.ershoujiaoyi.service.CommentService;
import com.wzh.ershoujiaoyi.service.ErshouwupinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/10
 * Time: 23:48
 * Description:  search方法用于处理在搜索框中输入的信息
 *               queryDetail方法用于处理选中某一件商品时展示详情
 *               addShoppingCart方法用于添加购物车
 */
@WebServlet(name = "ErshouServlet",urlPatterns = "/ershouServlet")
public class ErshouServlet extends HttpServlet {
    private ErshouwupinService ershouwupinService=new ErshouwupinService();
    private CommentService commentService=new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("search".equals(action)){
            search(request,response);
        }else if("queryDetail".equals(action)){
            queryDetail(request,response);
        }else if("findOneSale".equals(action)){
            findOneSale(request,response);
        }
    }

    private void findOneSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<Ershouwupin> list = ershouwupinService.findOneSale(username);
        HttpSession session = request.getSession();
        session.setAttribute("oneSaleList",list);
        request.getRequestDispatcher("/foreground/shangjia.jsp").forward(request,response);
    }

    //queryDetail方法用于处理选中某一件商品时展示详情
    private void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Ershouwupin ershouwupin = ershouwupinService.queryDetail(Integer.parseInt(id));
        //查询某个商品所有的评论信息
        List<Comment> commentList = commentService.findAll(Integer.parseInt(id));
        request.setAttribute("ershouwupin",ershouwupin);
        request.setAttribute("commentList",commentList);
        request.getRequestDispatcher("foreground/xiangqing.jsp").forward(request,response);
    }

    //search方法用于处理在搜索框中输入的信息
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        List<Ershouwupin> searchList = ershouwupinService.search(title);
        int size = searchList.size();
        request.setAttribute("searchList",searchList);
        request.setAttribute("title",title);
        request.setAttribute("size",size);
        request.getRequestDispatcher("foreground/search.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
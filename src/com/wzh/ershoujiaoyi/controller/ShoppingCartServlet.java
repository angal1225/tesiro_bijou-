package com.wzh.ershoujiaoyi.controller;

import com.wzh.ershoujiaoyi.bean.Ershouwupin;
import com.wzh.ershoujiaoyi.bean.ShoppingCart;
import com.wzh.ershoujiaoyi.service.ErshouwupinService;
import com.wzh.ershoujiaoyi.service.ShoppingCartService;
import com.wzh.ershoujiaoyi.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/26
 * Time: 9:49
 * Description: No Description
 */
@WebServlet(name = "ShoppingCartServlet",urlPatterns = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private ShoppingCartService shoppingCartService=new ShoppingCartService();
    private ErshouwupinService ershouwupinService=new ErshouwupinService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("addShoppingCart".equals(action)){
            addShoppingCart(request,response);
        }else if("findAll".equals(action)){
            findAll(request,response);
        }else if("deleteOne".equals(action)){
            deleteOne(request,response);
        }
    }

    //addShoppingCart方法用于添加购物车
    private void addShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        if(username==null){
            String msg="请先登录!";
            response.getWriter().print(msg);
        }

        if(username!=null){
            String id = request.getParameter("id");
            Ershouwupin ershouwupin = ershouwupinService.queryDetail(Integer.parseInt(id));
            String image = ershouwupin.getImage();
            String title = ershouwupin.getTitle();
            Integer price = ershouwupin.getPrice();
            String date = DateUtil.dateToString(new Date(System.currentTimeMillis()));
            int i = shoppingCartService.add(new ShoppingCart(Integer.parseInt(id),username,image,title,price,date));
            if(i!=0){
                String msg="添加成功!";
                response.getWriter().print(msg);
            }else{
                String msg="请勿重复添加!";
                response.getWriter().print(msg);
            }
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        List<ShoppingCart> shoppingCartList = shoppingCartService.findAll(username);
        int size = shoppingCartList.size();
        Integer sum=0;
        for (ShoppingCart shoppingCart:shoppingCartList
             ) {
            Integer price = shoppingCart.getPrice();
            sum+=price;
        }
        session.setAttribute("shoppingCartList",shoppingCartList);
        session.setAttribute("sum",sum);
        session.setAttribute("size",size);
        response.sendRedirect("foreground/gouwuche.jsp");
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        String id = request.getParameter("id");
        int i = shoppingCartService.delete(Integer.parseInt(id), username);
        if(i!=0){
            List<ShoppingCart> shoppingCartList = shoppingCartService.findAll(username);
            int size = shoppingCartList.size();
            Integer sum=0;
            for (ShoppingCart shoppingCart:shoppingCartList
            ) {
                Integer price = shoppingCart.getPrice();
                sum+=price;
            }
            session.setAttribute("shoppingCartList",shoppingCartList);
            session.setAttribute("sum",sum);
            session.setAttribute("size",size);
            response.getWriter().print("移除成功!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

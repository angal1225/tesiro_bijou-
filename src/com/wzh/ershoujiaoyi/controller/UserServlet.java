package com.wzh.ershoujiaoyi.controller;

import com.wzh.ershoujiaoyi.bean.User;
import com.wzh.ershoujiaoyi.service.UserService;
import com.wzh.ershoujiaoyi.utils.JiaMi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/23
 * Time: 23:24
 * Description: No Description
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findOne".equals(action)){
            findOne(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }
    }

    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = userService.findOne(username);
        String password = user.getPassword();
        String psd = JiaMi.base64Decode(password);
        user.setPassword(psd);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/foreground/self_info.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String addr = request.getParameter("addr");
        //验证手机号格式
        int telLength = phone.length();
        String pattern2 = "^[0-9]*[1-9][0-9]*$";
        boolean isMatch = Pattern.matches(pattern2, phone);
        //判断密码是否小于六位
        int passwordLength = password.length();
        //收货地址不能为空
        int addrLength = addr.length();
        if(telLength<11||(!isMatch)){
            response.getWriter().print("手机号格式不正确!");
        }else if(passwordLength<6){
            response.getWriter().print("密码不可以小于六位!");
        }else if(addrLength==0||"".equals(addrLength)){
            response.getWriter().print("收货地址不能为空!");
        }else{
            int i = userService.update(new User(username, password, phone, addr));
            if (i!=0){
                response.getWriter().print("更新资料成功!");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

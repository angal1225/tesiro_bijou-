package com.wzh.ershoujiaoyi.controller;

import com.wzh.ershoujiaoyi.bean.User;
import com.wzh.ershoujiaoyi.service.UserService;
import com.wzh.ershoujiaoyi.utils.JiaMi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/7
 * Time: 14:45
 * Description: No Description
 */
@WebServlet(name = "CheckCode ",urlPatterns = "/checkCode")
public class CheckCode extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            login(request, response);
        }else if("register".equals(action)){
            register(request, response);
        }else if("logout".equals(action)){
            logout(request, response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证验证码
        boolean yanzhengma = yanzhengma(request, response);
        if (yanzhengma) {
            String username = request.getParameter("username");
            User user = userService.findOne(username);
            //用户不存在
            if (user == null) {
                String s1 = "用户名或密码错误！";
                response.getWriter().print(s1);
                //用户存在
            } else {
                //密码正确
                String password = request.getParameter("password");
                if (user.getPassword().equals(JiaMi.base64Encode(password))) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    response.getWriter().print("登陆成功！");
                    //密码错误
                } else {
                    String s2 = "用户名或密码错误！";
                    response.getWriter().print(s2);
                }
            }
            //验证码输入错误
        } else {
            String str = "验证码输入有误";
            response.getWriter().print(str);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证验证码
        boolean yanzhengma = yanzhengma(request, response);
        //验证码正确
        if(yanzhengma){
            String userName = request.getParameter("username");
            //先判断用户名是否已被注册
            User one = userService.findOne(userName);
            if(one!=null){
                response.getWriter().print("该用户已被注册！");
            }else{
                String password = request.getParameter("password");
                String rePassWord = request.getParameter("repassword");
                String tel = request.getParameter("tel");
                String college = request.getParameter("college");
                //正则判断用户名是否含汉字;
                Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher matcher = pattern.matcher(userName);
                boolean isMatch = matcher.find();
                //判断密码是否小于六位
                int passwordLength = password.length();
                //判断两次密码输入是否一致
                boolean equals = password.equals(rePassWord);
                //判断输入手机号位数是否正确
                int telLength = tel.length();
                String pattern2 = "^[0-9]*[1-9][0-9]*$";
                boolean isMatch2 = Pattern.matches(pattern2, tel);
                if(isMatch){
                    response.getWriter().print("用户名不可以包含汉字！");
                }else if(passwordLength<6){
                    response.getWriter().print("密码不可以小于六位！");
                }else if(!equals){
                    response.getWriter().print("两次密码输入不一致！");
                }else if(telLength<11&&(!isMatch2)){
                    response.getWriter().print("手机号格式不正确！");
                }else{
                    User user = new User(userName,password,tel,college);
                    int i = userService.add(user);
                    if(i!=0){
                        response.getWriter().print("注册成功！");
                    }
                }
            }
        } //验证码错误
        else {
            String str="验证码输入有误";
            response.getWriter().print(str);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        response.sendRedirect("foreground/login.jsp");
    }

    public boolean yanzhengma(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            if (code.equalsIgnoreCase(sessionCode)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

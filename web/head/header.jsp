<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/8
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="<%=request.getContextPath()%>/index.jsp">蓝色火焰</a></li>
                <li>|</li>
                <li><a href="http://www.tesiro.com/" target="_blank">王后系列</a></li>
                <li>|</li>
                <li><a href="http://www.darryring.com" target="_blank">DR求婚钻戒</a></li>
                <li>|</li>
                <li><a href="http://www.tiffany.com">香港-铜锣湾店</a></li>
                <li>|</li>
                <li><a href="https://www.chanel.com/zh_CN">香奈儿</a></li>
                <li>|</li>
                <li><a href="">为下一代珍藏</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <c:if test="${sessionScope.username==null}">
                <div class="fr">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/foreground/login.jsp">登录</a></li>
                        <li>|</li>
                        <li><a href="<%=request.getContextPath()%>/foreground/register.jsp">注册</a></li>
                        <li>|</li>
                        <div class="gouwuche fr"><a href="<%=request.getContextPath()%>/foreground/login.jsp">购物车</a></div>
                    </ul>
                </div>
            </c:if>
            <c:if test="${sessionScope.username!=null}">
                <div class="fr">
                    <ul>
                        <li>欢迎您！&nbsp;${sessionScope.username}</li>
                        <li>|</li>
                        <li><a href="<%=request.getContextPath()%>/UserServlet?action=findOne&username=${sessionScope.username}">个人中心</a></li>
                        <li>|</li>
                        <li><a href="<%=request.getContextPath()%>/checkCode?action=logout">退出</a></li>
                        <li>|</li>
                        <div class="gouwuche fr"><a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=findAll">购物车</a></div>
                    </ul>
                </div>
            </c:if>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!-- start banner_x -->
<div class="banner_x center">
    <a href="<%=request.getContextPath()%>/index.jsp"><div class="logo fl"></div></a>
    <%--<a href=""><div class="ad_top fl"></div></a>--%>
    <div class="nav fl">
        <ul>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">DR</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">求婚钻戒</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">结婚对戒</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">真爱礼物</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">钻戒定制</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">真爱体验店</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">DR 品牌文化</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">探索DR</a></li>
            <li><a href="<%=request.getContextPath()%>/foreground/liebiao.jsp">真爱承诺</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"id="sousuo"  placeholder="&nbsp真爱礼物&nbsp&nbsp;&nbsp浪漫女士&nbsp尊贵男士">
            </div>
            <div class="submit fl">
                <input  onclick="search()" type="button"  class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<script>
    function search() {
        var title=document.getElementById("sousuo").value;
        location.href="ershouServlet?action=search&title="+title;
    }
</script>
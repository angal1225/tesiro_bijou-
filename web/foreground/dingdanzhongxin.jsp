<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/8
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>通灵珠宝-个人中心</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
</head>
<body>
<!-- start header -->
<jsp:include page="../head/header.jsp"></jsp:include>
<!--end header -->

<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/UserServlet?action=findOne&username=${sessionScope.username}">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">我的上架</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">交易订单</div>
            <div class="ddxq">
                <div class="ddspt fl"><img src="/image/gwc_xiaomi6.jpg" alt=""></div>
                <div class="ddbh fl">订单号:1705205643098724</div>
                <div class="ztxx fr">
                    <ul>
                        <li>已发货</li>
                        <li>￥2499.00</li>
                        <li>2017/05/20 13:30</li>
                        <li><a href="">订单详情></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="ddxq">
                <div class="ddspt fl"><img src="/image/liebiao_hongmin4_dd.jpg" alt=""></div>
                <div class="ddbh fl">订单号:170526435444865</div>
                <div class="ztxx fr">
                    <ul>
                        <li>已发货</li>
                        <li>￥1999.00</li>
                        <li>2017/05/26 14:02</li>
                        <li><a href="">订单详情></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>

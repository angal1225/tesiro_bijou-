<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米商城-个人中心</title>
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
            <div class="ddzx">出售物品</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/foreground/dingdanzhongxin.jsp" >我的订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/foreground/self_info.jsp" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">优惠券</a></li>
                    <li><a href="">我的上架</a></li>
                    <li><a href="">收货地址</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">我的上架</div>
            <c:forEach items="${sessionScope.oneSaleList}" var="list">
                <div class="ddxq">
                    <div class="ddspt fl"><img src="/image/${list.image}" alt=""></div>
                    <div class="ddbh fl">${list.title}</div>
                    <div class="ztxx fr">
                        <ul>
                            <li>${list.deal}</li>
                            <li>${list.price}</li>
                            <li>${list.date}</li>
                            <li><a href="#">订单详情></a></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
    </div>
</div>
<!-- self_info -->

<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>

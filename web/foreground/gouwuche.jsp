<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/8
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的购物车-通灵珠宝</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/image/logo.png" type="image/x-icon" />
</head>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="../index.jsp"><div class="logo fl"></div></a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li style="font-family: 'Microsoft YaHei UI';font-size: 15px">欢迎&nbsp;${sessionScope.username}&nbsp;来到购物车界面</li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>

<div class="gwcxqbj">
    <div class="gwcxd center">
        <table>
            <tr>
                <div class="top2 center">
                    <div class="sub_top fl">
                        商品缩略图
                    </div>
                    <div class="sub_top fl">商品名称</div>
                    <div class="sub_top fl">价格</div>
                    <div class="sub_top fl">数量</div>
                    <div class="sub_top fl">小计</div>
                    <div class="sub_top fr">操作</div>
                    <div class="clear"></div>
                </div>
            </tr>

        <tr>
            <c:if test="${size!=0}">
                <c:forEach items="${sessionScope.shoppingCartList}" var="list">
                    <input hidden="hidden" id="erShouId" type="text" value="${list.id}">
                    <div class="content2 center">
                        <div class="sub_content fl ">
                        </div>
                        <div class="sub_content fl"><img src="../image/${list.image}" height="50" width="50;" style="line-height: 50px"></div>
                        <div class="sub_content fl ft20">${list.title}</div>
                        <div class="sub_content fl ">&nbsp;&nbsp;&nbsp;&nbsp;${list.price}元</div>
                        <div class="sub_content fl ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</div>
                        <div class="sub_content fl ">&nbsp;&nbsp;${list.price}元</div>
                        <div class="sub_content fl"><a onclick="deleteOne()" href="">×</a></div>
                        <div class="clear"></div>
                    </div>
                </c:forEach>
            </c:if>
        </tr>
        <c:if test="${size==0}">
            <script>
                $.sendWarning('购物车为空!', 3000, function() {
                    console.log('sendWarning closed');
                });
            </script>
        </c:if>
        </table>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="<%=request.getContextPath()%>/index.jsp">继续购物</a></li>
                <li>|</li>
                <li>共<span>${sessionScope.shoppingCartList.size()}</span>件商品</li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">合计（不含运费）：<span>${sessionScope.sum}元</span></div>
            <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<!-- footer -->
<jsp:include page="../footer/footer.jsp"></jsp:include>
<script>
    function deleteOne() {
        var id=document.getElementById("erShouId").value;
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/ShoppingCartServlet",
            data:{
                "action":"deleteOne",
                "id":id
            },
            dateType:"text",
            success:function (msg) {
                if(msg==="删除成功!"){
                    $.sendSuccess(msg, 3000, function() {
                        console.log('sendSuccess closed');
                    });
                    window.setTimeout("window.location.reload()",3000);
                }
            }
        });
    }
</script>
</body>
</html>


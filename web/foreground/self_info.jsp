<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<%@ include file="../background/commons/info.jsp"%>
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
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/foreground/dingdanzhongxin.jsp" >我的订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/UserServlet?action=findOne&username=${sessionScope.username}" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="/ershouServlet?action=findOneSale&username=${sessionScope.username}">我的上架</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">我的资料</div>
            <div class="subgrzl ml40"><span>昵称</span><span id="username">${user.userName}</span></div>
            <div class="subgrzl ml40"><span>手机号</span><span id="phone">${user.phone}</span></div>
            <div class="subgrzl ml40"><span>密码</span><span id="password">${user.password}</span></div>
            <div class="subgrzl ml40"><span>收货地址</span><span id="addr">${user.addr}</span></div>
            <div style="text-align:center">
                <button onclick="edit()" style="width: 400px;height: 50px;border-radius: 10px;background:lightcyan;">编辑个人资料</button>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->

<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<script>
    function edit() {
        var username=document.getElementById("username").innerHTML;
        var phone=document.getElementById("phone").innerHTML;
        var password=document.getElementById("password").innerHTML;
        var addr=document.getElementById("addr").innerHTML;
        var user = {
            username:username,
            phone: phone,
            password: password,
            addr: addr,
        };
        layer.open({
            title: this.text,
            type: 2,
            skin: 'layui-layer-rim', //加上边框
            area: [window.screen.width / 1.5 + 'px', window.screen.height / 1.5 + 'px'], //宽高
            maxmin: true, //开启最大化最小化按钮
            content: "<%=request.getContextPath()%>/foreground/editPersonalInfo.jsp",
            success: function (layero, index) {
                // 获取子页面的iframe
                var iframe = window['layui-layer-iframe' + index];
                // 向子页面的全局函数child传参
                iframe.child(user);
            }
        })
    }
</script>
</html>

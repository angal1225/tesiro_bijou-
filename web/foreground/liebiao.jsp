<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米手机列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
</head>
<body>
<!-- start header -->
<jsp:include page="../head/header.jsp"></jsp:include>
<!--end header -->


<!-- start banner_y -->
<!-- end banner -->

<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">${title}</div>
    <div class="main center">
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../image/liebiao_xiaomi5.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">小米手机5</a></div>
            <div class="youhui">骁龙820处理器 / UFS 2.0 闪存</div>
            <div class="jiage">1799.00元</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../image/liebiao_hongmin4.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">红米Note 4</a></div>
            <div class="youhui">十核旗舰处理器 / 全金属一体化机身 </div>
            <div class="jiage">1399.00元</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../image/pinpai3.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米手机5 64GB</a></div>
            <div class="youhui">5月9日-10日，下单立减100元</div>
            <div class="jiage">1799元</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../image/liebiao_hongmin42.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">红米4</a></div>
            <div class="youhui">2.5D 玻璃，金属一体化机身</div>
            <div class="jiage">999.00元</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../image/liebiao_hongmin4x.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">红米Note 4X 全网通版</a></div>
            <div class="youhui">多彩金属 / 4100mAh 超长续航</div>
            <div class="jiage">1299.00元</div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<jsp:include page="../footer/footer.jsp"></jsp:include>

</body>
</html>

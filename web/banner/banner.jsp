<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/7
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jQuery</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/shutter.css">

</head>
<body>

<div class="shutter">
    <div class="shutter-img">
        <a href="#" data-shutter-title="唐嫣倾情代言"><img src="<%=request.getContextPath()%>/image/banner.jpg" alt="#"></a>
        <a href="#" data-shutter-title="小米Nova2双曲面商务旗舰"><img src="<%=request.getContextPath()%>/image/banner3.jpg" alt="#"></a>
        <a href="#" data-shutter-title="小米6 变焦双摄，拍人更美"><img src="<%=request.getContextPath()%>/image/banner2.jpg" alt="#"></a>
        <a href="#" data-shutter-title="让每一次出游变成一种期待"><img src="<%=request.getContextPath()%>/image/pinghengche.jpg" alt="#"></a>
        <a href="#" data-shutter-title="让每一次出游变成一种期待"><img src="<%=request.getContextPath()%>/image/login_bg.jpg" alt="#"></a>
    </div>
    <ul class="shutter-btn">
        <li class="prev"></li>
        <li class="next"></li>
    </ul>
    <div class="shutter-desc">
        <p>Iron Man</p>
    </div>
</div>

<script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/velocity.js"></script>
<script src="<%=request.getContextPath()%>/static/js/shutter.js"></script>
<script>
    $(function () {
        $('.shutter').shutter({
            shutterW: 1226, // 容器宽度
            shutterH: 440, // 容器高度
            isAutoPlay: true, // 是否自动播放
            playInterval: 4000, // 自动播放时间
            curDisplay: 1, // 当前显示页
            fullPage: false // 是否全屏展示
        });
    });
</script>
</body>
</html>
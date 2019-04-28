<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../background/commons/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米6立即购买-小米商城</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
</head>
<body>
<!-- start header -->
<jsp:include page="../head/header.jsp"/>
<!--end header -->

<!-- xiangqing -->
    <div class="xiangqing">
        <div class="neirong w">
            <div class="xiaomi6 fl"><button onclick="goBack()" style="height: 30px">返回搜索列表</button>&nbsp;&nbsp;&nbsp;${ershouwupin.title}</div>
            <div class="clear"></div>
        </div>
    </div>
    <input hidden="hidden" id="ershouwupin_id" value="${ershouwupin.id}">
    <div class="jieshao mt20 w">
        <div class="left fl"><img src="./image/${ershouwupin.image}"></div>
        <div class="right fr">
            <div class="h3 ml20 mt20">${ershouwupin.title}</div>
            <div class="jianjie mr40 ml20 mt10">${ershouwupin.introduce}</div>
            <div class="ft20 ml20 mt20">交易方式</div>
            <div class="xzbb ml20 mt10">
                &nbsp;${ershouwupin.deal}
                <div class="clear"></div>
            </div>
            <div class="ft20 ml20 mt20">交易地点</div>
            <div class="xzbb ml20 mt10">
                ${ershouwupin.where}
            </div>
            <div class="xqxq mt20 ml20">
                <div class="top1 mt10">
                    <div class="left1 fl">卖家&nbsp;&nbsp;&nbsp;&nbsp;${ershouwupin.sellUser}</div>
                    <div class="right1 fr">上架时间:${ershouwupin.date}</div>
                    <div class="clear"></div>
                </div>
                <div class="bot mt20 ft20 ftbc">价格：${ershouwupin.price}元</div>
            </div>
            <div class="xiadan ml20 mt20">
                <input onclick="buyImmediately()" class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <input onclick="tianjiagouwuche()" class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
            </div>
        </div>
        <div class="clear"></div>
    </div>
<br/>
<div class="neirong w">
    <div class="xiaomi6 fl" style="font-size: 20px;font-family:'Microsoft YaHei UI'; color: #9F9F9F">会员留言</div>
    <div class="clear"></div>
    <div style="border-top: 1px dashed black" >
        <c:if test="${sessionScope.username==null}">
            <div style="color: red">留言请登录&nbsp;&nbsp;>>>> <a href="<%=request.getContextPath()%>/foreground/login.jsp">登录</a></div>
        </c:if>

        <c:if test="${sessionScope.username!=null}">
            <textarea wrap="virtual" maxlength="200" style="resize:none;width:90%;height: 100px;
       border:1px solid gray; margin: 10px 30px; padding: 10px;
       border-radius: 5px" id="comment_text"></textarea>
            <div>
                <input id="sendSuccessToTop"  style="float: right;margin: 10px;" type="button" class="btn btn-primary" value="提交"/>
            </div>
        </c:if>
        <div class="comment-list" style="clear: both">
            <ul class="list-group">
                <%--评论信息所属的商品id--%>
                <c:forEach items="${commentList}" var="comment">
                    <input hidden="hidden" id="commentId" value="${comment.id}">
                    <input hidden="hidden" type="text" id="username" value="${comment.user}">
                    <input hidden="hidden" type="text" id="date" value="${comment.date}" >
                    <li class="list-group-item" style='word-break: break-all;'><b>用户&nbsp;&nbsp;${comment.user}于&nbsp;&nbsp;[${comment.date}]:</b>${comment.comment}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="confirmWithCustom">举报</button>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<script>
    $(function() {
        var id=document.getElementById("ershouwupin_id").value;
        $("input[value=提交]").click(function () {
            var strContent = $("#comment_text").val();
            if(strContent.trim()==""){
                $.sendError('评论内容不能为空！', 3000, function() {
                    console.log('sendError closed');
                });
                return;
            }
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/CommentServlet",
                data:"action=add&id="+id+"&comment="+strContent,
                dataType:"text",
                success:function(msg){
                    if(msg==="评论成功!"){
                        //如果成功就评论一下
                        // 发送成功的提示框（置顶）
                        $.sendSuccessToTop('评论成功！', 3000, function() {
                            console.log('sendSuccessToTop closed');
                        });
                    }
                }
            })
        })
    })

    function goBack() {
        window.history.back(-1);
    }

    function buyImmediately() {
        location.href=""
    }

    function tianjiagouwuche() {
        var id=document.getElementById("ershouwupin_id").value;
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/ShoppingCartServlet",
            data:{
                "action":"addShoppingCart",
                "id":id
            },
            dateType:"text",
            success:function (msg) {
                if(msg==="请先登录!"){
                    $.sendConfirm({
                        hideHeader: true,
                        withIcon: 'withIconWarning',
                        desc:msg,
                        button: {
                            confirm: '关闭',
                            cancel: '去登陆',
                        },
                        onConfirm: function() {
                            console.log('点击确认！');
                        },
                        onCancel: function() {
                            top.location.href="foreground/login.jsp"
                        },
                        onClose: function() {
                            console.log('点击关闭！');
                        }
                    });

                }else if(msg==="添加成功!"){
                    $.sendSuccessToTop(msg, 3000, function() {
                        console.log('sendSuccessToTop closed');
                    });
                }else{
                    $.sendWarningToTop(msg, 3000, function() {
                        console.log('sendWarningToTop closed');
                    });
                }
            }
        });
    }

    $('.confirmWithCustom').click(function() {
        $.sendConfirm({
            title: '举报评论',
            content:"确认举报吗?一旦举报，该留言将进入黑名单，等待管理员大大审核",
            button: {
                confirm: '举报',
                cancel: '取消'
            },
            width: 260,
            onBeforeConfirm: function() {
                // onBeforeConfirm返回false，将阻止onConfirm的执行
                return true;
            },
            onConfirm: function(){
                var commentId=document.getElementById("commentId").value;
                var username=document.getElementById("username").value;
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/CommentServlet",
                    data:{
                        "action":"report",
                        "commentId":commentId,
                        "username":username
                    },
                    dataType:"text",
                    success:function(msg){
                        if(msg==="举报成功!"){
                            $.sendSuccessToTop(msg, 3000, function() {
                                console.log('sendSuccessToTop closed');
                            });
                        }else if(msg==="该用户已被举报多次,请稍后!"){
                            $.sendWarningToTop(msg, 3000, function() {
                                console.log('sendWarningToTop closed');
                            });
                        }
                    }
                })
            },
            onCancel: function() {
                console.log('点击取消！');
            },
            onClose: function() {
                console.log('点击关闭！');
            }
        });
    });
</script>
<!-- footer -->
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
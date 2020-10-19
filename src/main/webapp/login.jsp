<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

        //切换验证码
        function refreshCode() {
            //获取验证码图片对象
            var vcode = document.getElementById("vcode");
            //获取时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time"+new Date().getTime();
        }

    </script>

    <script type="text/javascript">
        //在页面加载完成后
        $(function () {
            //给username绑定blur事件
            $("#usercode").blur(function () {
                //获取user文本输入框的值
                var username = $(this).val();
                //发送ajax请求
                $.post("loginAjaxServlet", {username:username},function (data) {
                    //判断userExsit键的值是否为true
                    var span = $("#s_username");
                    if (data.userExsit){
                        //用户名存在
                        span.css("color","red");
                        span.html(data.msg);
                    }else{
                        //用户名不存
                        span.css("color","green");
                        span.html(data.msg);
                    }
                },"json")
            })
        })
    </script>


</head>
<body>


<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="usercode">用户名：</label>
            <input type="text" name="username" class="form-control" id="usercode" placeholder="请输入用户名"/>
            <span id="s_username"></span>
        </div>


        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${login_msg}</strong>
    </div>
</div>
</body>

</html>
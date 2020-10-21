<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户注册</title>

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

    <script>
        //校验用户名
        function checkUsername(){
            //1.获取用户名的值
            var username = $("#name").val();
            //2.定义正则
            var reg_username = /^\w{8,20}$/;
            //3.判断，给出提示信息
            var flag = reg_username.test(username);
            if (flag){
                //用户名合法
                $("#name").css("border","");
            }else{
                //用户名非法
                $("#name").css("border","1px solid red");
            }
            return flag;
        }
        //校验密码
        function checkPassword(){
            //1.获取用户名的值
            var password = $("#password").val();
            //2.定义正则
            var reg_password = /^\w{8,20}$/;
            //3.判断，给出提示信息
            var flag = reg_password.test(password);
            if (flag){
                //用户名合法
                $("#password").css("border","");
            }else{
                //用户名非法
                $("#password").css("border","1px solid red");
            }
            return flag;
        }
        //校验邮箱
        function checkEmail(){
            //1.获取对应的邮箱
            var email = $("#email").val();

            //2.定义正则
            var reg_email = /^\w+@\w+\.\w+$/

            //3.判断
            var flag = reg_email.test(email);
            if (flag){
                $("#email").css("border","");
            }else{
                $("#email").css("border","1px solid red");
            }
            return flag;
        }

        $(function () {
            //当表单提交时，调用所有的校验方法
            $("#registerForm").submit(function(){
                //1.发送数据到服务器
                if (checkUsername() && checkPassword() && checkEmail()){
                    //校验通过，发送ajax请求，提交表单数据
                    $.post("registUserServlet",$(this/*"#registerForm"*/).serialize(),function (data) {
                        //处理服务器响应的数据 data {flag:true,errorMsg:"注册失败"}

                        if (data.flag){
                            //注册成功，跳转成功页面
                            location.href="register_yes.html"
                        }else{
                            //注册失败，给errorMsg添加提示信息
                            $("#errorMsg").html(data.errorMsg);

                        }
                    })
                }
                //2.跳转页面

                return false;
                //如果方法有返回值或返回值为true，表单提交，返回值为false表单不提交

            })

            //当某一个组件失去焦点时，调用对应的校验方法
            $("#name").blur(checkUsername);
            $("#password").blur(checkPassword);
            $("#email").blur(checkEmail);
        })



    </script>

    <script type="text/javascript">
        //在页面加载完成后
        $(function () {
            //给username绑定blur事件
            $("#name").blur(function () {
                //获取user文本输入框的值
                var username = $(this).val();
                //发送ajax请求
                $.post("registerAjaxServlet", {username:username},function (data) {
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
    <h3 style="text-align: center;">用户注册</h3>
   <form action="${pageContext.request.contextPath}/registUserServlet" method="post" id="registerForm">
    <div class="form-group">
        <label for="name">用户名：</label>
        <input type="text" class="form-control" id="name" name="username" placeholder="请输入用名">
        <span id="s_username"></span>
    </div>



    <div class="form-group">
        <label for="password">密码：</label>
        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
    </div>
       <div class="form-group">
           <label for="age">年龄：</label>
           <input id="age" type="text" class="form-control" name="age" placeholder="请输入年龄"/>
       </div>
       <div class="form-group">
           <label for="email">Email：</label>
           <input id="email" type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
       </div>


       <div class="form-group">
           <label>性别：</label>
           <input type="radio" name="gender" value="男" checked="checked"/>男
           <input type="radio" name="gender" value="女"/>女
       </div>
       <div class="form-group">
           <label for="address">籍贯：</label>
           <select name="address" class="form-control" id="address">
               <option value="广东">广东</option>
               <option value="广西">广西</option>
               <option value="湖南">湖南</option>
           </select>
       </div>
       <div class="form-inline">
           <label for="vcode">验证码：</label>
           <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
           <a href="javascript:refreshCode()">
               <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
           </a>
       </div>


    <div class="form-group" style="text-align: center">
        <input class="btn btn-primary" type="submit" style="width: 373px;margin-top: 20px" value="注册" />

    </div>


    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong id="errorMsg">${login_msg}</strong>
    </div>
</div>
</body>

</html>
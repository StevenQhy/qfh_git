<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-14
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        #h{

            border-radius: 50%;
            width: 650px;
            height: 650px;
            position: relative;
            background-color: rgba(0,0,0,0.5);

        }
        #hhh{
            /*background-image: url(image/04.jpg) ;*/
            background-size:cover;
            background-repeat: no-repeat;
            border-radius: 50%;
            width: 630px;
            height: 630px;
            position: relative;
            background-color: rgba(180,180,180,0.2);
            margin-left: 10px;
            margin-top: 10px;
        }
        #hh{
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            /*align-items: center;*/
            /*background-image: url(image/05.jpg) ;*/
            background-size: cover;
            padding-top: 100px;
        }
        #hhhh{
            font-family: 楷体;
            padding-right: 0px;
            font-size: 19px;

            margin-left: 19%;
        }
        #hhhh1{
            font-family: 楷体;
            margin-left: 18%;
            font-size: 19px;
        }
        #xingming{
            font-family: 楷体;
            margin-left: 18%;
            font-size: 19px;
            margin-top: 20px;

        }
        #address{

            font-family: 楷体;
            margin-left: 18%;
            font-size: 19px;
            margin-top: 20px;

        }
        #ucode{
            font-family: 楷体;
            margin-left: 21%;
            font-size: 19px;
            margin-top: 20px;

        }
        #ff{
            width: 600px;
            height: 600px;
            position: absolute;
            width: 90%;
            margin-left: 5%;
            height: 90%;
            margin-top: 5%;

            border-radius: 50%;

            background-color: rgba(255,255,255,0.3);


        }
        #span{
            height:20px;
            font-size: 18px;
            font-family: 华文楷体;
            font-weight: bolder;
            margin-left: 25%;
        }
        *{
            margin: 0px;
            padding: 0px;
        }
        video{
            position: fixed;
            right: 0px;
            bottom: 0px;
            min-width: 100%;
            min-height: 100%;
            height: auto;
            width: auto;
            /*加滤镜*/
            /*filter: blur(15px); //背景模糊设置 */
            /*-webkit-filter: grayscale(100%);*/
            /*filter:grayscale(100%); //背景灰度设置*/
            z-index:-11
        }
        source{
            min-width: 100%;
            min-height: 100%;
            height: auto;
            width: auto;
        }

    </style>

    <title>Title</title>
    <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="resources/bootstrap-3.3.7-dist/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">


    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <%--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>


</head>

<body>
<video id="v1" autoplay loop muted>
    <source src="image/登录2.mp4" type="video/mp4"  />
</video>

<script>
    var video= document.getElementById(v1);
    video.playbackRate = 0.5;

</script>
<%--<form action="/toReg" method="post">用户名:<input type="text"name="username">--%>
<%--<input type="submit" value="登录">--%>
<%--</form>--%>

<div id="hh">
    <div id="h">
    <div id="hhh">
        <div id="ff"><h2 style="text-align: center;font-family: 隶书 ;margin-top: 35px">注册</h2>

            <form class="form-horizontal" style="width: 100%;height: 100%">
                <div class="form-group" style="margin-top: -15px">
                    <label for="d1" class="col-sm-2 control-label" id="hhhh">用户名:</label>
                    <div class="col-sm-10">
                        <input type="text" name="username" class="form-control" id="d1" placeholder="Username"
                               style="width: 70%;margin-left: 120px;border-radius: 15px;background-color: rgba(255,255,255,0.5) ">
                        <div id="span"><span id="sp"></span></div>

                    </div>

                </div>
                <div class="form-group" style="margin-top: -60px">
                    <label for="inputPassword3" class="col-sm-2 control-label" id="hhhh1">密码:</label>
                    <div class="col-sm-10">
                        <input type="password" name="pwd" class="form-control" id="inputPassword3"
                               placeholder="Password" style="width:70%;margin-left: 120px;border-radius: 15px;background-color: rgba(255,255,255,0.5)">
                    </div>
                </div>
                <div class="form-group" style="margin-top: -60px">
                    <label for="inputPassword3" class="col-sm-2 control-label" id="xingming">姓名:</label>
                    <div class="col-sm-10">
                        <input type="text" name="xingming" class="form-control" id="xm"
                               placeholder="Name" style="width:70%;margin-left: 120px;border-radius: 15px;background-color: rgba(255,255,255,0.5)">
                    </div>
                </div>
                <div class="form-group" style="margin-top: -60px">
                    <label for="inputPassword3" class="col-sm-2 control-label" id="address">地址:</label>
                    <div class="col-sm-10">
                        <input type="text" name="address" class="form-control" id="dz"
                               placeholder="Address" style="width:70%;margin-left: 120px;border-radius: 15px;background-color: rgba(255,255,255,0.5)">
                    </div>
                </div>
                <div class="form-group" style="margin-top: -60px">
                    <label for="inputPassword3" class="col-sm-2 control-label" id="ucode"style="width: 60%;margin-left: -116px">上级编号:</label>
                    <div class="col-sm-10">
<%--                        <input type="text" name="ucode" class="form-control" id="inputPassword6"--%>
<%--                               placeholder="Ucode" style="width:70%;margin-left: 120px">--%>
                    <select class="form-control" data-style="btn-info" style="width:70%;margin-left: 120px;border-radius: 15px;background-color: rgba(255,255,255,0.5)" name="ucode"id="sjzh">
                        <option selected disabled style="background:gainsboro">&nbsp;&nbsp;请选择</option>
                    <option style="background-color:lightgray">1</option>
                    <option style="background-color:lightgray">2</option>
                    <option style="background:lightgrey">3</option>
                    </select>
                    </div>

                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-success " style="margin-left: 28%;width: 100px;margin-top: 25px;border-radius: 15px;background-color: rgba(0,255,153,0.4);color: #bce8f1" id="btn">
                            注册
                        </button>

                    </div>
                </div><div ><u ><a style="margin-left: 238px;color: #bce8f1" href="loginfc.jsp">已注册,去登录</a></u></div>
            </form>

        </div>
    </div>
</div>
</div>
</body>
<script>
    $("#d1").blur(function () {
        //获取用户输入框的值
        var username = $("#d1").val();
        // if (name==null||name==""){
        //     alert("用户名不能为空");
        //     return;
        // }
        // $.post("/checkUserName","username="+name,function (data) {
        //  alert(data)
        // });

        $.ajax({
            "url": "/checkUserName",//请求路径
            "data": {"username": username},//我们发什么数据给服务端(servlet)
            "type": "post",//请求类型
            "dataType": "text",//服务端返回数据类型
            // "content-Type":"application/x-www-form-urlencoded",
            "success": function (data) {//封装服务端返回的数据
//可以暂时不写,要后端传回json数据才能用
                if (data.match("该用户名已被注册,请重试!!!") || data.match("用户名不能为空")) {
                    $("#sp").html(data);
                    $("#sp").css({

                        'color': 'red'

                    });
                } else {
                    $("#sp").html(data)
                    $("#sp").css({

                        'color': 'green'


                    });

                }

            }
        });

    });
    $("#btn").click(function () {
        var pwd = $("#inputPassword3").val();
        var username = $("#d1").val();
        var name=$("#xm").val();
        var address=$("#dz").val();
        var ucode=$("#sjzh").val();

        $.post("/toReg", {"username": username, "pwd": pwd,"name":name,"address":address,"ucode":ucode}, function (data) {
                if (data == 12) {
                    alert("此姓名已存在,注册失败")
                    location.reload(true)
                    window.location.href = "registerfc.jsp";

                } else {
                    if (data == 11) {
                        alert("注册名或密码不能为空");
                        location.reload(true)

                    }
                    if (data == 13) {
                        alert(username);
                        window.location.href = "loginfc.jsp";

                    }
                    if (data == 14) {
                        alert("////////////////")
                    }
                }


            }
        )


    });

</script>
</html>

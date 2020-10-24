<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-15
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>登录</title>
    <style>
        #h{

            border-radius: 50%;
            width: 550px;
            height: 550px;
            position: relative;
            background-color: rgba(0,0,0,0.5);

        }
        #hhh{
            /*background-image: url(image/04.jpg) ;*/
            background-size:cover;
            background-repeat: no-repeat;
border-radius: 50%;
            width: 530px;
            height: 530px;
            position: relative;
            background-color: rgba(100,100,100,0.5);
            margin-top: 10px;
            margin-left: 10px;
        }
        #hh{
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            /*align-items: center;*/
            /*background-image: url(image/05.jpg) ;*/
            background-size: cover;
            padding-top: 170px;
        }
        #hhhh{
            font-family: 楷体;
            padding-right: 0px;
            font-size: 19px;

          margin-left: 20%;
        }
        #hhhh1{
            font-family: 楷体;
            margin-left: 20%;
            font-size: 19px;
        }
        #ff{
            width: 500px;
            height: 500px;
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
</head>
<body>
<video id="v1" autoplay loop muted>
    <source src="image/登录3.mp4" type="video/mp4"  />
</video>

<script>
    var video= document.getElementById(v1);
    video.playbackRate = 1.5;

</script>


<div id="hh"  >
    <div id="h">
    <div id="hhh">
        <div id="ff" > <h2 style="text-align: center;font-family: 隶书 ;margin-top: 50px">登录</h2>

            <form class="form-horizontal" action="/logincheck"method="post" style="width: 100%;height: 100%" >
                <div class="form-group" style="margin-top:30px">
                    <label for="d1" class="col-sm-2 control-label" id="hhhh">用户名:</label>
                       <div class="col-sm-10">
                        <input type="text" name="username" class="form-control" id="d1" placeholder="Username"style="width: 70%;margin-left: 100px;border-radius: 15px;background-color: rgba(255,255,255,0.5)">
                        <div id="span"><span id="sp"></span></div>

                    </div>

                </div>
                <div class="form-group"style="margin-top: 25px">
                    <label for="hhhh1" class="col-sm-2 control-label"id="hhhh1" >密码:</label>
                    <div class="col-sm-10">
                        <input type="password"name="pwd" class="form-control" id="inputPassword3" placeholder="Password"  style="width:70%;margin-left: 100px;border-radius: 15px;background-color: rgba(255,255,255,0.5)">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label style=" margin-left: 21%;font-weight: bolder ;font-size:16px;text-align: center">
                                <span style="color: red" >${msg}</span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success" style="margin-left: 27%;width: 100px;;border-radius: 15px;background-color: rgba(0,255,153,0.4);color: #bce8f1 ">登录</button>
                    </div>
                </div><div style="margin-left: 160px"> <u ><a style="margin-left: 50px;color: #bce8f1" href="registerfc.jsp">点击注册</a></u></div>

            </form>
        </div>
    </div>
    </div>
</div>
</body>
<script>
    $("#d1").blur(function () {
        //获取用户输入框的值
        var name = $("#d1").val();
        // if (name==null||name==""){
        //     alert("用户名不能为空");
        //     return;
        // }
        // $.post("/checkUserName","username="+name,function (data) {
        //  alert(data)
        // });

        $.ajax({
            "url":"/logcheckname",//请求路径
            "data":{"username":username},//我们发什么数据给服务端(servlet)
            "type":"post",//请求类型
            "dataType":"text",//服务端返回数据类型
            // "content-Type":"application/x-www-form-urlencoded",
            "success":function (data) {//封装服务端返回的数据
//可以暂时不写,要后端传回json数据才能用

                    $("#sp").html(data)
                    $("#sp").css({

                        'color':'red'


                    });



            }
        });

    });
</script>
</html>

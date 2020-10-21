<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-15
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>主界面</title>
    <link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="resources/bootstrap-3.3.7-dist/js/jquery-1.9.1.min.js"></script>
    <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>

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

        /*#body {*/
        /*    !*background-image: url(image/09.jpg);*!*/
        /*    background-size: cover;*/
        /*    height: 1260px;*/
        /*    width: 100%;*/
        /*    margin-top: -20px;*/

        /*}*/

        /*#body1 {*/
        /*    position: absolute;*/
        /*    background-color: rgba(255, 255, 255, 0.1);*/
        /*    height: 1260px;*/
        /*    width: 100%;*/
        /*}*/


        #mouse:hover {
            cursor: pointer;
            color: #2aabd2;
        }

        #mouse1:hover {
            cursor: pointer;
            color: #2aabd2;
        }

        #mouse2:hover {
            cursor: pointer;
            color: #2aabd2;
        }

        #mouse3:hover {
            cursor: pointer;
            color: #2aabd2;
        }

        .table-hover>tbody>tr:hover {
            background-color: #66afe9!important;}

    </style>

</head>
<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>


<body>


<video id="v1" autoplay loop muted>
    <source src="image/我的影片.mp4" type="video/mp4"  />
</video>

<script>
    var video= document.getElementById(v1);
    video.playbackRate = 1.5;

</script>

<script>
    L2Dwidget.init({
        "model": {
            jsonPath:  "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",<!--这里改模型，前面后面都要改-->
            "scale": 1
        },
        "display": {
            "position": "right",<!--设置看板娘的上下左右位置-->
            "width": 200,
            "height":400,
            "hOffset": 0,
            "vOffset":-40,
        },
        "mobile": {
            "show": true,
            "scale": 0.5
        },
        "react": {
            "opacityDefault": 0.9,<!--设置透明度-->
            "opacityOnHover": 0.2
        }
    });
</script>


<div>
    <img src="image/首页导航.jpg" class="img-responsive" style="width: 100%;height: 22vh">
</div>

<nav class="navbar navbar-default navbar-static-top navbar-inverse ">
    <div class="navbar-header ">

        <img class="img-circle" width="34px" height="34px" style="margin-top: 8px ;margin-left: 20px;margin-right:26px"
             src="image/hebiaozhi.jpg">

    </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav ">
                <li>
                    <a href="/findAllWeapons" class="navbar-brand" >核武库</a>
                </li>
                <li ><a href="/toBaiKe">官方文档<span class="sr-only">(current)</span></a></li>
                <li><a href="#">海基导弹</a></li>
                <li><a href="#">空基导弹</a></li>


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">导弹一览 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>

                    </ul>
                </li>
                <li><span class="glyphicon glyphicon-search" style="color:white;margin-top: 18px ;margin-left: 200px"></span></li>
            </ul>
            <form class="navbar-form navbar-left"style="margin-left: 20px" action="http://www.baidu.com/s" method="GET" target="_blank">
                <div class="form-group">
                    <input type="text" name="wd" class="form-control" placeholder=" 东风-41B......">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right" >

                <li><a href="login.jsp">登录</a></li>

                <li><a href="register.jsp">注册</a></li>
                <li><a href="#">${msg}</a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span></a></li>

                <li class="dropdown" style="margin-right: 40px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><span class="glyphicon glyphicon-cog"></span> <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">用户设置</a></li>
                        <li><a href="#">界面设置</a></li>
                        <li><a href="#">其他设置</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">修改密码</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div id=body>
    <div id="body1">
        <div>
            <ul class="nav nav-tabs   nav-stacked" style="width: 5%">
                <li role="presentation" class="active"><a id="mouse" href="#"><span
                        class="glyphicon glyphicon-home"></span>&nbsp;主页</a></li>
                <li role="presentation" class="active"><a id="mouse1" href="#"><span
                        class="glyphicon glyphicon-th-list"></span>&nbsp;分类</a></li>
                <li role="presentation" class="active"><a id="mouse2" href="#"><span
                        class="glyphicon glyphicon-align-left" aria-hidden="true"></span>&nbsp;更多</a></li>
                <li role="presentation" class="active"><a id="mouse3" href="#"> <span
                        class="glyphicon glyphicon-send"></span>&nbsp;联系</a></li>

            </ul>


        <nav aria-label="...">
            <ul class="pager">
                <li><a href="#">Previous</a></li>
                <li><a href="#">Next</a></li>
            </ul>
        </nav>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>


        </nav>
    </div>

</div>


</body>
<script>
    function findWeaponByWeaponId(weaponid) {
       alert(weaponid);
       $.get("/findWeaponForUoDateWeaponById",{"id":weaponid},function (data) {
           //返回json数据格式

       });

    }
</script>
</html>

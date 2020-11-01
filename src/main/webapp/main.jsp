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
    <script src="js/L2Dwidget.0.min.js"></script>
    <script src="js/L2Dwidget.min.js"></script>
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
<script src="js/L2Dwidget.0.min.js"></script>
<script src="js/L2Dwidget.min.js"></script>


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
            jsonPath:  "https://unpkg.com/live2d-widget-model-haruto@1.0.5/assets/haruto.model.json",<!--这里改模型，前面后面都要改-->
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

<div class="modal fade"  id="modify" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color: rgba(100,0,0,0.7);margin-top: 200px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"name="exampleModalLabel" style="color: white">修改信息</h4>
            </div>            <form action="/modifyMessage"method="post">
            <div class="modal-body">


                <div class="form-group">
                    <label for="xingming"class="control-label"style="color: white">姓名:</label>
                    <input type="text" class="form-control" name="xingming"id="xingming">
                </div>
                <div class="form-group">
                    <label for="pwd" class="control-label"style="color: white">密码:</label>
                    <input type="text" class="form-control" name="pwd" id="pwd">
                    <div class="form-group">
                        <label for="address" class="control-label"style="color: white">地址:</label>
                        <input type="text" class="form-control" name="address" id="address">
                    </div>
                    <div class="form-group">
                        <label for="ucode" class="control-label"style="color: white">上级编号:</label>
                        <input type="text" class="form-control"name="ucode"id="ucode">
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button class="btn btn-primary" type="submit">确认</button>
            </div></form>
        </div>
    </div>
</div>

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
                    <a href="/findAllWeapons?currentPage=1" class="navbar-brand" >核武库</a>
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

                <li><a href="loginfc.jsp">登录</a></li>

                <li><a href="registerfc.jsp">注册</a></li>
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
                        <li><a href="login.jsp">管理员入口</a></li>
                        <li role="separator" class="divider"></li>
                        <li  ><a href="#"class="btn " data-toggle="modal" data-target="#modify" data-whatever="@mdo onclick="onclick=" findUserByUsername('${username}')"style="background: rgba(0,0,0,0)" ><span style="margin-left: -50%">修改信息</span></a></li>
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


            <div style="width: 70%;margin-left: 15%;margin-top: -150px">
            <div class="row">
                <div class="col-sm-6 col-md-3"style="float: left;width: 25%">
                    <div class="thumbnail"style="height: 375px;background-color: rgba(255,255,255,0.7)">
                        <img src="image/08.jpg" alt="..."style="height: 40%;width: 100%">
                        <div class="caption">
                            <h3>我国第一颗原子弹的诞生</h3>
                            <p>在中共中央统一领导下，经过一大批科技人员、干部和职工的共同努力，中国自行制造的第一颗原子弹于1964年10月16日在新疆罗布泊爆炸成功。1955年，中央指定陈云、聂荣臻、薄一波负责筹建.........</p>
                            <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3"style="float: left;width: 25%">
                    <div class="thumbnail"style="height: 375px;background-color: rgba(255,255,255,0.7)">
                        <img src="image/02.jpg" alt="..."style="height: 40%;width: 100%">
                        <div class="caption">
                            <h3>两弹元勋邓稼先</h3>
                            <p>邓稼先（1924年6月25日—1986年7月29日），九三学社社员，中国科学院院士，著名核物理学家，中国核武器研制工作的开拓者和奠基者，为中国核武器、原子武器的研发做出了重要贡献。 .......</p>
                            <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4"style="float: left;width: 25%">
                    <div class="thumbnail"style="height: 375px;background-color: rgba(255,255,255,0.7)">
                        <img src="image/03.jpg" alt="..."style="height: 40%;width: 100%">
                        <div class="caption">
                            <h3>东风导弹的前世今生</h3>
                            <p>20世纪90年代初，沃维汉结识了大陆导弹技术专家郭万钧，并以金钱将其收买。郭万钧参与了东风31战略导弹的设计。他见钱眼开，利令智昏。上世纪90年代中后期至本世纪初，郭万钧一步步陷入深渊，.......</p>
                            <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                        </div>
                    </div>
                </div>


                <div class="col-sm-6 col-md-4"style="float: left;width: 25%">
                    <div class="thumbnail"style="height: 375px;background-color: rgba(255,255,255,0.7)">
                        <img src="image/17.jpg" alt="..."style="height: 40%;width: 100%">
                        <div class="caption">
                            <h3>直击切尔诺贝利</h3>
                            <p>切尔诺贝利核事故（乌克兰语Чорнобильськая катастрофа）或简称“切尔诺贝利事件”，是一件发生在苏联统治下乌克兰境内切尔诺贝利核电站的核子反应堆事故。该事故被认为是历史上最严重的核.........</p>
                            <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                        </div>
                    </div>
                </div>
            </div>

                    </div>

            <div style="width: 70%;margin-left: 15%">
                <div class="row">
                    <div class="col-sm-6 col-md-4"style="float: left;width: 20%">
                        <div class="thumbnail"style="height: 300px;background-color: rgba(255,255,255,0.7)">
                            <img src="image/05.jpg" alt="..."style="height: 40%;width: 100%">
                            <div class="caption">
                                <h3>罗布泊往事</h3>
                                <p>罗布泊（Lop Nor），中国新疆维吾尔自治区东南部湖泊，由于形状宛如人耳，被誉为“地球之......</p>
                                <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4"style="float: left;width: 20%">
                        <div class="thumbnail"style="height: 300px;background-color: rgba(255,255,255,0.7)">
                            <img src="image/06.jpg" alt="..."style="height: 40%;width: 100%">
                            <div class="caption">
                                <h3>寻找404</h3>
                                <p>在404，每天都有风。 风沙大了，我们就得戴安全帽出门，因为直径三四厘米的........</p>
                                <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4"style="float: left;width: 20%">
                        <div class="thumbnail"style="height: 300px;background-color: rgba(255,255,255,0.7)">
                            <img src="image/07.jpg" alt="..."style="height: 40%;width: 100%">
                            <div class="caption">
                                <h3>国之重器:核潜艇</h3>
                                <p>核潜艇是潜艇中的一种类型，指以核反应堆为动力来源设计的潜艇。由于这种........</p>
                                <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-6 col-md-4"style="float: left;width: 20%">
                        <div class="thumbnail"style="height: 300px;background-color: rgba(255,255,255,0.7)">
                            <img src="image/01.jpg" alt="..."style="height: 40%;width: 100%">
                            <div class="caption">
                                <h3>核弹的威力</h3>
                                <p>当核武器在三十千米高空以下爆炸时,各种杀伤要素占的比例为光辐射..........</p>
                                <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4"style="float: left;width: 20%">
                        <div class="thumbnail"style="height: 300px;background-color: rgba(255,255,255,0.7)">
                            <img src="image/09.jpg" alt="..."style="height: 40%;width: 100%">
                            <div class="caption">
                                <h3>核武器的诞生</h3>
                                <p>原子的分裂现象是30年代德国人首先发现的，而且注意到原子分裂时........</p>
                                <p><a href="#" class="btn btn-primary" role="button">访问</a> </p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
                </div>

    </div>
        </div>
</div> <nav aria-label="...">
    <ul class="pager">
        <li><a href="#">上一页</a></li>
        <li><a href="#">下一页</a></li><button type="button"></button>
    </ul>
</nav>


</div>


</body>
<script>
    function findUserByUsername(username) {
       // alert(username);
       $.get("/findalluserbyusername",{"username":username},function (data) {
           $("#xingming").val(data.name);
           $("#pwd").val(data.password);
           $("#address").val(data.address);
           $("#ucode").val(data.ucode);


           //返回json数据格式

       });

    }
    var  ggg=${hhh};
    if (ggg==404){

        alert("请先登录");
        location.href="main.jsp"





    }


</script>
</html>

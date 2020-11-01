<%--
  Created by IntelliJ IDEA.
  User: 誓约之泪
  Date: 2020-10-20
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>核武库</title>
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
        /*.table-hover>tbody>tr:hover {*/
        /*    background-color: #d4d4d4!important;}*/

    </style>
</head>
<body style="background-image: url(image/背景.jpg);background-size: cover">
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="background-image: url(image/04.jpg)">
    <div class="modal-dialog" role="document" >
        <div class="modal-content"style="background-color: rgba(255,255,255,0.7);margin-top: 100px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">核弹一览</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="weaponid" class="control-label">编号:</label>
                        <input type="text" class="form-control" readonly="readonly"id="weaponid">
                    </div>
                    <div class="form-group">
                        <label for="weaponname" class="control-label">名称:</label>
                        <input type="text" class="form-control" id="weaponname">
                    </div>
                    <div class="form-group">
                        <label for="launchplace" class="control-label">发射点:</label>
                        <input type="text" class="form-control" id="launchplace">
                        <div class="form-group">
                            <label for="range" class="control-label">射程:</label>
                            <input type="text" class="form-control" id="range">
                        </div>
                        <div class="form-group">
                            <label for="amount" class="control-label">数量:</label>
                            <input type="text" class="form-control" id="amount">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="btn1" href="/findAllWeapons?currentpage=${currentPage}">确认</button>
            </div>
        </div>
    </div>
</div>




<div class="modal fade"  id="my" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="background-image: url(image/05.jpg);background-size: cover">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color: rgba(255,255,255,0.7);margin-top: 200px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"name="exampleModalLabel">添加</h4>
            </div>            <form action="/addweapontest?currentPage=${currentPage}"method="post">
            <div class="modal-body">


                <div class="form-group">
                    <label for="weaponname" class="control-label">名称:</label>
                    <input type="text" class="form-control" name="weaponname">
                </div>
                <div class="form-group">
                    <label for="launchplace" class="control-label">发射点:</label>
                    <input type="text" class="form-control" name="launchplace">
                    <div class="form-group">
                        <label for="range" class="control-label">射程:</label>
                        <input type="text" class="form-control" name="range"id="rangein">
                    </div>
                    <div class="form-group">
                        <label for="amount" class="control-label">数量:</label>
                        <input type="text" class="form-control"name="amount" id="amountin">
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
<video id="v1" autoplay loop muted>
    <source src="image/我的影片.mp4" type="video/mp4"  />
</video>

<script>
    var video= document.getElementById(v1);
    video.playbackRate = 1.5;

</script>

<div>

    <img src="image/首页导航.jpg" class="img-responsive" style="width: 100%;height: 22vh">

</div>

<nav class="navbar navbar-default navbar-static-top navbar-inverse">
    <div class="navbar-header">
<a href="/toMain">
        <img class="img-circle" width="34px" height="34px" style="margin-top: 8px ;margin-left: 20px;margin-right:26px"
             src="image/hebiaozhi.jpg">
        </a>
    </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav ">
                <li class="active"><a href="/findAllWeapons?currentPage=1" class="navbar-brand">核武库</a></li>
                <li  ><a href="/toBaiKe">官方文档 <span class="sr-only">(current)</span></a></li>
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
                </li><li><span class="glyphicon glyphicon-search" style="color:white;margin-top: 18px ;margin-left: 180px"></span></li>
            </ul>
            <form class="navbar-form navbar-left"style="margin-left: 18px"method="post" action="/selectWeaponForLike?currentPage=1">
                <div class="form-group">
                    <input type="text" class="form-control"name="weaponname" placeholder="请输入名称进行检索....">
                </div>
                <button type="submit" class="btn btn-default">检索</button>
            </form>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="loginfc.jsp">登录</a></li>

                <li><a href="registerfc.jsp">注册</a></li>
                <li><a href="#">${msg}</a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span></a></li>

                <li class="dropdown" style="margin-right: 40px">
<%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"--%>
<%--                       aria-expanded="false"><span class="glyphicon glyphicon-cog"></span> <span--%>
<%--                            class="caret"></span></a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="#">用户设置</a></li>--%>
<%--                        <li><a href="#">界面设置</a></li>--%>
<%--                        <li><a href="#">其他设置</a></li>--%>
<%--                        <li role="separator" class="divider"></li>--%>
<%--                        <li><a href="#">修改密码</a></li>--%>
<%--                    </ul>--%>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div style="width: 80%;height:100vh;margin-left:10% ">
    <table class="table table-bordered  table-condensed"   style="width: 90%;margin-left: 5%;font-weight: bolder;background-color: rgba(255,255,255,0.7);margin-bottom: 0px">  <tr><td ><a style="margin-left: 430px;font-size: 30px;text-decoration: none">中华人民共和国核武器一览</a> <button type="button"class="btn btn-success"data-toggle="modal" data-target="#my" data-whatever="@mdo onclick=" style="margin-left: 410px" >
        添加
    </button></td></tr></table>
    <table class="table table-bordered  table-hover table-condensed"   style="width: 90%;margin-left: 5%;font-weight: bolder;background-color: rgba(255,255,255,0.7)">

        <tr>
            <td class="success" style="width: 10%">编号</td>
            <td class="active" style="width: 20% ;background-color: #bce8f1">名称</td>

            <td class="info" style="width: 20%">发射点</td>
            <td class="warning" style="width: 15%">射程(km)</td>
            <td class="danger" style="width: 15%">数量</td>
            <td class="active" style="width: 20%;text-align: center;background-color:lemonchiffon">操作</td>

        </tr>
        <c:forEach items="${list}" var="i">
            <tr  >
                <td style="padding-top: 12px " id="tablehover1">${i.weaponid}</td>
                <td style="padding-top: 12px">${i.weaponname}</td>
                <td style="padding-top: 12px">${i.launchplace}</td>
                <td style="padding-top: 12px">${i.range}</td>
                <td style="padding-top: 12px">${i.amount}</td>
                <td><button type="button" class="btn btn-info"data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo onclick=" onclick=" findWeaponByWeaponId('${i.weaponid}')"style="margin-left: 38px">修改</button>
                    <button type="button" class="btn btn-danger" style="margin-left: 78px"><a href="/deleteWeaponById?weaponid=${i.weaponid}&currentPage=${currentPage}"style="color: white" >删除</a></button></td>
            </tr>


        </c:forEach>
        <c:forEach items="${listlike}" var="i">
            <tr  >
                <td style="padding-top: 12px " id="tablehover2">${i.weaponid}</td>
                <td style="padding-top: 12px">${i.weaponname}</td>
                <td style="padding-top: 12px">${i.launchplace}</td>
                <td style="padding-top: 12px">${i.range}</td>
                <td style="padding-top: 12px">${i.amount}</td>
                <td><button type="button" class="btn btn-info"data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo onclick=" onclick=" findWeaponByWeaponId('${i.weaponid}')"style="margin-left: 38px">修改</button>
                    <button type="button" class="btn btn-danger" style="margin-left: 78px"><a href="/deleteWeaponById?weaponid=${i.weaponid}&currentPage=${currentPage}"style="color: white" >删除</a></button></td>
            </tr>


        </c:forEach>
    </table>
    <nav aria-label="Page navigation" style="margin-left: 5%">
        <ul class="pagination">
            <li>
                <a href="/findAllWeapons?currentPage=${currentPage-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach items="${array}"  varStatus="i">
                <li><a href="/findAllWeapons?currentPage=${i.count}">${i.count}</a></li><!--从1开始迭代计数-->
            </c:forEach>
            <li>
                <a href="/findAllWeapons?currentPage=${currentPage+1}" aria-label="Next" >
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>


    </nav>

</div>
</div>
<%--<input type="hidden" value="${hh}" id="empty">--%>
</body>
<script>
    function findWeaponByWeaponId(id) {

        $.get("/updateWeaponByWeaponid",{"weaponid":id},function(data){
            //返回json数据格式
            // alert(data.weaponid);
            $("#weaponid").val(data.weaponid);
            $("#weaponname").val(data.weaponname);
            $("#launchplace").val(data.launchplace);
            $("#range").val(data.range);
            $("#amount").val(data.amount);

        });

    }


    $("#btn1").click(function () {
        //获取表单数据
        var weaponid = $("#weaponid").val();
        var weaponname=$("#weaponname").val();
        var launchplace = $("#launchplace").val();
        var range = $("#range").val();
        var amount = $("#amount").val();
        window.location.href="/toUpdateWeaponInfo?weaponid="+weaponid+"&weaponname="+weaponname+"&launchplace="+launchplace+"&range="+range+"&amount="+amount+"&currentPage="+${currentPage};
    });

    $("#rangein").blur(function(){
        var rangein=$("#rangein").val();
      if(rangein !=parseInt(rangein)){
          alert("无法识别,请在射程中输入符合规范的数字");
          $("#rangein").val("");
      }

    })

    $("#amountin").blur(function(){
        var amountin=$("#amountin").val();
        if(amountin !=parseInt(amountin)){
            alert("无法识别,请在数量中输入符合规范数字");
            $("#amountin").val("");
        }

    })
    if("${emptyin}"==2){

        window.location.href="/findAllWeapons?&currentPage=1" ;
        alert("添加为空,添加失败");

    }


</script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2020-10-24
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改武器</title>
    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="/build/css/custom.min.css" rel="stylesheet">

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="" class="site_title"><span>最高权限管理系统</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="production/images/inbox.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>欢迎您,</span>
                        <h2>${user.name}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>信息设置</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> 主页 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/findUserByPageServlet">数据库信息</a></li>
                                    <li><a href="${pageContext.request.contextPath}/add.jsp">添加数据</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> 个人信息设置 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="form.html">个人信息</a></li>
                                    <li><a href="form_advanced.html">个人信息修改</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <ul class="nav side-menu">
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>


        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="production/images/inbox.png" alt="">${user.name}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item"  href="javascript:;">
                                    <span>个人信息设置</span>
                                </a>
                                <a class="dropdown-item"  href="login.html"><i class="fa fa-sign-out pull-right"></i>注销账户</a>
                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="container" style="width: 400px;">
                <h3 style="text-align: center;">修改武器信息</h3>
                <form action="${pageContext.request.contextPath}/updateWeaponServlet" method="post">

                    <input type="hidden" name="id" value="${weapon.id}">
                    <div class="form-group">
                        <label for="name">武器名称：</label>
                        <input value="${weapon.name}" type="text" class="form-control" id="name" name="name"  readonly="readonly"  placeholder="请输入武器名称" />
                    </div>


                    <div class="form-group">
                        <%--@declare id="u_id"--%><label for="u_id">维护人员编号：</label>
                        <input value="${weapon.u_id}" type="text" class="form-control" id="u_id"  name="u_id" placeholder="请输入维护人员编号" />
                    </div>

                    <div class="form-group">
                        <label for="wh_id">仓库编号：</label>
                        <input value="${weapon.wh_id}" id="wh_id" type="text" class="form-control" name="wh_id" placeholder="请输入仓库编号"/>
                    </div>


                    <div class="form-group">
                        <%--@declare id="range"--%><label for="range">射程：</label>
                        <input value="${weapon.range}" id="range" type="text" class="form-control" name="range" placeholder="射程"/>
                    </div>



                    <div class="form-group" style="text-align: center">
                        <input class="btn btn-primary" type="submit" value="提交" />
                        <input class="btn btn-default" type="reset" value="重置" />
                        <input class="btn btn-default" type="button" value="返回"/>
                    </div>
                </form>
            </div>
        </div>

        <!-- /page content -->

        <!-- footer content -->

        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>
</body>
</html>
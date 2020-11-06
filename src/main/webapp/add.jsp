<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="/build/css/custom.min.css" rel="stylesheet">


    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
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
                        <img src="production/images/inbox.jpg" alt="..." class="img-circle profile_img">
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
                            <li><a><i class="fa fa-edit"></i> 人员信息设置 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/findUserByPageServlet">最高权限管理员</a></li>
                                    <li><a href="${pageContext.request.contextPath}/findSecUserByPageServlet">二级权限管理员</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> 仓库信息设置 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/findWareHouseByPageServlet">仓库表</a></li>
                                    <li><a href="${pageContext.request.contextPath}/findWeaponByPageServlet">武器表</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> 个人信息设置 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">个人信息修改</a></li>
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
                    <a data-toggle="tooltip" data-placement="top" title="登出" href="/exitServlet">
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
                                <img src="production/images/inbox.jpg" alt="">${user.name}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item"  href="/findUserServlet?id=${user.id}">
                                    <span>个人信息设置</span>
                                </a>
                                <a class="dropdown-item"  href="/exitServlet"><i class="fa fa-sign-out pull-right"></i>注销账户</a>
                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="container">
                <center><h3>添加管理员页面</h3></center>
                <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
                    <div class="form-group">
                        <label for="name">姓名：</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                    </div>

                    <div class="form-group">
                        <label>性别：</label>
                        <input type="radio" name="gender" value="男" checked="checked"/>男
                        <input type="radio" name="gender" value="女"/>女
                    </div>

                    <div class="form-group">
                        <label for="age">年龄：</label>
                        <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                    </div>

                    <div class="form-group">
                        <label for="address">籍贯：</label>
                        <select name="address" class="form-control" id="address">
                            <option value="广东">广东</option>
                            <option value="广西">广西</option>
                            <option value="湖南">湖南</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="qq">编号：</label>
                        <select name="qq" class="form-control" id="qq">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="email">Email：</label>
                        <input id="email" type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
                    </div>

                    <div class="form-group" style="text-align: center">
                        <input class="btn btn-primary" type="submit" value="提交" />
                        <input class="btn btn-link " type="reset" value="重置" />
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
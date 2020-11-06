<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
    <title>二级权限管理员表</title>

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

    <script>
        function deleteSecUser(id) {
            //安全提示
            if (confirm("您确定要删除吗？")){
                //${pageContext.request.contextPath}/delSecUserServlet?id=${secuser.id}
                location.href="${pageContext.request.contextPath}/delSecUserServlet?id="+id;
            }

        }
        window.onload = function () {
            //给删除选中
            document.getElementById("delSelected").onclick = function () {
                var flag = false;
                var cbs = document.getElementsByName("uid");
                for (var i = 0; i < cbs.length; i++) {
                    if(cbs[i].checked){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    if(confirm("请确定要删除这些数据吗？")){
                        document.getElementById("form").submit();
                    }
                }

            }

            document.getElementById("firstCb").onclick = function () {
                var cbs = document.getElementsByName("uid");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
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
        <div class="right_col" role="main" >
            <div class="right_col" role="main" style="margin-left: 10px">
                <div class="container" >
                    <h3 style="text-align: center">二级权限管理员信息列表</h3>
                    <div style="float: left">
                        <form class="form-inline" action="${pageContext.request.contextPath}/findSecUserByPageServlet" method="post">
                            <div class="form-group">
                                <label for="exampleInputName2">姓名</label>
                                <input name="name" type="text" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail3">籍贯</label>
                                <input name="address" type="text" value="${condition.address[0]}" class="form-control" id="exampleInputEmail3">
                            </div>
                            <%--<div class="form-group">
                                <label for="exampleInputEmail3">籍贯</label>
                                <input name="address" type="text" value="${condition.address[0]}" class="form-control" id="exampleInputEmail3">
                            </div>--%>
                            <div class="form-group" >
                                <label for="ucode">上级编号：</label>
                                <select name="ucode" class="form-control" id="ucode">
                                    <option value="" hidden>全部</option>
                                    <option value="1" hidden>1</option>
                                    <option value="2" hidden>2</option>
                                    <option value="3" hidden>3</option>
                                    <c:if test="${condition.ucode[0] == '1'}">
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="">全部</option>
                                    </c:if>
                                    <c:if test="${condition.ucode[0] == '2'}">
                                    <option value="1" >1</option>
                                    <option value="2" selected>2</option>
                                    <option value="3">3</option>
                                        <option value="">全部</option>
                                    </c:if>
                                    <c:if test="${condition.ucode[0] == '3'}">
                                    <option value="1" selected>1</option>
                                    <option value="2">2</option>
                                    <option value="3" selected>3</option>
                                        <option value="">全部</option>
                                    </c:if>
                                    <c:if test="${condition.ucode[0] == ''}">
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="" selected>全部</option>
                                    </c:if>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-link">查询</button>
                        </form>
                    </div>
                    <div style="float: right;margin: 5px">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/secadd.jsp">添加管理员</a>
                        <a class="btn btn-primary" href="javascript:void(0);"id="delSelected">删除选中</a>
                    </div>

                    <form id="form" action="${pageContext.request.contextPath}/delSelectedSecServlet" method="post">
                        <table border="1" class="table table-bordered table-hover">
                            <tr class="success">
                                <th><input type="checkbox" id="firstCb"></th>
                                <th >编号</th>
                                <th >姓名</th>
                                <th>籍贯</th>
                                <th>上级编号</th>
                                <th style="text-align: center">操作</th>
                            </tr>
                            <c:forEach items="${pb1.list }" var="secuser" varStatus="s">
                                <tr>
                                    <th><input class="itemsel" type="checkbox" name="uid" value="${secuser.id}"></th>
                                    <td>${s.count}</td>
                                    <td>${secuser.name}</td>
                                    <td>${secuser.address}</td>
                                    <td>${secuser.ucode}</td>
                                    <td style="text-align: center"><a class="btn btn-link " href="${pageContext.request.contextPath}/findSecUserServlet?id=${secuser.id}">修改</a>&nbsp;|
                                        <a class="btn btn-link " href="javascript:deleteSecUser(${secuser.id});">删除</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>


                    <div class="dataTables_paginate paging_simple_numbers" id="datatable_paginate">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">

                                <c:if test="${pb1.currentPage == 1}">
                                <li class="paginate_button previous disabled" id="datatable_previous">
                                    </c:if>
                                    <c:if test="${pb1.currentPage != 1}">
                                <li class="paginate_button active">
                                    </c:if>


                                    <a aria-controls="datatable" data-dt-idx="0" tabindex="0" href="${pageContext.request.contextPath}/findSecUserByPageServlet?currentPage=${pb1.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>

                                <c:forEach begin="1" end="${pb1.totalPage}" var="i">
                                    <c:if test="${pb1.currentPage == i}">
                                        <li class="active paginate_button "><a href="${pageContext.request.contextPath}/findSecUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                                    </c:if>
                                    <c:if test="${pb1.currentPage != i}">
                                        <li class="paginate_button "><a href="${pageContext.request.contextPath}/findSecUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${pb1.currentPage == pb1.totalPage}">
                                <li class="disabled page-item">
                                    </c:if>
                                    <c:if test="${pb1.currentPage != pb1.totalPage}">
                                <li class="page-item">
                                    </c:if>
                                    <a aria-controls="datatable" href="${pageContext.request.contextPath}/findSecUserByPageServlet?currentPage=${pb1.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                                <span style="font-size: 15px;margin-left: 5px">
                    共${pb1.totalCount}条记录，共${pb1.totalPage}页
                </span>
                            </ul>
                        </nav>
                    </div>
                </div>
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

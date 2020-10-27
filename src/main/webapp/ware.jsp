<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2020-10-21
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <form action="http://localhost:8082/findWareHouseServlet" method="post">
            请输入你要查询的仓库编号:<input type="text" name="id">
            <button type="submit">查询</button>
        </form>
        <form action="${pageContext.request.contextPath}/addWareHouseServlet" method="post">

            仓库内武器数量：<input type="text" name="num">
            仓库名称：<input type="text" name="name">
            <button type="submit" >添加</button>
        </form>
        <form action="${pageContext.request.contextPath}/delWareHouseServlet" method="post">
            请输入你要删除的仓库比那好<input type="text" name="id">
            <button type="submit">删除</button>
        </form>
        <form action="${pageContext.request.contextPath}/updateWareHouseServlet" method="post">
            请输入你要更新的仓库编号<input type="text" name="id">
            仓库内武器的种类：<input type="text" name="num">
            仓库名称：<input type="text" name="name">
            <button type="submit">修改</button>
        </form>

        <hr>
        <br>
        <br>
        <form action="${pageContext.request.contextPath}/addWeaponServlet" method="post">
            武器名称：<input type="text" name="name">
            维护人员编号：<input type="text" name="u_id">
            仓库编号：<input type="text" name="wh_id">
            武器射程：<input type="text" name="range">
            <button type="submit" >添加</button>
        </form>
        <form action="${pageContext.request.contextPath}/delWeaponServlet" method="post">
            请输入你要删除的武器编号<input type="text" name="id">
            <button type="submit">删除</button>
        </form>
        <form action="${pageContext.request.contextPath}/updateWeaponServlet" method="post">
            请输入你要更新的武器编号<input type="text" name="id">
            武器名称：<input type="text" name="name">
            维护人员编号：<input type="text" name="u_id">
            仓库编号：<input type="text" name="wh_id">
            武器射程：<input type="text" name="range">
            <button type="submit">修改</button>
        </form>
        <form action="${pageContext.request.contextPath}/findWeaponByPageServlet" method="post">
            <button type="submit">查询</button>
        </form>


</body>
</html>

package web.controller;

import service.WareHouseService;
import service.impl.WareHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delWareHouseServlet")
public class DelWareHouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        Integer integer= Integer.valueOf(request.getParameter("ware_id"));

        WareHouseService wareHouseService=new WareHouseServiceImpl();
        //调用删除的方法
        wareHouseService.delWareHouse(integer);
        response.sendRedirect(request.getContextPath()+"/findWareHouseByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

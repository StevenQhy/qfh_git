package web.controller;

import pojo.PageBean;
import pojo.User;
import pojo.WareHouse;
import pojo.WpWh;
import service.UserService;
import service.WareHouseService;
import service.impl.UserServiceImpl;
import service.impl.WareHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet( "/findWareHouseServlet")
public class FindWareHouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");

        Integer integer= Integer.valueOf(id);
        WareHouseService service = new WareHouseServiceImpl();
        WareHouse wareHouse=service.findWareHouseById(integer);
        request.setAttribute("warehouse",wareHouse);

        request.getRequestDispatcher("/updateWarehouse.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

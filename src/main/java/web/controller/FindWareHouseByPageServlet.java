package web.controller;

import pojo.PageBean;
import pojo.WareHouse;
import pojo.Weapon;
import service.WareHouseService;
import service.WeaponService;
import service.impl.WareHouseServiceImpl;
import service.impl.WeaponServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findWareHouseByPageServlet")
public class FindWareHouseByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage=request.getParameter("currentPage");//当前页码
        String rows=request.getParameter("rows");//每页显示条数
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        //获取条件查询的参数
        Map<String,String[]> condition=request.getParameterMap();
        System.out.println(condition);

        WareHouseService service=new WareHouseServiceImpl();
        PageBean<WareHouse> pb=service.findWareHouseByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/warehouse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

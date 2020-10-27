package web.controller;

import service.WareHouseService;
import service.impl.WareHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dekSelectWareHouseServlet")
public class DekSelectWareHouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            //获取id
           String[] ids=request.getParameterValues("uid");
        WareHouseService service=new WareHouseServiceImpl();
        service.delSelectWarehouse(ids);
        response.sendRedirect(request.getContextPath()+"/findWareHouseByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package web.controller;

import org.apache.commons.beanutils.BeanUtils;
import pojo.User;
import pojo.WareHouse;
import service.WareHouseService;
import service.impl.WareHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateWareHouseServlet")
public class UpdateWareHouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        String address= request.getParameter("address");
        String name=request.getParameter("name");
        WareHouse wareHouse=new WareHouse(id,address,name);


        WareHouseService service=new WareHouseServiceImpl();

        service.updateWareHouse(wareHouse);
        response.sendRedirect(request.getContextPath()+"/findWareHouseByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}

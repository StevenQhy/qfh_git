package web.controller;

import org.apache.commons.beanutils.BeanUtils;
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
import java.util.List;
import java.util.Map;

@WebServlet("/addWareHouseServlet")
public class AddWareHouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        WareHouse wareHouse=new WareHouse();

        try {
            BeanUtils.populate(wareHouse,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        WareHouseService service=new WareHouseServiceImpl();
        service.addWareHouse(wareHouse);
        response.sendRedirect(request.getContextPath()+"/warehouse.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

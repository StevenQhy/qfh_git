package web.controller;

import org.apache.commons.beanutils.BeanUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addWeaponServlet")
public class AddWeaponServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        Weapon weapon= new Weapon();

        try {
            BeanUtils.populate(weapon,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        WeaponService service=new WeaponServiceImpl();
        System.out.println(weapon);
        service.addWeapon(weapon);
        response.sendRedirect(request.getContextPath()+"/findWeaponServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

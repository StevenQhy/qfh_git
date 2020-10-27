package web.controller;

import org.apache.commons.beanutils.BeanUtils;
import pojo.Weapon;
import service.WeaponService;
import service.impl.WeaponServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateWeaponServlet")
public class UpdateWeaponServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        Weapon weapon=new Weapon();

        try {
            BeanUtils.populate(weapon,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(weapon);

        WeaponService service=new WeaponServiceImpl();
        service.updateWeapon(weapon);

        response.sendRedirect(request.getContextPath()+"/findWeaponByPageServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

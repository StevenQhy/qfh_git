package web.controller;

import service.WeaponService;
import service.impl.WeaponServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectWeaponServlet")
public class DelSelectWeaponServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取选中的id
        String[] ids=request.getParameterValues("uid");
        WeaponService service=new WeaponServiceImpl();
        service.delSelectWeapon(ids);


        response.sendRedirect(request.getContextPath()+"/findWeaponByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

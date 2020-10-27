package web.controller;

import service.WeaponService;
import service.impl.WeaponServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delWeaponServlet")
public class DelWeaponServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int id= Integer.parseInt(request.getParameter("id"));

        WeaponService service=new WeaponServiceImpl();


        service.delWeapon(id);

        response.sendRedirect(request.getContextPath()+"/findWeaponByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

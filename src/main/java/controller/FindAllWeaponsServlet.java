package controller;

import daofc.WeaponDao;
import pojofc.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findallweaponsservlet",urlPatterns = "/findAllWeapons")
public class FindAllWeaponsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去数据库查询表数据
        HttpSession httpSession = req.getSession();
       String name = (String)httpSession.getAttribute("username");
        WeaponDao weaponDao=new WeaponDao();
        List<Weapon> list=weaponDao.findAllWeaponInfo();

        //将集合绑定到main.jsp
        req.setAttribute("list",list);
        req.setAttribute("msg",name + ":欢迎回来");
        req.getRequestDispatcher("hewuku.jsp").forward(req,resp);
//        resp.sendRedirect("hewuku.jsp");

    }
}

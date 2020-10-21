package controller;

import daofc.WeaponDao;
import pojofc.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "test",urlPatterns = "/test")
public class testServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去数据库查询表数据
        WeaponDao weaponDao=new WeaponDao();
        List<Weapon> list=weaponDao.findAllWeaponInfo();

        //将集合绑定到main.jsp
        req.setAttribute("list",list);
        req.getRequestDispatcher("test.jsp").forward(req,resp);

    }
}

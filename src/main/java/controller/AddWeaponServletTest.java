package controller;

import daofc.WeaponDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addweaponservlettest",urlPatterns = "/addweapontest")
public class AddWeaponServletTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String weaponname = req.getParameter("weaponname");
        String launchplace = req.getParameter("launchplace");
        String range = req.getParameter("range");
        String amount = req.getParameter("amount");
        System.out.println(launchplace);

        System.out.println(weaponname);
        System.out.println(range);
        System.out.println( amount);
        WeaponDao weaponDao=new WeaponDao();
        int row = weaponDao.AddNewWeapon(weaponname, launchplace, range, amount);
        if(row>0){
            resp.sendRedirect("/findAllWeapons");
        }
else{
    req.getRequestDispatcher("error.jsp").forward(req,resp);

        }

    }
}

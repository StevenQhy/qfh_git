package controller;

import daofc.WeaponDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateweapninfo",urlPatterns = "/toUpdateWeaponInfo")
public class UpdateWeaponInfo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String weaponid = req.getParameter("weaponid");
        String weaponname = req.getParameter("weaponname");
        String launchplace = req.getParameter("launchplace");
        String range = req.getParameter("range");
        String amount=req.getParameter("amount");
//        System.out.println(launchplace);
//        System.out.println(weaponid);
//        System.out.println(weaponname);
//        System.out.println(range);
//        System.out.println( amount);
        WeaponDao weaponDao=new WeaponDao();
        int row = weaponDao.UpdateWeaponInfo(weaponid,weaponname,launchplace, range, amount);
        if(row>0){
            String currentPage = req.getParameter("currentPage");
            System.out.println("++++***++++*****"+currentPage);

            resp.sendRedirect("/findAllWeapons?currentPage="+currentPage);
        }else{
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }

    }
}

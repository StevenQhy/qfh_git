package controller;

import daofc.WeaponDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteweaponservlet",urlPatterns = "/deleteWeaponById")
public class DeleteWeaponServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数值
        String weaponid = req.getParameter("weaponid");
        //根据id删除用户
        WeaponDao weaponDao=new WeaponDao();
        int row = weaponDao.deleteWeaponById(weaponid);
        //对返回值进行判断
        if (row>0){
          resp.sendRedirect("/findAllWeapons");
//            req.getRequestDispatcher("/findAllWeapons").forward(req,resp);
        }else{
        req.getRequestDispatcher("error.jsp").forward(req,resp);
        }


    }
}

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

@WebServlet(name="likesearch",urlPatterns = "/selectWeaponForLike")
public class LikeSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String weaponname = req.getParameter("weaponname");
        String currentPage = req.getParameter("currentPage");
        System.out.println(currentPage+"搜索时当前页");
        //将name传给weapondao
        WeaponDao weaponDao=new WeaponDao();
        List<Weapon> listlike = weaponDao.selectWeaponForLike(weaponname);
        System.out.println(listlike.toString());
        //将数据绑定到main.jsp
        req.setAttribute("listlike",listlike);
        req.setAttribute("currentPage",currentPage);
        //转发
        req.getRequestDispatcher("hewuku.jsp").forward(req,resp);


    }
}

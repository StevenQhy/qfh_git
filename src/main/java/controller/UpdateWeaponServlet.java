package controller;

import com.alibaba.fastjson.JSONObject;
import daofc.WeaponDao;
import pojofc.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateweaponservlet",urlPatterns = "/updateWeaponByWeaponid")
public class UpdateWeaponServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String weaponid=req.getParameter("weaponid");
        WeaponDao weaponDao=new WeaponDao();
        Weapon weapon = weaponDao.findWeaponByWeaponId(weaponid);
//        req.setAttribute("weapon",weapon);
//        req.getRequestDispatcher("test.jsp").forward(req,resp);
        //将weapon转为json字符串
//        System.out.println(weapon);
//        System.out.println("=====================");
        String json = JSONObject.toJSONString(weapon);
        //告诉浏览器输出数据格式
        resp.setContentType("application/json;charset=utf-8");
        //获取输出流
        resp.getWriter().write(json);

    }
}

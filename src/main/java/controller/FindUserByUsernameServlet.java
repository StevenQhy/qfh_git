package controller;

import com.alibaba.fastjson.JSONObject;
import daofc.UserDao;
import pojofc.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findalluserbyusername")
public class FindUserByUsernameServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        UserDao userDao=new UserDao();
        User user = userDao.finduserbyusername(username);
        System.out.println(user.toString());
        String json = JSONObject.toJSONString(user);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

    }
}

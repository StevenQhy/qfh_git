package controller;

import daofc.UserDao;
import pojofc.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet", urlPatterns = "/logincheck")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        UserDao userDao = new UserDao();
        User user = userDao.judge(username);

        if (user == null) {
            req.setAttribute("msg", "该用户不存在");
            req.getRequestDispatcher("loginfc.jsp").forward(req, resp);

        } else {
            if (user.getUsername().equals(username) && user.getPassword().equals(pwd)) {
                //创建session对象
                HttpSession httpSession = req.getSession();
                //将用户名绑定到session
                httpSession.setAttribute("username", username);
                req.setAttribute("msg", username + ":欢迎回来");
                req.getRequestDispatcher("main.jsp").forward(req, resp);


            } else {
                req.setAttribute("msg", "用户名或密码错误");
                req.getRequestDispatcher("loginfc.jsp").forward(req, resp);

            }
        }
    }
}

package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logincheckusername", urlPatterns = "/logcheckname")
public class LoginCheckUserName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接受参数

        String username = req.getParameter("username");

        //获取输出流
        PrintWriter out = resp.getWriter();
        //告诉浏览器服务端输出的内容
        resp.setContentType("text/html;charset=utf-8");
        if (username == null || username == "") {

            out.println("用户名不能为空");

        }
    }
}

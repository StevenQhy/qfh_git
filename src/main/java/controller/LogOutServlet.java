package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutservlet",urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //退出系统要清空session对象,将保存在session对象里的数据清空
        HttpSession session = req.getSession();
        String name =(String) session.getAttribute("username");
        //对name数据进行判断
        if(name!=null){
            //清空session数据
            session.removeAttribute("username");
            session.removeAttribute("emptyin");
           resp.sendRedirect("main.jsp");
        }
else{
    resp.sendRedirect("main.jsp");
        }

    }
}

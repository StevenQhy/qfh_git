package controller;

import daofc.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/modifyMessage")
public class ModifyMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession httpSession = req.getSession();
        String username = (String)httpSession.getAttribute("username");

        String name = req.getParameter("xingming");
        String password = req.getParameter("pwd");
        String address = req.getParameter("address");
        String ucode = req.getParameter("ucode");


        UserDao userDao=new UserDao();
        int row = userDao.modifyuser(username, name, password, address, ucode);
        if (row>0){
         resp.sendRedirect("/toMain");
        }
        else{
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }


    }
}

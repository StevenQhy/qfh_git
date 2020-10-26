package web.controller;

import pojo.SecUser;
import service.SecUserService;
import service.impl.SecUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/secUserListServlet")
public class SecUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用UserService完成查询
        SecUserService service = new SecUserServiceImpl();
        List<SecUser> secUsers = service.FindAll();
        request.setAttribute("secUsers",secUsers);
        request.getRequestDispatcher("/seclist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

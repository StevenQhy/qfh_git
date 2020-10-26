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

@WebServlet("/findSecUserServlet")
public class FindSecUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SecUserService service = new SecUserServiceImpl();
        SecUser secuser = service.findSecUserById(id);

        request.setAttribute("secuser",secuser);
        request.getRequestDispatcher("/secupdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

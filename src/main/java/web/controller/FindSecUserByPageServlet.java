package web.controller;

import pojo.PageBean;
import pojo.SecUser;
import service.SecUserService;
import service.impl.SecUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findSecUserByPageServlet")
public class FindSecUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage == null|| "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null|| "".equals(rows)){
            rows = "5";
        }
        Map<String, String[]> condition = request.getParameterMap();


        SecUserService service = new SecUserServiceImpl();
        PageBean<SecUser> pb1 = service.findSecUserByPage(currentPage,rows,condition);
        request.setAttribute("pb1",pb1);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/seclist.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

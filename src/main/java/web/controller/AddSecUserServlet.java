package web.controller;

import org.apache.commons.beanutils.BeanUtils;
import pojo.SecUser;
import service.SecUserService;
import service.impl.SecUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addSecUserServlet")
public class AddSecUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        SecUser secuser = new SecUser();
        try {
            BeanUtils.populate(secuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SecUserService service = new SecUserServiceImpl();
        service.addSecUser(secuser);

        response.sendRedirect(request.getContextPath()+"/secUserListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

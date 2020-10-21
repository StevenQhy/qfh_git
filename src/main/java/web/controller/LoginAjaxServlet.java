package web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/loginAjaxServlet")
public class LoginAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String pawd = request.getParameter("password");
        //获取用户名
        Map<String,Object> map1 = new HashMap<String,Object>();
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.finAll();
        for (User user : users) {
            String name = user.getUsername();
            String password = user.getPassword();
            String status = user.getStatus();
            if (username.equals(name)){
                if ("Y".equals(status)){
                    map1.put("userExsit",true);
                    map1.put("msg","恭喜您,您已注册且账号已激活");
                    break;
                }else{
                    map1.put("userExsit",false);
                    map1.put("msg","账户已注册，但未激活请去邮箱激活");
                }
            }else{
                map1.put("userExsit",false);
                map1.put("msg","账户未激活或未注册，请去注册或激活");
            }

            /*if(username.equals(name) && "Y".equals(status)){
                map1.put("userExsit",true);
                map1.put("msg","恭喜您,您已注册且账号已激活");
                break;
            }
            if(username.equals(name) && !"Y".equals(status)){
                map1.put("userExsit",false);
                map1.put("msg","您未激活，请去邮箱激活");
            }
            if(!username.equals(name)){
                map1.put("userExsit",false);
                map1.put("msg","无此账号请去注册");
            }*/
        }
        /*//调用service层判断用户名是否存在
            if("tom".equals(username)){
                //存在
                map1.put("userExsit",true);
                map1.put("msg","该用户已注册");
            }else{
                //不存在
                map1.put("userExsit",false);
                map1.put("msg","快去注册");
            }*/

        //将map转为jason，并写到页面上
        ObjectMapper mapper = new ObjectMapper();
        //并传递给客户端
        mapper.writeValue(response.getWriter(),map1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

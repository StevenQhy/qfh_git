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
        //获取用户名
        Map<String,Object> map1 = new HashMap<String,Object>();
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.finAll();

        for (User user : users) {
            String name = user.getUsername();
            String status = user.getStatus();
            //System.out.println(username.equals(name));
            if (username.equals(name)){
                //System.out.println("名字匹配");
                if ("Y".equals(status)){
                    //System.out.println("状态激活");
                    map1.put("userExsit",true);
                    map1.put("msg","账户已注册且已激活");
                    break;
                }else{
                    //System.out.println("状态未激活");
                    map1.put("userExsit",false);
                    map1.put("msg","账户已注册，但未激活请去邮箱激活");
                    break;
                }
            }else{
                //System.out.println("用户名不匹配");
                map1.put("userExsit",false);
                map1.put("msg","账户未注册");
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

        //将map转为json，并写到页面上
        ObjectMapper mapper = new ObjectMapper();
        //并传递给客户端
        mapper.writeValue(response.getWriter(),map1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

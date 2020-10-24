package controller;

import daofc.UserDao;
import pojofc.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//处理用户名检查业务
@WebServlet(name = "CheckUserNameServlet", urlPatterns = "/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接受参数

        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
//        System.out.println("牛牛牛牛牛");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");

        if (username.isEmpty()) {

            out.println("用户名不能为空");

        } else {


            UserDao userDao = new UserDao();
            User user = userDao.judge(username);

            //获取输出流

            //告诉浏览器服务端输出的内容
            if (user == null) {
//            //如何将数据绑定jsp页面,1.HttpServletRequest对象
//            req.setAttribute("msg","该用户没有注册");
//            //将数据绑定到登录页面
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
//            requestDispatcher.forward(req,resp);

                out.println("该用户名可用");
            } else {

//            if (user.getName().equals(name)&&user.getPassword().equals(pwd)) {
//                //用户名和密码匹配,跳转到主页
//                req.setAttribute("name", name);
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
//                requestDispatcher.forward(req, resp);
//            }else{
//                //用户或密码错误
//                //将提醒信息绑定到登录页面实现
//                req.setAttribute("msg", "用户名或密码错误!");
//                //将绑定的数据转发到登录页面
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
//                requestDispatcher.forward(req, resp);
//            }
                out.println("该用户名已被注册,请重试!!!");

            }
        }


    }
}

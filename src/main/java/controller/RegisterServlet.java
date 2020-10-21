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

@WebServlet(name = "RegisterServlet", urlPatterns = "/toReg")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//在启动前按照自己指定的字符编码进行解码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");


        PrintWriter out = resp.getWriter();

        System.out.println(username);
        System.out.println(password);


        if (username.isEmpty()) {
            System.out.println("姓名为空");
            out.println(11);
//            RequestDispatcher re = req.getRequestDispatcher("register.jsp");
//           re.forward(req,resp);
        } else {
            if (password.isEmpty()) {
                System.out.println("密码为空");
                out.println(11);
//                RequestDispatcher re = req.getRequestDispatcher("register.jsp");
//                re.forward(req, resp);
            } else {
                System.out.println("获取到数据===========");

                UserDao dao = new UserDao();
                User user = dao.judge(username);
                System.out.println(user);


                if (user == null) {
                    System.out.println("1111");
                    int row = dao.addUserInfo(username, password);
                    if (row >= 1) {
                        out.println(13);
                        //添加数据成功,跳转登录页面
                        System.out.println("2222");
//                        req.getRequestDispatcher("login.jsp").forward(req, resp);

                    } else {
                        //停留在注册页面给出提示
//                        System.out.println("3333");
//                        req.setAttribute("msg", "服务器异常,请稍后再试!");
//                        RequestDispatcher re = req.getRequestDispatcher("register.jsp");
//                        re.forward(req, resp);
                        out.println(14);

                    }

                } else {

                    System.out.println("4444");

                    if (username.equals(user.getName())) {
                        System.out.println("5555");
                        out.println(12);
//                        req.setAttribute("msg", "姓名已存在,注册失败!");
//                        RequestDispatcher re = req.getRequestDispatcher("register.jsp");
//                        re.forward(req, resp);


                    }

                }

            }


        }

    }

}

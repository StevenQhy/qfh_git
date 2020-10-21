package sessionfc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="sessionServlet",urlPatterns = "/newsession")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Httpsession对象
        HttpSession session = req.getSession(true);
        //使用session存储数据
        session.setAttribute("count",1000);
//获取sessionid
        String id = session.getId();

        System.out.println("sessionid:"+id);


    }
}

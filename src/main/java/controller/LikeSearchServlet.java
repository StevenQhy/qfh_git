package controller;

import daofc.PageDao;
import daofc.WeaponDao;
import pojofc.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static daofc.PageDao.startPage;

@WebServlet(name="likesearch",urlPatterns = "/selectWeaponForLike")
public class LikeSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String weaponname = req.getParameter("weaponname");
        HttpSession session = req.getSession();
        session.setAttribute("weaponname",weaponname);
        String username = (String)session.getAttribute("username");
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        System.out.println(currentPage+"搜索时当前页");
        System.out.println("weaponname:"+weaponname);


        int pageSize=5;

        //将name传给weapondao
        WeaponDao weaponDao=new WeaponDao();
        List<Weapon> list = weaponDao.selectWeaponForLike(weaponname);
        System.out.println(list.toString()+"=====");



        int totals=list.size();
        int page = totals % pageSize != 0 ? totals / pageSize + 1 : totals / pageSize;
//        //将页数显示到页面
//        req.setAttribute("page",page);
        ArrayList<Integer> array=new ArrayList<>();//设置一个集合,集合中添加的元素为网页显示的页上的值:例如上一页:1,2,3下一页这个标签显示的1,2,3
        int i=1;
        int pageone=page;
        while(pageone!=0){
            pageone--;
            array.add(i);
            i++;
        }
        if (currentPage>page){
            currentPage=page;
        }
        if (currentPage<1){
            currentPage=1;
        }

        List listlike = startPage(list, currentPage, pageSize);
        System.out.println(listlike.toString());
        req.setAttribute("array",array);
        req.setAttribute("listlike",listlike);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("weaponname",weaponname);
        req.setAttribute("msg",username + ":欢迎回来");

        //转发

        req.getRequestDispatcher("LikeSearchFc.jsp").forward(req,resp);


    }
}

package controller;

import daofc.WeaponDao;
import pojofc.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findallweaponsservlet",urlPatterns = "/findAllWeapons")
public class FindAllWeaponsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去数据库查询表数据
        HttpSession httpSession = req.getSession();

        String username = (String)httpSession.getAttribute("username");


        String emptyin=(String)httpSession.getAttribute("emptyin");

        if (emptyin==null){

            req.setAttribute("hhh",404);
            req.getRequestDispatcher("main.jsp").forward(req,resp);


        }else{

            int empty=Integer.parseInt(emptyin);

            WeaponDao weaponDao=new WeaponDao();
            //获取weapon表数据条数
            int totals = weaponDao.getDataTotal();
            //一页显示5条
            int pageSize=5;
            //算出多少页
            int page = totals % pageSize != 0 ? totals / pageSize + 1 : totals / pageSize;

            //将页数显示到页面
            req.setAttribute("page",page);
            ArrayList<Integer> array=new ArrayList<>();//设置一个集合,集合中添加的元素为网页显示的页上的值:例如上一页:1,2,3下一页这个标签显示的1,2,3
            int i=1;
            int pageone=page;
            while(pageone!=0){
                pageone--;
                array.add(i);
                i++;
            }
            req.setAttribute("array",array);
            //假设当前页currerntPage=1;
            int currentPage=1;
//req.getSession().getAttribute("currentPage");
            currentPage =Integer.parseInt(req.getParameter("currentPage"));

//        System.out.println(currentPage+"======================");
            if (currentPage>page){
                currentPage=page;
            }
            if (currentPage<1){
                currentPage=1;
            }


//为什么要算当前页   偏移量=(页数-1)*每页显示的条数 limit ?,?


            List<Weapon> list=weaponDao.findAllWeaponInfo(currentPage,pageSize);
            if(empty==2){
                //将集合绑定到hewuku.jsp
                req.setAttribute("list",list);
                req.setAttribute("msg",username + ":欢迎回来");
                httpSession.setAttribute("emptyin","2");
                req.setAttribute("currentPage",currentPage);
                req.getRequestDispatcher("hewuku.jsp").forward(req,resp);
                httpSession.setAttribute("emptyin","1");
            }else {
                req.setAttribute("emptyin","1");

                //将集合绑定到hewuku.jsp
                req.setAttribute("currentPage",currentPage);
                req.setAttribute("list",list);
                req.setAttribute("msg",username + ":欢迎回来");
                req.getRequestDispatcher("hewuku.jsp").forward(req,resp);


            }
        }


    }
}

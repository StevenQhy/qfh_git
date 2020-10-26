package controller;

import daofc.WeaponDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addweaponservlettest",urlPatterns = "/addweapontest")
public class AddWeaponServletTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String weaponname = req.getParameter("weaponname");
        String launchplace = req.getParameter("launchplace");
        String range = req.getParameter("range");
        String amount = req.getParameter("amount");

        System.out.println("发射点"+launchplace);
        System.out.println("武器名"+weaponname);
        System.out.println("射程"+range);
        System.out.println("数量"+ amount);
        HttpSession emptyin = req.getSession();

        if(weaponname.isEmpty()||launchplace.isEmpty()||range.isEmpty()||amount.isEmpty()){
            System.out.println("kongkongkong");
            emptyin.setAttribute("emptyin","2");
            resp.sendRedirect("/findAllWeapons?currentPage=1");
            System.out.println(emptyin+"1111111");



        }else{
            WeaponDao weaponDao=new WeaponDao();


            //获取weapon表数据条数
            int totals = weaponDao.getDataTotal();
            //一页显示5条
            int pageSize=5;
            //算出多少页
            int page = totals % pageSize != 0 ? totals / pageSize + 1 : totals / pageSize;

            int row = weaponDao.AddNewWeapon(weaponname, launchplace, range, amount);
            if(row>0){
                //获取weapon表数据条数
                int totalsnew = weaponDao.getDataTotal();
                //算出多少页
                int pagenew = totalsnew % pageSize != 0 ? totalsnew / pageSize + 1 : totalsnew / pageSize;

                if (page==pagenew){
                    String currentPage = req.getParameter("currentPage");
                    System.out.println(currentPage+"---------------------");
                    resp.sendRedirect("/findAllWeapons?currentPage="+page);


                } else {
                    String currentPage = req.getParameter("currentPage");
                    currentPage= String.valueOf((Integer.parseInt(currentPage)+1));
//                req.getSession().setAttribute("currentPage",currentPage);

                    System.out.println(currentPage+"++++++++++++++++++++++++");

                    resp.sendRedirect("/findAllWeapons?currentPage="+pagenew);


                }


            }
            else{
                req.getRequestDispatcher("error.jsp").forward(req,resp);

            }

        }

    }
}

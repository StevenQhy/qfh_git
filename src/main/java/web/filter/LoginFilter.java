/*
package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径
        if(uri.contains(("/login.jsp"))|| uri.contains("/loginServlet")|| uri.contains("/checkCodeServlet")|| uri.contains("/build/")|| uri.contains("/css/")|| uri.contains("/fonts/")|| uri.contains("/js/")|| uri.contains("/vendors/")||uri.contains("/loginAjaxServlet")){
            //包含，证明用户就是想登录
            chain.doFilter(req, resp);
        }else{
            //不包含，验证用户是否登录
            //从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //已经登陆了放行
                chain.doFilter(req, resp);
            }else{
                //没有登陆，跳转登录页面
                request.setAttribute("login_msg","您尚未登录,请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
*/

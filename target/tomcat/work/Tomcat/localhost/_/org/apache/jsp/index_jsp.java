/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-11-01 14:58:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\"/>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n");
      out.write("    <title>首页</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link href=\"/vendors/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- NProgress -->\r\n");
      out.write("    <link href=\"/vendors/nprogress/nprogress.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Custom styling plus plugins -->\r\n");
      out.write("    <link href=\"/build/css/custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"nav-md\">\r\n");
      out.write("<div class=\"container body\">\r\n");
      out.write("    <div class=\"main_container\">\r\n");
      out.write("        <div class=\"col-md-3 left_col\">\r\n");
      out.write("            <div class=\"left_col scroll-view\">\r\n");
      out.write("                <div class=\"navbar nav_title\" style=\"border: 0;\">\r\n");
      out.write("                    <a href=\"\" class=\"site_title\"><span>最高权限管理系统</span></a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("\r\n");
      out.write("                <!-- menu profile quick info -->\r\n");
      out.write("                <div class=\"profile clearfix\">\r\n");
      out.write("                    <div class=\"profile_pic\">\r\n");
      out.write("                        <img src=\"production/images/inbox.jpg\" alt=\"...\" class=\"img-circle profile_img\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"profile_info\">\r\n");
      out.write("                        <span>欢迎您,</span>\r\n");
      out.write("                        <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /menu profile quick info -->\r\n");
      out.write("\r\n");
      out.write("                <br />\r\n");
      out.write("\r\n");
      out.write("                <!-- sidebar menu -->\r\n");
      out.write("                <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\r\n");
      out.write("                    <div class=\"menu_section\">\r\n");
      out.write("                        <h3>信息设置</h3>\r\n");
      out.write("                        <ul class=\"nav side-menu\">\r\n");
      out.write("                            <li><a><i class=\"fa fa-edit\"></i> 人员信息设置 <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                                <ul class=\"nav child_menu\">\r\n");
      out.write("                                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findUserByPageServlet\">最高权限管理员</a></li>\r\n");
      out.write("                                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findSecUserByPageServlet\">二级权限管理员</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a><i class=\"fa fa-edit\"></i> 仓库信息设置 <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                                <ul class=\"nav child_menu\">\r\n");
      out.write("                                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findWareHouseByPageServlet\">仓库表</a></li>\r\n");
      out.write("                                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findWeaponByPageServlet\">武器表</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a><i class=\"fa fa-edit\"></i> 个人信息设置 <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                                <ul class=\"nav child_menu\">\r\n");
      out.write("                                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findUserServlet?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">个人信息修改</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"menu_section\">\r\n");
      out.write("                        <ul class=\"nav side-menu\">\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /sidebar menu -->\r\n");
      out.write("\r\n");
      out.write("                <!-- /menu footer buttons -->\r\n");
      out.write("                <div class=\"sidebar-footer hidden-small\">\r\n");
      out.write("                    <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"登出\" href=\"/exitServlet\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /menu footer buttons -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- top navigation -->\r\n");
      out.write("        <div class=\"top_nav\">\r\n");
      out.write("            <div class=\"nav_menu\">\r\n");
      out.write("                <div class=\"nav toggle\">\r\n");
      out.write("                    <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <nav class=\"nav navbar-nav\">\r\n");
      out.write("                    <ul class=\" navbar-right\">\r\n");
      out.write("                        <li class=\"nav-item dropdown open\" style=\"padding-left: 15px;\">\r\n");
      out.write("                            <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" aria-haspopup=\"true\" id=\"navbarDropdown\" data-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("                                <img src=\"production/images/inbox.jpg\" alt=\"\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-usermenu pull-right\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("                                <a class=\"dropdown-item\"  href=\"/findUserServlet?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                                    <span>个人信息设置</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a class=\"dropdown-item\"  href=\"/exitServlet\"><i class=\"fa fa-sign-out pull-right\"></i>注销账户</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /top navigation -->\r\n");
      out.write("\r\n");
      out.write("        <!-- page content -->\r\n");
      out.write("        <div class=\"right_col\" role=\"main\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- /page content -->\r\n");
      out.write("\r\n");
      out.write("        <!-- footer content -->\r\n");
      out.write("\r\n");
      out.write("        <!-- /footer content -->\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"vendors/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap -->\r\n");
      out.write("<script src=\"vendors/bootstrap/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<!-- FastClick -->\r\n");
      out.write("<script src=\"vendors/fastclick/lib/fastclick.js\"></script>\r\n");
      out.write("<!-- NProgress -->\r\n");
      out.write("<script src=\"vendors/nprogress/nprogress.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Theme Scripts -->\r\n");
      out.write("<script src=\"build/js/custom.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

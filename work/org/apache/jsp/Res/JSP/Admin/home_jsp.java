package org.apache.jsp.Res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>Admin Home</title>\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/stylehome.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom fonts for this template -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin CSS -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/magnific-popup/magnific-popup.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" />\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/creative.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\" >\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"mainNav\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <a class=\"navbar-brand js-scroll-trigger\" href=\"#page-top\">My Privacy My Decision</a>\r\n");
      out.write("        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/allposts.jsp\" target=\"afrm\" >Home</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"");
      out.print(request.getContextPath());
      out.write("/AdminProfile\"  target=\"afrm\">Profile</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            \r\n");
      out.write("             <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/ocrgenerate.jsp\"  target=\"afrm\">Generate OCR Key</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("             <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"");
      out.print(request.getContextPath());
      out.write("/Status\" target=\"afrm\">Users</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("             <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"");
      out.print(request.getContextPath());
      out.write("/Logout\">Logout</a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <header class=\"masthead text-center text-white d-flex\">\r\n");
      out.write("      <div class=\"container my-auto\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("       \r\n");
      out.write("      </div>\r\n");
      out.write("    </header>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"position:absolute;top:130px;left:350px;\">\r\n");
      out.write("\t\t\t<iframe frameborder=\"0\" scrolling=\"auto\"\r\n");
      out.write("\t\t\t name=\"afrm\"; src=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/allposts.jsp\"\r\n");
      out.write("\t\t\t margin-left: 60px; margin-top: 100px;\" height=\"470px\" width=\"730px;\"></iframe>\r\n");
      out.write("\t\t\t</div> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t <script src=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin JavaScript -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/scrollreveal/scrollreveal.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/vendor/magnific-popup/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom scripts for this template -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/creative.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

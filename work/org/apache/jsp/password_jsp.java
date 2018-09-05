package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.*;

public final class password_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {



	String loginstatus="";
String ocrstatus="";



	String passstatus="",mergeSatus="",mergingStatus="",share1_file="",share2_file="";

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  \r\n");
      out.write("  <head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>Creative - Start Bootstrap Theme</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom fonts for this template -->\r\n");
      out.write("    <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin CSS -->\r\n");
      out.write("    <link href=\"vendor/magnific-popup/magnific-popup.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"css/creative.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<!--  -->\r\n");
      out.write("\r\n");
      out.write("    <!--  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\" /> -->\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  ");

    int no=Utility.parse(request.getParameter("no"));
    		
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

	loginstatus=request.getParameter("loginstatus");

loginstatus=request.getParameter("loginstatus");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

	//loginstatus=request.getParameter("loginstatus");
	passstatus=(String)request.getAttribute("passstatus");
	mergeSatus=(String)request.getAttribute("mergeSatus");
	mergingStatus=(String)request.getAttribute("mergingStatus");

      out.write("\r\n");
      out.write("  <body id=\"page-top\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Navigation -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"mainNav\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <a class=\"navbar-brand js-scroll-trigger\" href=\"#page-top\">My Privacy My Decision</a>\r\n");
      out.write("        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#about\">About</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#services\">Admin Login</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#portfolio\">User Registration</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">User Login</a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <header class=\"masthead text-center text-white d-flex\">\r\n");
      out.write("      <div class=\"container my-auto\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-10 mx-auto\">\r\n");
      out.write("            <h1 class=\"text-uppercase\">\r\n");
      out.write("              <strong>My Privacy My Decision:<br> Control of Photo Sharing on Online Social Networks</strong>\r\n");
      out.write("            </h1>\r\n");
      out.write("            <hr>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-8 mx-auto\">\r\n");
      out.write("           <a class=\"btn btn-primary btn-xl js-scroll-trigger\" href=\"#about\">Find Out More</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <section class=\"bg-primary\" id=\"about\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-8 mx-auto text-center\">\r\n");
      out.write("            <h2 class=\"section-heading text-white\">My Privacy My Decision:</h2>\r\n");
      out.write("            <hr class=\"light my-4\">\r\n");
      out.write("            <p class=\"text-faded mb-4\">\tOne characteristic of online social networking services\r\n");
      out.write("\t\t\t\t\tis their emphasis on the users and their connections,\r\n");
      out.write("\t\t\t\t\tin addition to the content as seen in traditional Internet services. \r\n");
      out.write("\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\tOnline social networking data, once published, are of\r\n");
      out.write("\t\t\t\t\tgreat interest to a large audience: Sociologists can verify\r\n");
      out.write("\t\t\t\t\thypotheses on social structures and human behavior\r\n");
      out.write("\t\t\t\t\tpatterns</p>\r\n");
      out.write("           \r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <section id=\"services\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-12 text-center\">\r\n");
      out.write("          \r\n");
      out.write("            <center>\r\n");
      out.write("            <hr class=\"my-4\">\r\n");
      out.write("            \r\n");
      out.write("            \t<center><h4><font color=blue>User ID Authentication sucess... !</font></h4></center>\r\n");
      out.write("\t\r\n");
      out.write("\t <form name=\"adminloginform\" id=\"quote\" action=\"");
      out.print(request.getContextPath() );
      out.write("/User_Password\" method=\"post\" onsubmit=\"return checkFormValidator()\">\r\n");
      out.write("\r\n");
      out.write("<!-- <IMG SRC=\"images/Web_Header2.jpg\" width=100% BORDER=\"0\" ALT=\"\">\r\n");
      out.write(" -->\r\n");
      out.write(" \r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t  \t\t<label><font color=#000000 size=\"4\" >Password:</font></label>\r\n");
      out.write("\t  \t\t<input type=\"password\" name=\"password\" size=\"20\" /> <br> <br>\r\n");
      out.write("\r\n");
      out.write("\t  \t\t<input type=\"submit\" value=\"Login\"> &nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" />\r\n");
      out.write("\t  \t\t</form>\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t\t<table>\r\n");
      out.write("\t\t\t\t         <tr>\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t                 <td align=\"center\">\r\n");
      out.write("\t\t\t\t                 <br>\r\n");
      out.write("\t\t\t\t                 <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/");
      out.print(share1_file);
      out.write("\" width=\"100px\" height=\"100px\">\r\n");
      out.write("\t\t\t\t                 \t    <br>\r\n");
      out.write("\t\t\t\t                 \t  Share1 Image\r\n");
      out.write("\t\t\t\t                 \t  \r\n");
      out.write("\t\t\t\t                 \t\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 <td align=\"center\">\r\n");
      out.write("\t\t\t\t                 <br>\r\n");
      out.write("\t\t\t\t                 <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/");
      out.print(share2_file );
      out.write("\" width=\"100px\" height=\"100px\">\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   \r\n");
      out.write("\t\t\t\t                 \t  Share2 Image\r\n");
      out.write("\t\t\t\t                 \t  \r\n");
      out.write("\t\t\t\t                 \t\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                  \r\n");
      out.write("\t\t\t\t                  <td align=\"center\">\r\n");
      out.write("\t\t\t\t                 <br> <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/res.png\" width=\"100px\" height=\"100px\">\r\n");
      out.write("\t\t\t\t                 \t <br>\r\n");
      out.write("\t\t\t\t                 \t  Your Authenticated Image\r\n");
      out.write("\t\t\t\t                 \t  \r\n");
      out.write("\t\t\t\t                 \t\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                   <td align=\"center\">\r\n");
      out.write("\t\t\t\t               \r\n");
      out.write("\t\t\t\t                 \t   <font color=red >OCR EXTRACTED DATA IS :</font>\r\n");
      out.write("\t\t\t\t                 \t\r\n");
      out.write("\t\t\t\t                 </td> \r\n");
      out.write("\t\t\t\t                 <td align=\"center\">\r\n");
      out.write("\t\t\t\t               \r\n");
      out.write("\t\t\t\t                 \t   <font color=blue size=6><b> ");
      out.print(session.getAttribute("user_id").toString() );
      out.write(" </b></font>\r\n");
      out.write("\t\t\t\t                 \t\r\n");
      out.write("\t\t\t\t                 </td> \r\n");
      out.write("\t\t\t\t         </tr>\r\n");
      out.write("\t\t\t\t         \r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t         \r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</center>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript -->\r\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin JavaScript -->\r\n");
      out.write("    <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("    <script src=\"vendor/scrollreveal/scrollreveal.min.js\"></script>\r\n");
      out.write("    <script src=\"vendor/magnific-popup/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom scripts for this template -->\r\n");
      out.write("    <script src=\"js/creative.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

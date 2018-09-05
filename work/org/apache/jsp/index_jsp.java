package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  \n");
      out.write("  <head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Creative - Start Bootstrap Theme</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom fonts for this template -->\n");
      out.write("    <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("    <!-- Plugin CSS -->\n");
      out.write("    <link href=\"vendor/magnific-popup/magnific-popup.css\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"css/creative.min.css\" rel=\"stylesheet\">\n");
      out.write("<!--  -->\n");
      out.write("\n");
      out.write("    <!--  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\" /> -->\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  ");

    int no=Utility.parse(request.getParameter("no"));
    		
      out.write('\n');
      out.write('\n');
      out.write('\n');

	loginstatus=request.getParameter("loginstatus");

loginstatus=request.getParameter("loginstatus");

      out.write('\n');
      out.write('\n');
      out.write('\n');

	//loginstatus=request.getParameter("loginstatus");
	passstatus=(String)request.getAttribute("passstatus");
	mergeSatus=(String)request.getAttribute("mergeSatus");
	mergingStatus=(String)request.getAttribute("mergingStatus");

      out.write("\n");
      out.write("  <body id=\"page-top\">\n");
      out.write("\n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"mainNav\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <a class=\"navbar-brand js-scroll-trigger\" href=\"#page-top\">My Privacy My Decision</a>\n");
      out.write("        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#about\">About</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#services\">Admin Login</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#portfolio\">User Registration</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">User Login</a>\n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <header class=\"masthead text-center text-white d-flex\">\n");
      out.write("      <div class=\"container my-auto\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-10 mx-auto\">\n");
      out.write("            <h1 class=\"text-uppercase\">\n");
      out.write("              <strong>My Privacy My Decision:<br> Control of Photo Sharing on Online Social Networks</strong>\n");
      out.write("            </h1>\n");
      out.write("            <hr>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-lg-8 mx-auto\">\n");
      out.write("           <a class=\"btn btn-primary btn-xl js-scroll-trigger\" href=\"#about\">Find Out More</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <section class=\"bg-primary\" id=\"about\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-8 mx-auto text-center\">\n");
      out.write("            <h2 class=\"section-heading text-white\">My Privacy My Decision:</h2>\n");
      out.write("            <hr class=\"light my-4\">\n");
      out.write("            <p class=\"text-faded mb-4\">\tOne characteristic of online social networking services\n");
      out.write("\t\t\t\t\tis their emphasis on the users and their connections,\n");
      out.write("\t\t\t\t\tin addition to the content as seen in traditional Internet services. \n");
      out.write("\t\t\t\t\t<br><br>\n");
      out.write("\t\t\t\t\tOnline social networking data, once published, are of\n");
      out.write("\t\t\t\t\tgreat interest to a large audience: Sociologists can verify\n");
      out.write("\t\t\t\t\thypotheses on social structures and human behavior\n");
      out.write("\t\t\t\t\tpatterns</p>\n");
      out.write("           \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section id=\"services\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-12 text-center\">\n");
      out.write("            <h2 class=\"section-heading\">Admin Login</h2>\n");
      out.write("            <center>\n");
      out.write("            <hr class=\"my-4\">\n");
      out.write("            \n");
      out.write("            \t<form class=\"login active\" action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\" method=\"post\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 130px\">\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 30px;height: 40px;\">User ID:</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"userid\" id=\"userid\" required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 110px\">\n");
      out.write("\t\t\t\t\t\t\t<label style=\"height: 40px;\">Password: </label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\" required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary btn-xl js-scroll-trigger\"   value=\"Login\" onclick=\"return login()\"></input>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</center>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section class=\"p-0\" id=\"portfolio\">\n");
      out.write("       <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-8 mx-auto text-center\">\n");
      out.write("            <h2 class=\"section-heading\">User Registration</h2>\n");
      out.write("          <center>\n");
      out.write("         <!--  <div class=\"wrapper\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"content\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"form_wrapper\" class=\"form_wrapper\" style=\"margin-top: 12px;\"> -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-------------------------------Register Form -------------------------------------->\n");
      out.write("\t\t\t\t\t<form class=\"register active\" action=\"");
      out.print(request.getContextPath());
      out.write("/Register\" enctype=\"multipart/form-data\" method=\"post\" >\n");
      out.write("\t\t\t\t\t\t<h3 style=\"height: 15px;\">Register</h3>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Name</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"name\" required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">User ID(Email ID):</label>\n");
      out.write("\t\t\t\t\t\t\t\t <input type=\"text\" name=\"userid\" pattern=\"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\"  required /> \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Password:</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;&nbsp;\t\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" name=\"password\"  required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Birthday:</label></tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td><select name=\"day\" id=\"day\"  class=\"day\" required=\"yes\">\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">Day</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										for(int i=1; i<=31;i++)
										{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</select></td>\n");
      out.write("\t\t\t\t\t\t\t<td >\t\n");
      out.write("\t\t\t\t\t\t<select id=\"BirthMonth\" name=\"BirthMonth\" class=\"month\" required=\"yes\" >\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">Month</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"01\" >\n");
      out.write("\t\t\t\t\t\t\t\t  January</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"02\" >\n");
      out.write("\t\t\t\t\t\t\t\t  February</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"03\" >\n");
      out.write("\t\t\t\t\t\t\t\t  March</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"04\" >\n");
      out.write("\t\t\t\t\t\t\t\t  April</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"05\" >\n");
      out.write("\t\t\t\t\t\t\t\t  May</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"06\" >\n");
      out.write("\t\t\t\t\t\t\t\t  June</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"07\" >\n");
      out.write("\t\t\t\t\t\t\t\t  July</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"08\" >\n");
      out.write("\t\t\t\t\t\t\t\t  August</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"09\" >\n");
      out.write("\t\t\t\t\t\t\t\t  September</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"10\" >\n");
      out.write("\t\t\t\t\t\t\t\t  October</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"11\" >\n");
      out.write("\t\t\t\t\t\t\t\t  November</option>\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"12\" >\n");
      out.write("\t\t\t\t\t\t\t\t  December</option>\n");
      out.write("\t\t\t\t\t\t\t</select></td>\n");
      out.write("\t\t\t\t\t\t<td><select name=\"year\" id=\"year\"  class=\"year\" required=\"yes\"> \n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">year</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										for(int i=1950; i<=2014;i++)
										{
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</select></td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Gender:</label>\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"gender\" name=\"gender\" class=\"gender\" required=\"yes\">\n");
      out.write("\t  \t\t\t\t\t\t\t\t\t<option value=\"\">I am...</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"FEMALE\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tFemale</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"MALE\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tMale</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"OTHER\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tOther</option>\n");
      out.write("\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Hobby:</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"hobby\" required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Policy:</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"policy\" name=\"policy\" class=\"policy\" required=\"yes\">\n");
      out.write("\t  \t\t\t\t\t\t\t\t\t<option value=\"\">Select</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"Friends\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tFriends</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"Public\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tPublic</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"Get Aproval\" >\n");
      out.write("\t\t\t\t\t\t\t\t\t\tGet Aproval</option>\n");
      out.write("\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Mobile No.</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;&nbsp;\t&nbsp;\t&nbsp;\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"mobile\"  required=\"yes\"  pattern=\"[7-9]{1}[0-9]{9}\"  maxlength=\"10\" height=\"10\" />\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<label style=\"padding-top: 20px;height: 40px;\">Upload Profile Pic</label>\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"file\" class=\"btn btn-light btn-xl sr-button\"  name=\"pfl_pic\"  required=\"yes\"  />\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<br>\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary btn-xl js-scroll-trigger\"  value=\"Register\" onclick=\"return register()\"/>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t<!-- </div>\n");
      out.write("\t\t\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div> -->\n");
      out.write("    </section>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("   <br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("   \n");
      out.write("    <section id=\"contact\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("  \n");
      out.write("          <div class=\"col-lg-8 mx-auto text-center\">\n");
      out.write("            <h2 class=\"section-heading\">User Login</h2>\n");
      out.write("                <center>\n");
      out.write("             <hr class=\"my-4\">\n");
      out.write("               \n");
      out.write("            <form class=\"login active\" action=\"");
      out.print(request.getContextPath());
      out.write("/userloginaction\" method=\"get\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 130px\">\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 30px;height: 40px;\">User ID:</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user_id\" id=\"userid\" required=\"yes\"/>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" name=\"login\" value=\"Get Authentication share2\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\n");
      out.write("\t  \t\t<br> <br>\n");
      out.write("\t  \t\t<input type=\"submit\" name=\"login\" value=\"Authenticate\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</form> \n");
      out.write("\t\t\t\t\t\t\t\t\t\t ");

    
   	if(no==2)
    {
      out.write("\n");
      out.write("\t\t\t\t\t ");

	if(loginstatus==null)
	{
		
	}

	else if(loginstatus.equals("failed"))
	{
		
      out.write("\n");
      out.write("\t<br><br><br>\t\n");
      out.write("\t<center><h4><font color=red>Login Failed, Invalid User!!!</font></h4></center>\n");

	}


      out.write(" \t   \n");
      out.write("\n");


	if(passstatus==null)
	{
		
	}

	else if(passstatus.equals("success"))
	{
		
      out.write("\n");
      out.write("\t<br><br>\t\n");
      out.write("\t<center><b><a href=\"");
      out.print(request.getContextPath());
      out.write("/download\">Click here to Download share II</a></b></center>\n");

	}
	else if(passstatus.equals("failure"))
	{

      out.write(" \t  \n");
      out.write("\t<br><br>\t\n");
      out.write("\t<center><h4><font color=red>Invalid user id or password not yet assigned !</font></h4></center>\n");

	}

      out.write('\n');
      out.write('\n');

	if(mergeSatus==null)
	{
		
	}

	else
	{
	
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t\t<h4><font color=green> \n");
      out.write("\t\t\n");
      out.write("\t\tChoose Share1 and Share2 Image To Merge</font></h4>\n");
      out.write("\t\t\n");
      out.write("\t\t<div style=\"left:200\">\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/MergeImage\" id=\"quotem\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("\t\t\n");
      out.write("\n");
      out.write("\t  \t\tChoose Share1 &nbsp;&nbsp;&nbsp;\n");
      out.write("\t  \t\t<input type=\"file\" name=\"share1\" size=\"10\" /> \n");
      out.write("\t  \t\t<br>\n");
      out.write("\t  \t\n");
      out.write("\t  \t\tChoose Share2 &nbsp;&nbsp;&nbsp;\n");
      out.write("\t  \t\t<input type=\"file\" name=\"share2\" size=\"10\" /> \n");
      out.write("\t  \t\t<br>\n");
      out.write("\t  \t\t<input type=\"submit\" value=\"Merge\">\n");
      out.write("\t  \t\t<br> <br>\n");
      out.write("\t  \t\t\n");
      out.write("\t  \t\t</form>\n");
      out.write("\t  \t\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");

	}


      out.write(" \t\n");
      out.write("\n");

	if(mergingStatus==null)
	{
		
	}

	else
	{
		share1_file = request.getAttribute("share1").toString();
		share2_file = request.getAttribute("share2").toString();
	
      out.write("\n");
      out.write("\t\n");
      out.write("\t<center>\n");
      out.write("\t         <br>\n");
      out.write("\t         <form  action=\"");
      out.print(request.getContextPath() );
      out.write("/OCR\" id=\"quotem\" method=\"post\">\n");
      out.write("\t         <font color=\"green\" size=\"4\"> Your Authenticated Image Details </font>\n");
      out.write("\t          \n");
      out.write("\t            <table>\n");
      out.write("\t\t\t\t         <tr>\n");
      out.write("\t\t\t\t                 <td align=\"center\">\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/");
      out.print(share1_file);
      out.write("\" width=\"100px\" height=\"100px\">\n");
      out.write("\t\t\t\t                 \t   <br>\n");
      out.write("\t\t\t\t                 \t  Share1 Image\n");
      out.write("\t\t\t\t                 \t  \n");
      out.write("\t\t\t\t                 \t\n");
      out.write("\t\t\t\t                 </td>\n");
      out.write("\t\t\t\t                 \n");
      out.write("\t\t\t\t                 <td align=\"center\">\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/");
      out.print(share2_file );
      out.write("\" width=\"100px\" height=\"100px\">\n");
      out.write("\t\t\t\t                 \t   <br>\n");
      out.write("\t\t\t\t                 \t  Share2 Image\n");
      out.write("\t\t\t\t                 \t  \n");
      out.write("\t\t\t\t                 \t\n");
      out.write("\t\t\t\t                 </td>\n");
      out.write("\t\t\t\t                  \n");
      out.write("\t\t\t\t                  <td align=\"center\">\n");
      out.write("\t\t\t\t                  <br>\n");
      out.write("\t\t\t\t               \n");
      out.write("\t\t\t\t                  \n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/image_vc/Merged/res.png\" width=\"100px\" height=\"100px\">\n");
      out.write("\t\t\t\t                 \t \n");
      out.write("\t\t\t\t                 \t  Your Authenticated Image\n");
      out.write("\t\t\t\t                 \t  \n");
      out.write("\t\t\t\t                 \t\n");
      out.write("\t\t\t\t                 </td>\n");
      out.write("\t\t\t\t                 \n");
      out.write("\t\t\t\t                  <td align=\"center\">\n");
      out.write("\t\t\t\t             <input type=\"submit\" name=\"login\" value=\"OCR_Process\">   \t  \n");
      out.write("\t\t\t\t                 \t   \n");
      out.write("\t\t\t\t                 \t\n");
      out.write("\t\t\t\t                 </td>\n");
      out.write("\t\t\t\t         </tr>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t        \n");
      out.write("\t\t\t\t        \n");
      out.write("\t\t\t\t                 \n");
      out.write("\t\t\t\t                 \n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t </table>\n");
      out.write("\t\t\t\t </form>\n");
      out.write("\t</center>\n");
      out.write("\n");

}

      out.write("   \n");
      out.write("\t \n");
      out.write("\t  \t \n");
      out.write("\t  \t \n");
      out.write("\t  \t \n");
      out.write("\t  \t \n");
      out.write("   \t\t\n");
      out.write("   \t");

   	
   	}
   	
   	
   	
   	
   	
   	
   	
	else if(no==3)
   	{
   		
      out.write("\n");
      out.write("\t\t<center><h4><font color=red> OCR ID and USER ID is Not matching !</font></h4></center>\n");
      out.write("\t\t\n");
      out.write("\t");
	
		
   	}
   	
      out.write("\n");
      out.write("     \n");
      out.write("\t\t\t\t\t</center>\n");
      out.write("\t\t\t\t\t </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript -->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Plugin JavaScript -->\n");
      out.write("    <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("    <script src=\"vendor/scrollreveal/scrollreveal.min.js\"></script>\n");
      out.write("    <script src=\"vendor/magnific-popup/jquery.magnific-popup.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom scripts for this template -->\n");
      out.write("    <script src=\"js/creative.min.js\"></script>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\n");
      out.write("</html>\n");
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

package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Dao.GroupDAO;

public final class request_002dposting_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Res/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Res/JS/jquery-1.6.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function getReq(timeoutPeriod) \r\n");
      out.write("{\r\n");
      out.write("\tsetTimeout(\"location.reload(true);\",timeoutPeriod);\r\n");
      out.write("}\r\n");
      out.write("function change(val)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\tif(val==\"req\")\r\n");
      out.write("\t\tdocument.getElementById('request').className='redcolor';\r\n");
      out.write("\telse if(val==\"msg\")\r\n");
      out.write("\t\tdocument.getElementById('msg').className='redcolor';\r\n");
      out.write("\telse if(val==\"upd\")\r\n");
      out.write("\t\tdocument.getElementById('upd').className='redcolor';\r\n");
      out.write("}\r\n");
      out.write("function change1(val)\r\n");
      out.write("{\r\n");
      out.write("\tif(val==\"req\")\r\n");
      out.write("\t\tdocument.getElementById('request').className='Ncolor';\r\n");
      out.write("\telse if(val==\"msg\")\r\n");
      out.write("\t\tdocument.getElementById('msg').className='Ncolor';\r\n");
      out.write("\telse if(val==\"upd\")\r\n");
      out.write("\t\tdocument.getElementById('upd').className='Ncolor';\r\n");
      out.write("}\r\n");
      out.write("function call(val,user)\r\n");
      out.write("{\r\n");
      out.write("\tif(val==\"req\")\r\n");
      out.write("\t\ttop.frames['afrm'].location.href = 'post_request.jsp?user='+user;\r\n");
      out.write("\telse if(val==\"upd\")\r\n");
      out.write("\t\ttop.frames['afrm'].location.href = 'update.jsp?user='+user;\r\n");
      out.write("\telse if(val==\"msg\")\r\n");
      out.write("\t\ttop.frames['afrm'].location.href = 'msg.htm';\r\n");
      out.write("}\r\n");
      out.write("</script>\t\r\n");


	String user=(String)session.getAttribute("user_id");
	String status=GroupDAO.chk_post_req_Status(user);
	if(status.equalsIgnoreCase("pending"))
	{
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$('a#arequest').trigger('click');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");
}
	boolean update=GroupDAO.chkUpdate(user);
	if(update)
	{
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$('a#aupd').trigger('click');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");
}

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<body onload=\"JavaScript:getReq(5000);\">\r\n");
      out.write("<a href=\"#\" id=\"arequest\" onclick=\"change('req');\"></a>\r\n");
      out.write("<a href=\"#\" id=\"amsg\" onclick=\"change('msg');\"></a>\r\n");
      out.write("<a href=\"#\" id=\"aupd\" onclick=\"change('upd');\"></a>\r\n");
      out.write("\r\n");
      out.write("\t<a href=\"#\" onclick=\"call('req','");
      out.print(user );
      out.write("');\"><img id=\"request\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Res/Images/req.png\" style=\"position: absolute;top:-05px;\"></img></a>\r\n");
      out.write("\t");
      out.write("\r\n");
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

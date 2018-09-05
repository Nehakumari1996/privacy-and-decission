package org.apache.jsp.Res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Dao.*;
import java.sql.ResultSet;

public final class ocrgenerate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/pagenationcss.css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/pagenation.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
String usercode="",userid="",userid_img="",emailid="";
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t   \r\n");
      out.write("\t   \t\t<div class=\"CSSTableGenerator\"  style=\"width:200px;height:150px; left:100px; position:absolute; top:120px\">\r\n");
      out.write("\r\n");
      out.write("\t   \t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/adduseraction\" onsubmit=\"return checkFormValidator()\"  method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t   \t<h2 style=\"color:#069\">Generate OCR Key</h2>\r\n");
      out.write("\t  \r\n");
      out.write("\t   \t\t<td  style=\"width: 40px;\"><h3 style=\"color:#069\">Select Userid</h3></td>\r\n");
      out.write("\t   \t\t<td><select id=\"parent\" name=\"user_id\" style=\"width: 120px;\" required=\"yes\"><option value=\"0\" >Userid</option>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t");

	   		ResultSet rs=ImageDAO.selectuid();
		   	while(rs.next())
		   	{
		   	
      out.write("\r\n");
      out.write("\t\t   \t\t<option value=\"");
      out.print(rs.getString(5));
      out.write('"');
      out.write('>');
      out.print(rs.getString(5) );
      out.write("</option>\r\n");
      out.write("\t   \t\t");
} 
      out.write(" \r\n");
      out.write("\t   \t\t</select>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t</td>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t \t\r\n");
      out.write("\t   \t\t<!-- \r\n");
      out.write("\t   \t\t\t<td><h3 style=\"color:#069\">User Id(Image)</h3></td>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"file\" name=\"user_id_image\" id=\"address\" style=\"width: 100px;\" required=\"yes\"></input>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</br></br>\t -->\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t<td  style=\"width: 100px;\">\r\n");
      out.write("\t   \t\t<input type=\"submit\" id=\"add\" name=\"submit\" value=\"Add\" onclick=\"return Check()\">\r\n");
      out.write("\t   \t\t</input>\r\n");
      out.write("\t   \t\t</td>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t </table> \r\n");
      out.write("\t   \t\t</form>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t   \t\t\t\t\r\n");
      out.write("\t   \t<div id=\"pageNavPosition\"  style=\"position: absolute;top: 460px;left: 150px; height:150px;\" ></div>  \r\n");
      out.write("<br />  \r\n");
      out.write("<script type=\"text/javascript\"><!--  \r\n");
      out.write("        var pager = new Pager('results', 4); \r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("        pager.init();   \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition');   \r\n");
      out.write("        pager.showPage(1);  \r\n");
      out.write("    //--></script>  \r\n");
      out.write("\t\r\n");
      out.write("\t  <br class=\"balnk\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");

	String status=null;
	status=request.getParameter("status");
	if(status!=null)
	{
		int n=Integer.parseInt(status);
		if(n==1)
		{
      out.write("\r\n");
      out.write("\t\t\t<script >alert(\"OCR Generated Sucessfully \")</script>\r\n");
      out.write("\t");
 }else if(n==2)
	{
      out.write("\r\n");
      out.write("\t\t<script >alert(\"Content Edited Sucessfully\")</script>\r\n");
      out.write("\t");
}else if(n==3)
	{
      out.write("\r\n");
      out.write("\t\t<script >alert(\"Content Deleted Sucessfully\")</script>\r\n");
      out.write("\t");
}}
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \t  \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

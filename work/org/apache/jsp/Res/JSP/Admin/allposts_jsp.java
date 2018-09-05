package org.apache.jsp.Res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Dao.ImageDAO;
import java.sql.Connection;
import com.DataBase.DBConnection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public final class allposts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				ResultSet rs1=null;
				String sql="";
				int count=0;
				int i=0;
				int j=0;
				
				
				ArrayList arr_name=new ArrayList();
				ArrayList arr_profile=new ArrayList();
				ArrayList<Integer> arr_icode=new ArrayList<Integer>();
				ArrayList arr_fname=new ArrayList();
				ArrayList arr_comment=new ArrayList();
				
			
			
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
      out.write("\r\n");
      out.write("   \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/menu.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\" media=\"screen\">\r\n");
      out.write("\t#menuh{float:none;}\r\n");
      out.write("\tbody{behavior:url(csshover.htc); font-size:75%;  }\r\n");
      out.write("\t#menuh ul li{float:left; width: 70%;}\r\n");
      out.write("\t#menuh a{height:1%;font:normal 1em/1.6em  helvetica,  \"Trebuchet MS\", arial, sans-serif;}\r\n");
      out.write("</style>\r\n");

response.setIntHeader("Refresh",7);

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("\t\t<div id=\"container\">\r\n");
      out.write("\t\t<div id=\"content\" style=\"padding-top: 30px;padding-right: 10px;\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

					con=DBConnection.getConnection();
					st=con.createStatement();
					
					rs=ImageDAO.AllPosts();
					while(rs.next())
					{
						
						arr_name.add(rs.getString(1));
						arr_profile.add(rs.getString(2));
						arr_icode.add(rs.getInt(3));
						arr_fname.add(rs.getString(4));
					}
					
					if(count==0)
					{
						for(;i<arr_name.size();i++)
						{
							
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<!---------------------------------- User Profile and User name and Uploaded Image  ------------------------------->\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr style=\"margin-top: 60px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span style=\"color:navy;font-family: georgia,sans-serif;font-weight: bold;\">");
      out.print(arr_name.get(i) );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr ><td ><img src=\"");
      out.print(request.getContextPath());
      out.write("/user_input_image/");
      out.print(arr_fname.get(i));
      out.write("\" ></img></td></tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-------------------------------------------- Corresponding image Comments  ------------------------------->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div style=\"\">\r\n");
      out.write("\t\t\t\t\t\t");
 	
							int i_code= arr_icode.get(i);
							//System.out.println("i_code is-------->"+i_code);
							String sql="select u.u_name,c.tag from m_tag c join m_user u on u.u_code=c.u_code where i_code='"+i_code+"'";
							//System.out.println(sql);
							rs=st.executeQuery(sql);
							while(rs.next())
							{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<table  style=\"background-color: #EEE9E9;\twidth: 400px; padding-left: 20px;\"  >\r\n");
      out.write("\t\t\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"20px\" ><span style=\"color:navy;font-family: georgia,sans-serif;font-weight: bold;\">");
      out.print(rs.getString(1) );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr><td colspan=\"2\"><hr color=\"white\" size=\"2\" align=\"right\"></hr></td></tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!---------------------------------------------- User Comments  ------------------------------->\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t");
 }	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 }
						
						i=arr_name.size();
						} 
					
						
      out.write("\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t\r\n");
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

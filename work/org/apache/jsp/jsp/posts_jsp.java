package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Dao.LoginDao;
import com.Dao.ImageDAO;
import java.sql.Connection;
import com.DataBase.DBConnection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public final class posts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				ResultSet rs1=null;
				String sql="";
				int count=0;
				int i=0;
				int j=0;
				
				
				ArrayList<Object> arr_name=new ArrayList<Object>();
				ArrayList<Object>arr_profile=new ArrayList<Object>();
				ArrayList<Integer> arr_icode=new ArrayList<Integer>();
				ArrayList<Object> arr_fname=new ArrayList<Object>();
				ArrayList<Object>arr_comment=new ArrayList<Object>();
				
			
			
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
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("/css/menu.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/CSS/button.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/CSS/message.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\" media=\"screen\">\r\n");
      out.write("#menuh {\r\n");
      out.write("\tfloat: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tbehavior: url(csshover.htc);\r\n");
      out.write("\tfont-size: 75%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#menuh ul li {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#menuh a {\r\n");
      out.write("\theight: 1%;\r\n");
      out.write("\tfont: normal 1em/1.6em helvetica, \"Trebuchet MS\", arial, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");

String x_name=(String)session.getAttribute("user_id"); 
String x_profile=(String)session.getAttribute("x_profile");		
response.setIntHeader("Refresh", 15);

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<div id=\"content\" style=\"padding-top: 30px; padding-right: 5px;\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

					con=DBConnection.getConnection();
					st=con.createStatement();
					String x_user_id=session.getAttribute("user_id").toString();
					
					String id=LoginDao.select_User_id(x_user_id);
					
					
					
					
						
					rs=ImageDAO.SelectPosts(x_user_id);
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
							
							boolean post_status=LoginDao.select_post_status(arr_icode.get(i).toString());
							if(post_status)
							{
							
					
      out.write("\r\n");
      out.write("\t\t\t<!---------------------------------- User Profile and User name and Uploaded Image  ------------------------------->\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr style=\"padding-top: 0px;\">\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-bottom: 60px;\">\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right: 100px;\">\r\n");
      out.write("\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/profile_pics/");
      out.print(arr_name.get(i));
      out.write('/');
      out.print(arr_profile.get(i));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\twidth=\"40px;\" height=\"40px;\"></img></td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: navy; font-family: georgia, sans-serif; font-weight: bold;\">");
      out.print(arr_name.get(i) );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/user_input_image/");
      out.print(arr_fname.get(i));
      out.write("\" width=\"80px;\" height=\"80px;\"></img></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-------------------------------------------- Corresponding image Comments  ------------------------------->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"padding-left: 140px;\">\r\n");
      out.write("\t\t\t\t");
 	
							int i_code= arr_icode.get(i);
							//System.out.println("i_code is-------->"+i_code);
							String sql="select u.u_name,c.tag from m_tag c join m_user u on u.u_code=c.u_code where i_code='"+i_code+"' order by c.time";
							System.out.println("----"+sql);
							rs=st.executeQuery(sql);
							while(rs.next())
							{ 
      out.write("\r\n");
      out.write("\t\t\t\t<table\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: #EEE9E9; width: 400px; padding-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"20px\"><span\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: navy; font-family: georgia, sans-serif; font-weight: bold;\">");
      out.print(rs.getString(1) );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(rs.getString(2) );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><hr color=\"white\" size=\"2\" align=\"right\"></hr></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!---------------------------------------------- User Comments  ------------------------------->\r\n");
      out.write("\t\t\t\t");
 }	
      out.write("\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/CommentSubmit1\"\r\n");
      out.write("\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t<table\r\n");
      out.write("\t\t\t\t\t\tstyle=\"background-color: #EEE9E9; width: 400px; padding-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"20px\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"color: navy; font-family: georgia, sans-serif; font-weight: bold;\">");
      out.print(x_name );
      out.write("</span></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<td><input id=\"s\" type=\"text\" name=\"comment\" size=\"45px\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Write a comment...\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"font-size: 10px; color: black;\" /> <input id=\"x\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"submit\" value=\"comment\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"hidden\" name=\"image_code\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.print(i_code );
      out.write("\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<hr color=\"white\" size=\"0.01\"></hr>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr size=\"0.01\" width=\"450px\" align=\"left\"></hr>\r\n");
      out.write("\t\t\t");
 }
					}		
						i=arr_name.size();
			  } 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
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

package com.Image;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;



import com.Dao.GroupDAO;
import com.Dao.ImageDAO;
import com.Dao.LoginDao;
import com.DataBase.DBConnection;
import com.Methods.ImageMethod;


public class CommentSubmit1 extends HttpServlet
{
	boolean flag=false;
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	static int count=0;
	static String v="";
	static int k=0;
	 String x_user_id="";
	 String m_image_code="";
	//int m=0;
	
	ArrayList<Integer> arr_tcode= new ArrayList<Integer>();
	ArrayList arr_topics= new ArrayList();
	
	String x_topics="";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		m_image_code=req.getParameter("image_code");
		String m_comment=req.getParameter("comment");
		String m_user=req.getParameter("user_id");
		
		
	
		System.out.println("code "+m_image_code);
		System.out.println("comment "+m_comment);
		System.out.println("m_user_name "+m_user);
		
		//----------------------------Storing comment into Table------------------------
		 HttpSession session=req.getSession(false);
		 
         x_user_id= (String) session.getAttribute("x_name");
         System.out.println("x_user_id  :"+x_user_id);
         String m_comment_low=m_comment.toLowerCase();
		 System.out.println("lowercase:"+m_comment_low);
		 
		
		 
		 
		 
		 
		 
		 flag=ImageDAO.CommentSubmit(x_user_id, m_image_code, m_comment);
		 resp.sendRedirect(req.getContextPath()+"/jsp/posts.jsp");
		
		
		
	}
	
}

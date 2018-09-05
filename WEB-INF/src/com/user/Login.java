package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;
import com.DataBase.DBConnection;

public class Login extends HttpServlet 
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	String x_name="";
	String x_profile="";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String m_userid=req.getParameter("userid");
		String m_pass=req.getParameter("password");
		
		RequestDispatcher rd=null;
		boolean flag=false;
		
		
		flag=LoginDao.login(m_userid, m_pass);
		System.out.println("Login status of user"+flag);
		
		if(flag)
		{
			try 
			{
				HttpSession sessionid=req.getSession(true);
				System.out.println("Login session is new---->"+sessionid.isNew());
				sessionid.setAttribute("user_id",m_userid);
				rs=LoginDao.loginusername(m_userid);
				while(rs.next())
				{
					 x_profile=rs.getString(1);
				}
				sessionid.setAttribute("user_id", m_userid);
				sessionid.setAttribute("x_profile", x_profile);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath()+"/jsp/home_page.jsp");
		}
		else
		{
			rd=req.getRequestDispatcher("/index.jsp?no=4");
			rd.forward(req,resp);
		}
		DBConnection.CloseConnection(rs, st, con);
		//System.out.println("connection closed");
	} 
}

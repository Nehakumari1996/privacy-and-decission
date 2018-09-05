package com.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataBase.DBConnection;


public class Logout extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
		
			session.invalidate();
			//System.out.println("session invalidate");
			
		}
		
			resp.sendRedirect(req.getContextPath()+"/index.jsp?no=3");
		
		
		
	}
}

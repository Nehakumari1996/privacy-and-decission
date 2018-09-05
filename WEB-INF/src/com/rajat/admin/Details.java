package com.rajat.admin;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Details extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	try
	{	
		String name=req.getParameter("name");
		System.out.println(name);
		
		ResultSet rs=Admin.getStatusByName(name);
		if(rs.next())
		{
			ResultSet rs1=Admin.getStatusByName(name);
			req.setAttribute("rs",rs1);
			RequestDispatcher rd=req.getRequestDispatcher("/Res/JSP/Admin/details.jsp?no=0");
			rd.forward(req, resp);
		}
		else
			resp.sendRedirect(req.getContextPath()+"/Res/JSP/Admin/details.jsp?no=1");
		
			
		
		
	}

	catch(Exception e)
	{
		System.out.println("Error in Details servlet..."+e);
	}
}
}
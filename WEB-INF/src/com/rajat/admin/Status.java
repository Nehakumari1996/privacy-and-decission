package com.rajat.admin;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Status extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try
		{
		
		System.out.println("\n\n************************\n************************");
		System.out.println("CHECKING STARTS\n\n");
		System.out.println("we are in the status servlet it starts now");
		
		//Admin.UpdateStatusFirstStage();
		//Admin.UpdateStatusSecondStage();
		
		System.out.println("\n\nCHECKING ENDS\n\n");
		System.out.println("\n\n************************\n************************");
		ResultSet rs=Admin.getStatus();
		if(rs.next())
		{
			ResultSet rs1=Admin.getStatus();
			req.setAttribute("rs",rs1);
			RequestDispatcher rd=req.getRequestDispatcher("/Res/JSP/Admin/status.jsp?no=0");
			rd.forward(req, resp);
		}
		else
			resp.sendRedirect(req.getContextPath()+"/Res/JSP/Admin/status.jsp?no=2");
		
			
		}
		catch(Exception e)
		{
			System.out.println("Oops error in status.java "+e);
		}
		
	}
	
	

}

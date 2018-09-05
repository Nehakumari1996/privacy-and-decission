package com.rajat.admin;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		try
		{
			boolean result=false;
			RequestDispatcher rd=null;
		String username=req.getParameter("name");
		int u_code=Admin.getUserCode(username);
		
		System.out.println("Deleting Details of user---"+username+"---And its user code---"+u_code);
		
		result=Admin.deleteUser(u_code);
		
		System.out.println("\n************************\n Deleting user Queries\n\n");
		Admin.deleteUserFrom_m_update(username);
		Admin.deleteUserFrom_m_status(username);
		Admin.deleteUserFrom_m_request(username);
		Admin.deleteUserFrom_m_image(u_code);
		Admin.deleteUserFrom_m_tag(u_code);
		Admin.deleteUserFrom_m_group(username);
		
		System.out.println("\n\n***********************************\n\n");
		
		if(result)
		{
			ResultSet rs1=Admin.getStatus();
			req.setAttribute("rs",rs1);
			rd=req.getRequestDispatcher("/Res/JSP/Admin/status.jsp?no=0&no1=1");
			rd.forward(req, resp);
		
		}
		else
		{
			ResultSet rs1=Admin.getStatus();
			req.setAttribute("rs",rs1);
			rd=req.getRequestDispatcher("/Res/JSP/Admin/status.jsp?no=0&no1=2");
			rd.forward(req, resp);
			
			
		}
		
		}
		
		catch(Exception e)
		{
			System.out.println("Error in deleting user...."+e);
		}
		
	}

}

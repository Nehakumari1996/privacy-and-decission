/**
 * 
 */
package com.rajat.admin;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String name=request.getParameter("userid");
			System.out.println("username is>>>>>>>>>>>>>"+name);
			String pass=request.getParameter("password");
			System.out.println("pass is>>>>>>>>>>>>>"+pass);
			
			boolean result=Admin.loginCHK(name, pass);
	
			if(result)
			{
				HttpSession session=request.getSession(true);
				
				System.out.println("Admin session is new-->"+session.isNew());
				
				request.setAttribute("admin", name);
				session.setAttribute("admin", name);
				
				RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/home.jsp");
				rd.forward(request, response);
			}
			else
				
				response.sendRedirect("index.jsp?no=2");
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in AdminLogin Servlet......"+e);
			out.println("Opps's Error is in AdminLogin Servlet......"+e);
		}
	}
}

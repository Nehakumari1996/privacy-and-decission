/**
 * 
 */
package com.rajat.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author rajat Gudle
 *Apr 10, 2012 4:26:38 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.rajat.action.user
 *File:-Profile.java
 */
public class Profile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("admin");
			System.out.println(name);
			ResultSet rs=Admin.getProfile(name);
			if(rs.next())
			{
				rs=Admin.getProfile(name);
				request.setAttribute("rs",rs);
				RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"/Res/JSP/Admin/profile.jsp?no=1");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserProfile Servlet......"+e);
			out.println("Opps's Error is in UserProfile Servlet......"+e);
		}
	}
}

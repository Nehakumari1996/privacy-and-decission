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


public class EditProfile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			HttpSession session=request.getSession(false);
			int no=Integer.parseInt(request.getParameter("no"));
		
			if(no==1)
			{
				String name=(String)session.getAttribute("admin");
				System.out.println("NAme isss--->"+name);
				ResultSet rs=Admin.getProfile(name);
				if(rs.next())
				{
					rs=Admin.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/Res/JSP/Admin/editprof.jsp?no=1");

			}
			if(no==2)
			{
				String name=com.Image.Utility.parse1(session.getAttribute("admin"));
				String [] s=new String [4];
				s[0] =request.getParameter("id");
				s[1]=request.getParameter("userid");
				s[2]=request.getParameter("email");
				s[3]=request.getParameter("phone");
				boolean result=Admin.editProfile(s);
				if(result)
				{
					ResultSet rs=Admin.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					
					RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/Admin/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/Res/JSP/Admin/editprof.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User EditProfile Servlet......"+e);
			out.println("Opps's Error is in User EditProfile Servlet......"+e);
		}
	}
}

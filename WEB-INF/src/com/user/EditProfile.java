/**
 * 
 */
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;
import com.Image.Utility;



/**
 * @author rajat Gudle
 *Apr 10, 2012 4:37:17 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.rajat.action.user
 *File:-EditProfile.java
 */
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
				String name=request.getParameter("name");
				ResultSet rs=LoginDao.getProfile(name);
				if(rs.next())
				{
					rs=LoginDao.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditProfile.jsp?no=0");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/jsp/EditProfile.jsp?no=1");

			}
			if(no==2)
			{
				String name=Utility.parse1(session.getAttribute("x_user_id"));
				String [] s=new String [4];
				s[0] =request.getParameter("id");
				s[1]=request.getParameter("email");
				s[2]=request.getParameter("phone");
				s[3]=request.getParameter("gender");
				boolean result=LoginDao.editProfile(s);
				if(result)
				{
					ResultSet rs=LoginDao.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/jsp/EditProfile.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User EditProfile Servlet......"+e);
			out.println("Opps's Error is in User EditProfile Servlet......"+e);
		}
	}
}

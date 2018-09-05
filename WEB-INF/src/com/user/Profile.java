package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.Dao.ImageDAO;
import com.Dao.LoginDao;


public class Profile extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("user_id");
			System.out.println(name);
			
			ResultSet rs=LoginDao.getProfile(name);
			if(rs.next())
			{
				rs=LoginDao.getProfile(name);
				request.setAttribute("rs",rs);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"/jsp/profile.jsp?no=1");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserProfile Servlet......"+e);
			out.println("Opps's Error is in UserProfile Servlet......"+e);
		}
	}
}

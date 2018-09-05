package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.GroupDAO;


public class GroupDetails extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String user=request.getParameter("name");
			System.out.println("name is "+user);
			int no=Integer.parseInt(request.getParameter("no")) ;
			
		
			if(no==1)
			{	
				ResultSet rs=GroupDAO.getUser(user);
				request.setAttribute("rs",rs);
				request.setAttribute("user", user);
				//System.out.println("222222222222222222222");
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/group-details.jsp?no=2");
				rd.forward(request, response);
			}
			else
				if(no==11)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/success.jsp?no=1");
					rd.forward(request, response);
				}else
				{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/success.jsp?no=2");
				rd.forward(request, response);
			}
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in GroupDetails Servlet......"+e);
			out.println("Opps's Error is in GroupDetails Servlet......"+e);
		}
	}
}
package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.GroupDAO;
import com.Dao.StatusDAO;


public class SendRequest extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String from=request.getParameter("from");
			String to=request.getParameter("to");
			boolean result=GroupDAO.sendReq(from, to);
			if(result)
			{
				result=StatusDAO.updateToatalRequests(from);
			}
			if(result)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/GroupDetails?name='"+from+"'&no=11");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/group-details.jsp?no=1");
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
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.GroupDAO;
import com.Dao.StatusDAO;


public class CreateGroup extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String task=request.getParameter("task");
			if(task.equalsIgnoreCase("delete"))
			{
				String grp_in=request.getParameter("grp_in");
				String grp_uid=request.getParameter("grp_uid");
				boolean result=GroupDAO.rmvGrp(grp_in, grp_uid);
				if(result)
				{
					GroupDAO.update(grp_uid, grp_in, grp_uid+" Has Un-Friend you!!!");
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/success.jsp?no=50");
					rd.forward(request, response);
				}
			}
			else if(task.equalsIgnoreCase("Accept"))
			{
				String from=request.getParameter("from");
				String to=request.getParameter("to");
				boolean result=GroupDAO.processRequest(from, to);
				if(result)
				{
					GroupDAO.changeStatus(from, to, "accepted");
					GroupDAO.update(to, from, to+" Has Accepted Your Request");
					StatusDAO.updateAcceptRequests(from);
					response.sendRedirect(request.getContextPath()+"/jsp/request.jsp?user="+to);
				}
			}
			else if(task.equalsIgnoreCase("Reject"))
			{
				String from=request.getParameter("from");
				String to=request.getParameter("to");
				GroupDAO.changeStatus(from, to, "rejected");
				GroupDAO.update(to, from, to+" Has Denied Your Request");
				StatusDAO.updateRejectRequests(from);
				response.sendRedirect(request.getContextPath()+"/jsp/request.jsp?user="+to);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in GroupDetails Servlet......"+e);
			out.println("Opps's Error is in GroupDetails Servlet......"+e);
		}
	}
}
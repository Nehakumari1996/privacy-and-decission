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


public class Update_post extends HttpServlet 
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
				
			}
			else if(task.equalsIgnoreCase("Accept"))
			{
				String from=request.getParameter("from");
				String to=request.getParameter("to");
				
				String p_id=request.getParameter("p_id");
				
					GroupDAO.change_post_Status(from, to, "accepted",p_id);
					
				
					GroupDAO.update_m_pos_status(p_id);
					GroupDAO.change_main_post_Status(p_id);
					
					response.sendRedirect(request.getContextPath()+"/jsp/post_request.jsp?user="+to);
			
			}
			else if(task.equalsIgnoreCase("Reject"))
			{
				String from=request.getParameter("from");
				String to=request.getParameter("to");
				String p_id=request.getParameter("p_id");
				
				GroupDAO.change_post_Status(from, to, "rejected",p_id);
			
				GroupDAO.update_m_neg_status(p_id);
				
				
				GroupDAO.update_m_pos_status(p_id);
				GroupDAO.change_main_post_Status(p_id);
				
				response.sendRedirect(request.getContextPath()+"/jsp/post_request.jsp?user="+to);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in GroupDetails Servlet......"+e);
			out.println("Opps's Error is in GroupDetails Servlet......"+e);
		}
	}
}
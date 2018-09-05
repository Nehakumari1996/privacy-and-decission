
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;




public class ChangePass extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			if(no==1)
			{
				String name=request.getParameter("name");
				request.setAttribute("user",name);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/ChangePass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				String user=request.getParameter("user");
				request.setAttribute("user", user);
				boolean result=LoginDao.loginCHK(user, pass);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=LoginDao.chnagePass(id, cpass);
						
						boolean	result11=LoginDao.chnagePassword(id, cpass);
						if(result && result11)
						{
							ResultSet rs=LoginDao.getProfile(user);
							request.setAttribute("rs",rs);
							
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/profile.jsp?no=0&no1=1");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/ChangePass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/ChangePass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/ChangePass.jsp?no=1");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User ChangePass Servlet......"+e);
			out.println("Opps's Error is in User ChangePass Servlet......"+e);
		}
	}
}


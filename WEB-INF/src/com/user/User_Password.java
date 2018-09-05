package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;


public class User_Password extends HttpServlet
{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		 HttpSession session = request.getSession();
		 RequestDispatcher rd;
			
		 String userid =  session.getAttribute("user_id").toString().trim();

String pass=request.getParameter("password");

try {
	
	int k=LoginDao.checkUserpass(userid,pass);
	//int k=adduserdao.checkUserpass(userid,pass);
	if (k==1)
    {
       
       
       rd=request.getRequestDispatcher("/jsp/home_page.jsp");
       rd.forward(request,response);
    }
    else if(k==0)
    {
       
       rd=request.getRequestDispatcher("password.jsp");
       rd.forward(request,response);
    }
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
}

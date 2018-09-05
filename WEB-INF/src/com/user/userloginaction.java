package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Statement;
import com.Dao.LoginDao;





public class userloginaction extends HttpServlet {
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public userloginaction() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("its came inside the userloginaction");
		PrintWriter out = response.getWriter();
		
        int flag=0;
        String name="",code="";
        RequestDispatcher rd;
		HttpSession hs1=request.getSession();
		

        
		String user_id=request.getParameter("user_id");
		 hs1.setAttribute("user_id",user_id);
		
		System.out.println("user_id >>>>>>>>>>>>>>>>"+user_id);
		String user_pwd=request.getParameter("user_password");
		System.out.println("user_pwd is>>>>>>>>>>>>>>"+user_pwd);
		String button=request.getParameter("login").trim();
		
		
		if(button.equals("Login"))
		{
			try {
				flag=LoginDao.logindao(user_id, user_pwd);
			//flag=userdao.logindao(user_id, user_pwd,ip);
	        if (flag==1)
	        {
	        	 name=LoginDao.username(user_id);
	        	
	         //  name=userdao.username(user_id);
	        	 code=LoginDao.code(user_id);
	          // code=userdao.code(user_id);
	           System.out.println("Code in login Action : "+code);
	           hs1.setAttribute("user_id",user_id);
	           hs1.setAttribute("user_code",code);
	           hs1.setAttribute("user_code1",code);
	           hs1.setAttribute("user_name",name);
	           hs1.setAttribute("user_pwd",user_pwd);
	       
	           rd=request.getRequestDispatcher("userhome.jsp");
	           rd.forward(request,response);
	        }
	        else if(flag==0)
	        {
	           hs1.setAttribute("loginstatus","failed");
	           rd=request.getRequestDispatcher("userinvalid.jsp");
	           rd.forward(request,response);
	        }
	       
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally { 
	            out.close();
	        }
		}
		else if(button.equals("Authenticate"))
		{
			 request.setAttribute("mergeSatus","merge");
			 rd=request.getRequestDispatcher("index.jsp?no=2");
	         rd.forward(request,response);
		}
		else 
		{
			try
			{
				//ImageDAO idao = new ImageDAOImplementaion();
				//String imgCode = idao.checkUser(user_id);
				String imgCode=LoginDao.checkUser(user_id);
				System.out.println("imgCode is>>>>>>>>>>>>>>> "+imgCode);
				if(imgCode.equals(""))
				{
					
					
					System.out.println("Invalid user id or password not yet assigned !");
					request.setAttribute("passstatus","failure");
			        rd=request.getRequestDispatcher("index.jsp?no=2");
			        rd.forward(request,response);
					
					
				}
				else 
				{
					System.out.println("-----------------------");
					request.setAttribute("passstatus","success");
					hs1.setAttribute("userid", user_id);
			        rd=request.getRequestDispatcher("index.jsp?no=2");
			        rd.forward(request,response);
				}
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
			
		}
        
	}
}

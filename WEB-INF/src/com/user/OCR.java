package com.user;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;


import simpleregiongrowing.SimpleRegionGrowing;

public class OCR extends HttpServlet
{
	
	public static Output_Bean ocrop=new Output_Bean();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		// HttpSession session = request.getSession();
		 RequestDispatcher rd;
			
		/* String userid =  session.getAttribute("userid").toString().trim();
	System.out.println("userid is>>>>>>from session ans in ocr>>>>>>>>>"+userid);*/
	
			System.out.println("its came inside ocr servlet");
			

	        HttpSession session = request.getSession();
	        String userid =  ((String) session.getAttribute("user_id")).trim();
	        System.out.println("userid>>>>>>>>>>>"+userid);
	     
	
		String usersharePath = request.getRealPath("")+"\\image_vc\\Merged\\res.png";
		String userreginPath = request.getRealPath("")+"\\image_vc\\Merged\\rgngrwing.png";
		
		try {
			SimpleRegionGrowing.do_RegionGrowing(usersharePath,userreginPath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String out_binaty=request.getRealPath("")+"\\image_vc\\Merged\\binary.png";
		Binory_Image_Convert.convert2(userreginPath,out_binaty);
		
		boolean f= SendImageFname(out_binaty+"~~"+userid);
		if(f)
		{
		try {
			Thread.sleep(10000);
			
			
			String ocrid=LoginDao.selectocrid(userid);
			
			if(ocrid.trim().equals(userid.trim()))
			{
				
				request.setAttribute("share1",userid+"_1.png");
            	request.setAttribute("share2",userid+"_2.png");
				request.setAttribute("ocrstatus","success");
				session.setAttribute("user_id",userid);
		        rd=request.getRequestDispatcher("password.jsp");
		        
					rd.forward(request,response);
				
			}
			else
			{
				request.setAttribute("passstatus","failure");
		        rd=request.getRequestDispatcher("index.jsp?no=2");
		        
		       
					rd.forward(request,response);
				
			}
			
		}
		catch (Exception e) 
		{
			request.setAttribute("passstatus","failure");
	        rd=request.getRequestDispatcher("index.jsp?no=2");
		}
		
		System.out.println(userid);
		}
		
		
		
	}
	
	public static boolean SendImageFname(String filepath)
	{
		Socket client;
		try 
		{
			System.out.println("============>  send");
			client = new Socket("localhost", 8689);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
			dos.writeUTF(filepath);
			dos.writeBoolean(true);
			dos.flush();
			dos.close();
			client.close();
		} 
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
			
}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		doPost(request, response);
	}
	
	

	}

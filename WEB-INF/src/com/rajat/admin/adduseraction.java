package com.rajat.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.Dao.ImageDAO;
import com.Dao.LoginDao;

import com.util.CL_SendMail;
import com.util.ImageInputDetails;

/**
 * Servlet implementation class adduseraction
 */
public class adduseraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduseraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    int flag=0,check=0;
	    RequestDispatcher rd;
		HttpSession hs=request.getSession();
		

	    try {
	    	
	    	FileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			List fileItems = null;
			try 
			{
				fileItems = servletFileUpload.parseRequest(request);
				
				System.out.println(fileItems);
			} 
			catch (FileUploadException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileItem file1 = (FileItem) fileItems.get(0);
			
		
	    	
	    String user_id=file1.getString();	
	    System.out.println("userid is>>>>>>>>>>>"+user_id);
	    
	    hs.setAttribute("user_id","user_id");
	    
	    
	    
	    
	   
	  
	    
	    String uidimg=user_id+".jpg";
	    System.out.println("uidimg is>>>>>>>>>>>"+uidimg);
	
	   
		String user_email=ImageDAO.selectumail(user_id);
		System.out.println("email is>>>>>>>>>>"+user_email);
		
		
		
		String source=request.getRealPath("")+"//image_vc//Original_Images//";
		Text_Image_Conversion.convert(user_id,source+"/"+user_id+".jpg");
		String share1path=request.getRealPath("")+"//image_vc//Share1_DB//";
		
		String share2path=request.getRealPath("")+"//image_vc//Share2_DB//";
		
		
		
		String message="<html> <br> <b> <h3> Download Share 1 Image for to login  !</h3> </b> </html>";
		
		
		
		//check=adduserdao.checkid(user_id);
		
		//if(check==0)
			//{
			    flag=LoginDao.adduidimg(uidimg,user_id);
			    if (flag==1)
			    {
			    	System.out.println("its came inside if loop");
			    	
			    	ImageInputDetails.runProg(source+"/"+user_id+".jpg", user_id, 0,share1path,share2path);
			    	
			    	
                                String filepath = share1path+user_id+"_1.png";
					
					CL_SendMail.sendPersonalizedMail(user_email, "deduplication8@gmail.com", "Indian123", "Share I Image", message, filepath, "smtp.gmail.com", "465");
			
			    	
			    	
			    	hs.setAttribute("add","success");
					rd=request.getRequestDispatcher("/Res/JSP/Admin/ocrgenerate.jsp");
					rd.forward(request,response);
				}
			    else if(flag==0)
			    {
			    	hs.setAttribute("add","failed");
					rd=request.getRequestDispatcher("/Res/JSP/Admin/ocrgenerate.jsp");
					rd.forward(request,response);			    
				}
		//	}
		else if(check==1)
		{
			hs.setAttribute("userstatus","failed");
			rd=request.getRequestDispatcher("/Res/JSP/Admin/ocrgenerate.jsp");
			rd.forward(request,response);
		}
	   
	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
	        out.close();
	    }
	}

}

/**
 * 
 */
package com.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * @author Prasoon Kumar Mishra
 *
 */
public class MergeImage extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String val[]=new String[8];
			String files[]=new String[8];
			int i=0,count=0,num=0;
			String fileName="",root="",share1_file="",share2_file="";
			File f=null;
			ArrayList list = new ArrayList();
			RequestDispatcher rd;
			
			HttpSession session = request.getSession();
			
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            try
	            {
	            	List items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) 
	                {
	                	FileItem item = (FileItem) iterator.next();
	                	fileName = item.getName();
	                	list.add(fileName);
	                	System.out.println("----------------");
	                	System.out.println("File Name : " + fileName);
	                	
	                	String filepath = request.getRealPath("")+"\\image_vc\\Merged\\"+fileName;
	                	System.out.println("Path : " + filepath);
	                	File f1=new File(filepath);
	                	item.write(f1);
	                	
	                }
	                
	                if(list.size() == 2)
	                {
	                	share1_file = list.get(0).toString().trim();
	                	share2_file = list.get(1).toString().trim();
	                	
	                	System.out.println("Share1 File : " + share1_file);
	                	System.out.println("Share2 File : " + share2_file);
	                	
	                	String share1Path = request.getRealPath("")+"\\image_vc\\Merged\\"+share1_file;
	                	String share2Path = request.getRealPath("")+"\\image_vc\\Merged\\"+share2_file;
	                	String usersharePath = request.getRealPath("")+"\\image_vc\\Merged\\res.png";
	                	
	                	/* Merging The Share1 and Share2 Image  */
	                	com.util.MergeImage.mergeImage(share1Path, share2Path, usersharePath);
	                	
	                	request.setAttribute("mergingStatus","success");
	                	request.setAttribute("share1",share1_file);
	                	request.setAttribute("share2",share2_file);
				        rd=request.getRequestDispatcher("index.jsp?no=2");
				        rd.forward(request,response);
	                	
	                }
	                
	            }
	            catch(Exception e)
	            {
	            	System.err.println("Opps's Error is in User MergeImage Servlet......"+e);
	    			out.println("Opps's Error is in User MergeImage Servlet......"+e);
	            }
			}
		}
		catch(Exception e)
		{
			System.err.println("Opps's Error is in User MergeImage Servlet......"+e);
			out.println("Opps's Error is in User MergeImage Servlet......"+e);
		}
	}
}

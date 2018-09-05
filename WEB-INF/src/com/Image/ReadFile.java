package com.Image;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Dao.GroupDAO;
import com.Dao.ImageDAO;
import com.Dao.LoginDao;
import com.algorithm.SURFDetector;



public class ReadFile extends HttpServlet
{
	RequestDispatcher rd=null;
    ServletInputStream sis=null;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	  {
		/*ResultSet rs = null;
		String i_code="";
		String contentType = request.getContentType();
		
		PrintWriter out = response.getWriter();

		//here we are checking the content type is not equal to Null and as well as the passed data from mulitpart/form-data is greater than or equal to 0
		if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) 
		{
	 		DataInputStream in = new DataInputStream(request.getInputStream());
	 		
			//we are taking the length of Content type data
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			//this loop converting the uploaded file into byte code
			while (totalBytesRead < formDataLength) 
			{
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}

			String file = new String(dataBytes);
			
			//for saving the file name
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			
			
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			
			
			
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			//extracting the index of file 
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			
			String brow_filename=saveFile;
			System.out.println("  Filename            :"+brow_filename);
			String extension = brow_filename.substring(brow_filename.indexOf("."));

			// creating a new file with the same name and writing the content in new file
			//String filename="D:\\Test\\test"+extension;
			//File file1=new File(filename);
			
			File file1=new File(brow_filename);
			FileOutputStream fileOut = new FileOutputStream(brow_filename);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			 HttpSession session=request.getSession(false);
             request.setAttribute("filename", brow_filename);
             Date date=new Date();
            
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String currentTime =sdf.format(date);
           
             String x_user_id= (String) session.getAttribute("x_user_id");

 			
 			System.out.println("currentTime  :"+currentTime);
 			
             System.out.println("x_user_id  :"+x_user_id);
            
             try 
             {
            	 rs=ImageDAO.UploadImage(brow_filename,x_user_id,currentTime);
				while(rs.next())
				 {
				 	i_code=rs.getString(1);
				 }
			} 
             catch (SQLException e) 
             {
				e.printStackTrace();
			}
             request.setAttribute("i_code", i_code);
             System.out.println("i_code  : (readfile.java)" + i_code);
            
             String path = request.getRealPath("") +"\\Image\\" + brow_filename;
             

			
			String ext = brow_filename.substring(brow_filename.indexOf(".")+1);
			System.out.println("  Filename       ext     :"+ext);
			
			BufferedImage img1=ImageIO.read(new File(brow_filename));
			int type = img1.getType() == 0? BufferedImage.TYPE_INT_ARGB : img1.getType();
			int w1=img1.getWidth();
			int h1=img1.getHeight();
			
			if(w1>400 && h1 >200)
			{
				BufferedImage resize=ImageTest.resizeImageWithHint(img1,type);	
				ImageIO.write(resize, ext, new File(path));
			}
			else
			{
				ImageIO.write(img1, ext, new File(path));
			}
	       		
			
		}
		out.println("File Uploaded sussessfully");
	     rd=request.getRequestDispatcher("/jsp/upload_image.jsp");
	     request.setAttribute("Status", "File Uploaded sussessfully");
	   
	     rd.forward(request,response);
	 
	     System.out.println("****** Done.......");*/
		
		
		
		HttpSession session=request.getSession();
		
		String x_name=session.getAttribute("x_name").toString(); 
		
		System.out.println("x_name "+x_name);
		
		String post_id="";
		LoginDao.resetmatches();
		try
		{
			boolean flag=false;
			
				FileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
				List fileItems = null;
				try {
					fileItems = servletFileUpload.parseRequest(request);
					
					System.out.println(fileItems);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileItem file1 = (FileItem) fileItems.get(0);
				
		
				String root = getServletContext().getRealPath("/user_input_image/"+file1.getName());
				
				File uploadedFile = new File(root);
			     file1.write(uploadedFile);
			     
			 	
			     request.setAttribute("filename", file1.getName());
			     
			     String temp = getServletContext().getRealPath("/Temp/");
			     
			     
			     
			     
			     
			     
			     
			     
			     Date date=new Date();
			     
			     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             String currentTime =sdf.format(date);
			     ResultSet rs1=null;
			     String i_code="";
			     try 
	             {
	            	 rs1=ImageDAO.UploadImage(file1.getName(),x_name,currentTime);
					while(rs1.next())
					 {
					 	i_code=rs1.getString(1);
					 }
				} 
	             catch (SQLException e) 
	             {
					e.printStackTrace();
				}
			     
			     
			     
			     request.setAttribute("i_code", i_code);
			     
			     post_id=i_code;
			     
			     
			     
			     
		
			     SendImageFname1(root);
			     
			     Thread.sleep(1000);
			    ResultSet rs=LoginDao.get_mage();
			    
			    int count= LoginDao.get_mage_count();
			    LoginDao.emptyTest();
			    while(rs.next())
			    {
			    	String root1 = getServletContext().getRealPath("/profile_pics/"+rs.getString(3));
			    	
			    	
			    	Thread.sleep(1000);
			    	
			    	for(int i=1;i<=count;i++)
			    	{
			    		
			    		SendImageFname2(root1+"/"+"face.jpg",temp+"/"+i+".jpg",rs.getInt(1));
			    		
			    	}
			    	
			    	
			    	
			    }
			     
			     
					
			}
			catch (Exception e) {
			
			}
			String s="";
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 ResultSet rs=LoginDao.select_Test_id();
		
		 
		  try {
			 
			while(rs.next())
			  {
				 s+="-"+LoginDao.select_User_name(rs.getString(1));
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		  System.out.println(s);
		//  request.setAttribute("coowner", s);
		  
		String  x_user_id= (String) session.getAttribute("x_name");
	         System.out.println("x_user_id  :"+x_user_id);
		  
		  
	         
		  ResultSet rs1=LoginDao.select_Test_id();
			int no_of_friends = 0;
			int no_of_faces = 0;
			int no_of_nonfriends=0;
			String vote_status="";
			
			int pos_vote = 0;
			int neg_vote = 0;
			String req_id="";
			int unknown=0;
		  try {
			  Thread.sleep(1000);
			while(rs1.next())
			  {
				
				no_of_faces++;
			
				
				
			
				String policy_status=GroupDAO.getpolicy_status(rs1.getString(1));
				
				
				
				boolean f=GroupDAO.check_friends(x_user_id, LoginDao.select_User_name(rs1.getString(1)));
				
				boolean f1=GroupDAO.check_friends( LoginDao.select_User_name(rs1.getString(1)),x_user_id);
				
				if(f||f1)
				{
					no_of_friends++;
					neg_vote++;
				}
				else if(GroupDAO.check_non_friends(rs1.getString(1)))
				{
					no_of_nonfriends++;
				}
				else
				{
					unknown++;
				}
				if(policy_status.trim().equals("Friends"))
				{
					pos_vote++;
					
				}
				else if(policy_status.trim().equals("Public"))
				{
					pos_vote++;
				}
				else if(policy_status.trim().equals("Get Aproval"))
				{
					vote_status="pending";
					
					GroupDAO.update_m_req(x_name,LoginDao.select_User_name(rs1.getString(1)),post_id);
				}
			  }
				 
			if(!vote_status.equals("pending"))
			{
				if(pos_vote>neg_vote)
				{
					vote_status="post";
				}
				else
				{
					vote_status="block";
				}
			}
			
		boolean flag=GroupDAO.update_m_votes(no_of_faces, no_of_nonfriends, no_of_friends, unknown,pos_vote,neg_vote,vote_status,post_id);
		
			
			System.out.println("vote flag "+flag);
			
			
		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		  
		  
		  
		  
		
		 rd=request.getRequestDispatcher("/jsp/upload_image.jsp?coowner="+s+"");
	     request.setAttribute("Status", "File Uploaded sussessfully");
	   
	     rd.forward(request,response);
		
	  }
	
	
	public static void SendImageFname1(String filepath)
	{
		Socket client;
		try 
		{
			System.out.println("============>  send");
			client = new Socket("localhost", 8669);
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
		
			
		
	}
	
	
	
	
	
	
	public static void SendImageFname2(String filepath1,String filepath2,int id)
	{
		Socket client;
		try 
		{
			System.out.println("============>  send");
			client = new Socket("localhost", 8679);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
			dos.writeInt(id);
			dos.writeUTF(filepath1);
			dos.writeUTF(filepath2);
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
		
			
		
	}
}


 package com.user;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Dao.LoginDao;
import com.DataBase.DBConnection;
import com.algorithm.TextureCoOcurrence;


public class Register extends HttpServlet 
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		
			try
			{
				boolean flag=false;
				
					FileItemFactory fileItemFactory = new DiskFileItemFactory();
					ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
					List fileItems = null;
					try {
						fileItems = servletFileUpload.parseRequest(req);
						
						System.out.println(fileItems);
					} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					FileItem file1 = (FileItem) fileItems.get(0);
					FileItem file2 = (FileItem) fileItems.get(1);
					FileItem file3 = (FileItem) fileItems.get(2);
					FileItem file4 = (FileItem) fileItems.get(3);
					FileItem file5 = (FileItem) fileItems.get(4);
					
					FileItem file6 = (FileItem) fileItems.get(5);
					FileItem file7 = (FileItem) fileItems.get(6);
					FileItem file8 = (FileItem) fileItems.get(7);
					FileItem file9 = (FileItem) fileItems.get(8);
					FileItem file10 = (FileItem) fileItems.get(9);
					FileItem file11 = (FileItem) fileItems.get(10);
					
					
					
					System.out.println("----"+file1.getString());
					System.out.println("----"+file2.getString());
					System.out.println("----"+file3.getString());
					System.out.println("----"+file4.getString());
					System.out.println("----"+file5.getString());
					System.out.println("----"+file6.getString());
					System.out.println("----"+file7.getString());
					System.out.println("----"+file8.getString());
					System.out.println("----"+file9.getString());
					System.out.println("----"+file10.getString());
					System.out.println("----"+file11.getString());
					
				
				
					String m_name=file1.getString();
					String m_userid=file2.getString();
					String m_pass=file3.getString();
					String m_dd=file4.getString();
					String m_month=file5.getString();
					String m_yyyy=file6.getString();
					String m_gender=file7.getString();
					String lhobby=file8.getString();
					String place=file9.getString();
					String m_moblie=file10.getString();
					String m_profile=m_name+".jpg";
					
							String d_o_b=m_dd+"/"+m_month+"/"+m_yyyy;
							
							
						
							String root = getServletContext().getRealPath("/profile_pics/"+m_name+"/");
							File uploadedFile1=new File(root);
							if(!uploadedFile1.exists())
							{
								uploadedFile1.mkdirs();
							}
							File uploadedFile = new File(root +"/"+m_profile);
							if(!uploadedFile.exists())
							{
								uploadedFile.createNewFile();
							}
							
							
							
							
				if(LoginDao.ChkUser(m_name))
				{
							
					       
					        file11.write(uploadedFile);
					        
					        
					        SendImageFname(root +"/"+m_profile);
					        Thread.sleep(1000);
					        String detected_root = getServletContext().getRealPath("/Temp2/1.jpg");
					        
					        
					        
					        
					        
					        
					        
							BufferedImage img1= TextureCoOcurrence.readImage(detected_root);
							
							ImageIO.write(img1, "jpg", new File(root+"/face.jpg"));
							
							
							Vector<Double> featureVectorImg1 = null	;
							 featureVectorImg1 = TextureCoOcurrence.getFeatureVector(img1);
							
							 StringBuffer sb = new StringBuffer();
							 
							 for(int i=0;i<featureVectorImg1.size();i++)
							    {
							    	sb.append(featureVectorImg1.get(i)+"-");
							    }
							    
							    //Deleting The Last '-' from sb
							    if(sb.length() > 0)
							    {
							    	sb.deleteCharAt(sb.lastIndexOf("-"));
							    }
							    
							   String imgFeature1 = sb.toString();
							   
				flag=LoginDao.register(m_userid, m_pass, m_name, m_gender,d_o_b, m_moblie,m_profile, lhobby,place,imgFeature1);
				flag=LoginDao.register1(m_name, m_pass);
				
				
							 if(flag==true)
							 {
							 	resp.sendRedirect(req.getContextPath()+"/index.jsp?no=1");
							 }
							 else
							 {
								resp.sendRedirect(req.getContextPath()+"/index.jsp?no=2");	
							 }
							 
			}
							
			else
			{
			resp.sendRedirect(req.getContextPath()+"/register.jsp?no=1");	
			}
				
							
							
							
			}
			catch (Exception e) {
			
			}
				
		
	
	
	}
	
	
	
	public static void SendImageFname(String filepath)
	{
		Socket client;
		try 
		{
			System.out.println("============>  send");
			client = new Socket("localhost", 8662);
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
	
	
	
	
	
	
	
	}


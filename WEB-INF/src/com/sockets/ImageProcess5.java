package com.sockets;

import java.io.DataInputStream;
import java.net.*;

import com.Dao.LoginDao;
import com.user.BasicTesseractExampleTest;


import sun.awt.windows.ThemeReader;



public class ImageProcess5 
{
	public static String ocrop;
	ImageProcess5()
	{
		System.out.println("======================================");
		Thread t=new Thread(new PortListener(8689));
		t.start();
		
	}
	
	class PortListener implements Runnable
	{
	
		
		
		int port;
   		public PortListener(int port ) 
   		{
   			this.port=port;
   			run();

   		}
		
		public void run() 
		{
			
			try
			{
				
				String path="sachin-ganguly.jpg";
				ServerSocket ServerSocket=new ServerSocket(port);
				while(true)
				{
					
					Socket sock=ServerSocket.accept();
					System.out.println(" accept :"+sock);
					DataInputStream dis=new DataInputStream(sock.getInputStream());
					String fname=dis.readUTF();
					System.out.println(fname);
					String s[]=fname.split("~~");
					ocrop=BasicTesseractExampleTest.givenTessBaseApi_whenImageOcrd_thenTextDisplayed(s[0]);
					System.out.println("ocr values ip2>>>>>>>"+ocrop);
					System.out.println("oo "+ocrop);
					
					
					LoginDao.update_user_Id(s[1], ocrop);
					//adduserdao.update_user_Id(s[1], ocrop);
				}
				
			}
			catch(Exception df)
			{
				df.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new ImageProcess5();
	}
}

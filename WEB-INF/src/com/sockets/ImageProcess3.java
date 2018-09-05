package com.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

import sun.awt.windows.ThemeReader;


import com.Dao.LoginDao;
import com.face.MultipleFaceDetection;
import com.face.MultipleFaceDetection2;

public class ImageProcess3 
{
	ImageProcess3()
	{
		System.out.println("======================================");
		Thread t=new Thread(new PortListener(8669));
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
					int s=MultipleFaceDetection.GetFace(fname);
					LoginDao.updatePhotoCounts(s);
				
					System.out.println("no.of face:::"+s);
					
				}
				
			}
			catch(Exception df)
			{
				df.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		new ImageProcess3();
		
		
	}
}

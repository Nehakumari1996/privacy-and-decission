package com.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

import sun.awt.windows.ThemeReader;


import com.Dao.LoginDao;
import com.algorithm.SURFDetector;
import com.face.MultipleFaceDetection;
import com.face.MultipleFaceDetection2;

public class ImageProcess4 
{
	ImageProcess4()
	{
		System.out.println("======================================");
		Thread t=new Thread(new PortListener(8679));
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
					int fid=dis.readInt();
					String fname=dis.readUTF();
					String fname1=dis.readUTF();
					System.out.println(fname);
					System.out.println(fname1);
					
					int dist=SURFDetector.comparision_process(fname, fname1);
					//LoginDao.updatematches(fid,dist);
					
					
					LoginDao.updateTest(fid,dist);
				
					System.out.println("dist :::"+dist);
					
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
		new ImageProcess4();
		
		
	}
}

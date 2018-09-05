package com.user;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.*;



import java.sql.*;

public class download extends HttpServlet
{
    public download()
    {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
		System.out.println("Welcome to Download Page");

        boolean status = true;
        
        HttpSession session = req.getSession();
        String userid =  session.getAttribute("userid").toString().trim();
       
        String filename = userid+"_2.png";
		System.out.println("File Name is : "+filename);
		String filepath = req.getRealPath("")+"\\image_vc\\Share2_DB\\"+filename;
		
        String content = "";
        String docType1 = "";
        String docType2 = "";
               
        String raddr="",rhost="",hostname="";
        
        try
        {
            InetAddress addr = InetAddress.getLocalHost();
            raddr=req.getRemoteAddr();
            rhost=req.getRemoteHost();
            //System.out.println("Remote Address :"+raddr);
            //System.out.println("Remote Host :"+rhost);
            byte ipAddr[] = addr.getAddress();
            hostname = addr.getHostName();
           // System.out.println("Local HostName :" + hostname);
        }
        catch(UnknownHostException unknownhostexception) { }
       
        String resumePath = "";

		//System.out.println("Before StingTokenizer class...");

		for(StringTokenizer st1=new StringTokenizer(filepath,"/");st1.hasMoreTokens();)
		{
			 docType1 = st1.nextToken();
			// System.out.println("Tokent 1 :"+docType1);
		}

		for(StringTokenizer st = new StringTokenizer(docType1, "."); st.hasMoreTokens();)
        {
            docType2 = st.nextToken();
			//System.out.println("StringTokenizer for . is " +docType2);
        }

		if(docType2.equals("xls"))
        {
            content = "application/msexcel";
            status = false;
        }
        if(docType2.equals("pdf"))
        {
            content = "application/pdf";
            status = false;
        }
        if("doc".equals(docType2))
        {
            content = "application/msword";
            status = false;
        }
        if(status)
        {
            content = "text/html";
        }
        //System.out.println("Content Type : "+content);
        res.setContentType(content);
        res.setHeader("content-disposition", "attachment;filename="+filename);

    
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
       
        String pathlocation1 = "";


        try
        {
            resumePath =filepath;
            //System.out.println("resumepath#################=" + resumePath);
        }
        catch(Exception exception) { }
     
        //System.out.println("Before FileInputStream the Resume Path is "+resumePath);
        
        //System.out.println(res.getOutputStream());

	    FileInputStream in = new FileInputStream(resumePath);
        bis = new BufferedInputStream(in);
        bos = new BufferedOutputStream(res.getOutputStream());
        byte buff[] = new byte[1024];
        int bytesRead;
        try
        {
            while((bytesRead = bis.read(buff, 0, buff.length)) != -1) 
            {
                bos.write(buff, 0, bytesRead);
            }
        }
        catch(Exception exception1) { }
        finally
        {
            try
            {
                if(bos != null)
                {
                    bos.close();
                }
                if(bis != null)
                {
                    bis.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }           
       }
        return;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        doGet(req, res);
    }
}



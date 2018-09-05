/**
 * 
 */
package com.Dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;




public class Utility
{
	
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if(str=="0 ") 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str.trim()); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			System.out.println("its came inisde utility");
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\config.properties");
			property.load(in);
			pro=property.getProperty(str);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	
	public static String getHours(String previous_time,String new_Time)
	{
		String diffHours="";
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
			java.util.Date d1 = null;
			java.util.Date d2 = null;
			
			d1 = format.parse(previous_time);
			d2 = format.parse(new_Time);
			
			long diff = d2.getTime() - d1.getTime();
			//System.out.println("Difference is-->"+diff);
			diffHours = String.format("%d", TimeUnit.MILLISECONDS.toHours(diff));
			//System.out.println("Difference in hours"+diffHours);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getHours(String previous_time,String new_Time)( ): "+ e);
		}
		return diffHours;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="Tuesday";
			else if(no==4)
				day="Wednesday";
			else if(no==5)
				day="Thrusday";
			else if(no==6)
				day="Friday";
			else if(no==7)
				day="Saturday";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	public static String MD(File source1) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		String output="";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = new FileInputStream(source1);				
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while( (read = is.read(buffer)) > 0) 
			{
				digest.update(buffer, 0, read);
			}		
			byte[] md5sum = digest.digest();
			//	System.out.print("Digets:"+md5sum);
			
			System.out.println();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			//System.out.println("MD5: " + output);
		}
		catch(IOException e) 
		{
			System.out.println("Unable to process file for MD5"+e);
		}
		return output;
	}
	

	public static boolean writeOnFile(String msg,String root)
	{
		boolean flag=false;
		try
		{
			PrintWriter pw = null;
			String path=root;
			//System.out.println("Path is--->"+path);
			File f=new File(path);
			if(!f.exists())
				flag =f.createNewFile();
			pw = new PrintWriter(new FileWriter(f, true));
			pw.println("");
			pw.println(msg);
			pw.flush();
			pw.close();
			flag=true;
			//System.out.println(msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	


	
	
	///////////Encryption Decryption code
	
	
	
	
	public static void main(String asdf[])
	{
		
	}
}

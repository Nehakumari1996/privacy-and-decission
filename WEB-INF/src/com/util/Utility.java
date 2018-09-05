/**
 @Author : Munna Kumar Singh
 Date : Mar 12, 2013
 File : Utility.java
 Package : com.chat.util
*/

package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility 
{
	public static String controleHubs(String subject)
	{
		String lcSubject = subject.toLowerCase();
		String ucSubject = subject.toUpperCase();
		String hub = "";
		if(lcSubject.contains("java") || ucSubject.contains("JAVA"))
		{
			hub = "Java";
		}
		else if (lcSubject.contains(".net") || ucSubject.contains(".NET") || lcSubject.contains("dot net") || lcSubject.contains("dotnet") || ucSubject.contains("DOT NET"))
		{
			hub = ".Net";
		}
		else if (lcSubject.contains("android") || ucSubject.contains("ANDROID"))
		{
			hub = "Android";
		}
		else if (lcSubject.contains("civil") || ucSubject.contains("CIVIL"))
		{
			hub = "Civil";
		}
		else
		{
			hub = "HubNotFound";
		}
		return hub;
	}
	
	
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
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
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
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
	
	public static String getDate1()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
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
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	
	
	/* Testing The Developments */
	public static void main(String[] args) 
	{
		String subject = "I Want To Help For .Net Installation.";
		String requestedHub = controleHubs(subject);
		System.out.println("Requested Hub : " + requestedHub);
	}
}


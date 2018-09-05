/**
 * 
 */
package com.nitin.user.process;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.DataBase.DBConnection;
import com.nitin.DAO.*;

/**
 * @author Nitin Gudle
 *Nov 30, 2011 12:07:36 PM
 *Project:-Data_Mining
 *Package:-com.nitin.user.process
 *File:-UserProcess.java
 */
public class UserProcess
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserProcess userProcess=null;
	private UserProcess()
	{
		
	}
	public static UserProcess getInstance()
	{
		if(userProcess == null)
		{
			userProcess= new UserProcess();
		}
		return userProcess;
	}
	public boolean checkUser(String userid,String pass)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user1 where m_user='"+userid+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	public int getID(String userid,String pass)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_id from m_user1 where m_user='"+userid+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getID(String userid,String pass): "+ e);
		}
		return i;
	}
	public boolean startSession(int id,String session)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int j=getID();
			int i = statement.executeUpdate("insert into m_track (m_id,m_userid,m_urlid,m_sessionid) values('"+(j+1)+"','"+id+"','0','"+session+"')");
			System.out.println("insert into m_track (m_id,m_userid,m_sessionid) values('"+(j+1)+"','"+id+"','"+session+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println();
		}
		return flag;
	}
	public int getID()
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_track");
			while(resultSet.next())
			{
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getID(String userid,String pass): "+ e);
		}
		return i;
	}
	public int getID(String userid)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_id from m_user1 where m_user='"+userid+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getID(String userid,String pass): "+ e);
		}
		return i;
	}
	public String getURL(int id)
	{
		String url="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_url from m_site where m_id='"+id+"'");
			while(resultSet.next())
			{
				url=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getURL(int id): "+ e);
		}
		return url;
	}
	public String getURLID(int id,String sessionid)
	{
		String urlid="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_urlid from m_track where m_userid='"+id+"' and m_sessionid='"+sessionid+"'");
			while(resultSet.next())
			{
				urlid=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getURL(int id): "+ e);
		}
		return urlid;
	}
	public boolean insertTrack(int id,String session,String urlid1)
	{
		boolean flag=false;
		try
		{
			String trackno="";
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String  urlid=getURLID(id,session);
			if(urlid.equals("0"))
			{trackno="-"+urlid1;}
			else
			{
				String xurlid=urlid.substring(urlid.lastIndexOf("-")+1,urlid.lastIndexOf(""));
				if(!(xurlid.equals(urlid1)))
				{trackno=urlid+"-"+urlid1;}
				else{trackno=urlid;}
			}
			int i = statement.executeUpdate("update m_track set m_urlid='"+trackno+"' where m_userid='"+id+"' and m_sessionid='"+session+"'");
			System.out.println("update m_track set m_urlid='"+trackno+"' where m_userid='"+id+"' and m_sessionid='"+session+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert Track : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->insertTrack(int id,String session,String urlid1): "+ e);
		}
		return flag;
	}
	public void deleteData()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			System.out.println("----------------");
			statement.executeUpdate("delete from m_track where m_urlid='0'");
			System.out.println("================");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->deleteData(): "+ e);
		}
	}
	public static void main(String a[])
	{
		UserProcess.getInstance().deleteData();
	}
	public static boolean insertnonrepeatedwebsites(String day,String we,int uid) {
		boolean flag=false;
		ArrayList data = new ArrayList();
		
		try
		{
			
			
			
			System.out.println("day is >>>>>>>>>>>>>>>>>>>>"+day);
			System.out.println("website  is >>>>>>>>>>>>>>>>>>>>"+we);
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from m_site where m_url='"+we+"'");
			while(resultSet.next())
			{
				flag=true;
			}
		
			if(flag)
			{
			
			}
			else
			{
				data.add(we);
				
				for (int i = 0; i < data.size(); i++) {
					
				
			DAO dao1=DAO.getInstance();
			connection=dao1.connector();
			statement = connection.createStatement();
			
			int i2 = statement.executeUpdate("insert into file_websites(day,website,u_id) values('"+day+"','"+data.get(i)+"','"+uid+"')");
			System.out.println("insert into file_websites(day,website,u_id) values('"+day+"','"+data.get(i)+"','"+uid+"')");
			if(i2!=0)
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}}
		}
		catch(Exception e)
		{
			System.out.println();
		}
		return flag;
}
	
	public static boolean removeexistingwebsites(String string) {
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from m_site where m_url='"+string+"'");
			while(resultSet.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getURL(int id): "+ e);
		}
		return flag;
	}
	public static boolean verify(String days, String string,int uid) throws SQLException {
		
	
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
         String data="select *from file_websites where  day='"+days+"',website='"+string+"'";
			
			System.out.println("query  verify is is >>>>>>>>>>"+data);
			resultSet = statement.executeQuery("select *from file_websites where  day='"+days+"'and website='"+string+"'  and u_id='"+uid+"' ");
			
			
			while(resultSet.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("verify>>>>>>>>>>>>>>>>->getURL(int id): "+ e);
		}
		/*finally
		{
		resultSet.close();
		}*/
		return flag;
	}
	
	public static ArrayList<String> takedays(int uid)
	{	
		ArrayList<String> data=new ArrayList<String>();
	try
	{

		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String	sql="SELECT DISTINCT day FROM file_websites where u_id='"+uid+"'";
		System.out.println(sql);
		resultSet=statement.executeQuery(sql);	
		
	
	while(resultSet.next())
	{
		data.add(resultSet.getString(1));
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return data;
	
	}
	public static ArrayList<String> takewebsitesbasedonday(String distinctday,int uid) {
		ArrayList<String> data=new ArrayList<String>();
		try
		{

			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		     String	sql="select website from file_websites where day='"+distinctday+"' and u_id='"+uid+"'";
			System.out.println(sql);
			resultSet=statement.executeQuery(sql);	
			
		
		while(resultSet.next())
		{
			data.add(resultSet.getString(1));
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
}
	

	public static int takematchedsitenumber(String websites,int uid)
	{
		int sitenum=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select id from file_websites where website='"+websites+"'  and  u_id='"+uid+"'");

			while(resultSet.next())
			{
				sitenum=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getURL(int id): "+ e);
		}
		return sitenum;
	}










	public static int takeuserparticularid(String username)
	{
		int uid=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where u_name='"+username+"'");

			while(resultSet.next())
			{
				uid=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getURL(int id): "+ e);
		}
		return uid;
	}
	public static boolean insertsessionsite(int uid, String distinctday,
			String string) {
		
		
		
		System.out.println("uis in dao >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+uid);
		System.out.println("distinctday in dao >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+distinctday);
		System.out.println("distinctday in dao >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+string);
		
		/*int i=0;
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			System.out.println("insert into m_sessionsite (u_id,day,visitedsites) values('"+uid+"','"+distinctday+"','"+string+"')");
			i = statement.executeUpdate("insert into m_sessionsite (u_id,day,visitedsites) values('"+uid+"','"+distinctday+"','"+string+"')");
			System.out.println("i value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+i);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println();
		}
		return flag;
		
		
		
		*/
boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql="insert into m_sessionsite (u_id,day,visitedsites) values('"+uid+"','"+distinctday+"','"+string+"')";
			System.out.println("Sql.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..."+sql);
			statement.executeUpdate(sql);
			
			
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
		
	





}


package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;


import com.DataBase.DBConnection;





public class GroupDAO {
	static Connection con=null;
	static Statement statement=null;
	static ResultSet rs=null;
	static String sql="";
	static boolean flag=false;
	
	public static boolean rmvGrp(String grp_in,String grp_uid)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			int i = statement.executeUpdate("delete from m_group where grp_uid='"+grp_uid+"' and grp_in='"+grp_in+"'");
			i = statement.executeUpdate("delete from m_group where grp_uid='"+grp_in+"' and grp_in='"+grp_uid+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User remove from group Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-rmvGrp()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static boolean update(String from,String to,String msg)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into m_update (up_from,up_to,up_msg,flag) values('"+from+"','"+to+"','"+msg+"','true')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static boolean updatefrequentset(String data,String item)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into frequent_set (user_id,freq_items) values('"+data+"','"+item+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	public static boolean updatefrequentset11(String data,String item)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into frequent_set (user_id,freq_items) values('"+data+"','"+item+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	public static boolean processRequest(String from , String to)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i = statement.executeUpdate("insert into m_group (grp_in,grp_uid) value('"+from+"','"+to+"')");
			i = statement.executeUpdate("insert into m_group (grp_uid,grp_in) value('"+from+"','"+to+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User process req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-ProcessRequest()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static boolean changeStatus(String from,String to,String status)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("update m_request set req_status='"+status+"' where req_from='"+from+"' and req_to='"+to+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User change req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in changeStatus(String from,String to,String status)....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
	
	
	
	
	public static boolean change_post_Status(String from,String to,String status,String p_id)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("update post_req set status='"+status+"' where post_req_from='"+from+"' and post_req_to='"+to+"' and p_id='"+p_id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User change req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in changeStatus(String from,String to,String status)....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	public static ResultSet getUsers() 
	{
		ResultSet resultSet=null;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-getUsers()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return resultSet;
	}
	

	
	public static ResultSet getUser(String user)
	{
			try
			{
				con=DBConnection.getConnection();
				statement=con.createStatement();
				sql="select * from m_group where grp_uid='"+user+"'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);
				
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in GroupDAO getUser(String user)");
			}
			
		return rs;
	}
	
	
	
	public static boolean sendReq(String from,String to)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			String sql="select * from m_request where req_from='"+from+"' and req_to='"+to+"' and req_status='pending'" ;
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next())
			{
				flag=false;
			}
			else
			{
			int i = statement.executeUpdate("insert into m_request (req_from,req_to,req_status) value('"+from+"','"+to+"','pending')");
			 if(i!=0)
			 {
				flag=true;
			 }
			}
			
			System.out.println("Send request status--->"+flag);
			//System.out.println("User send req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-sendReq(String from,String to)....."+e);
		}
		
		return flag;
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
	
	public static ResultSet getUsers(Vector v) 
	{
		ResultSet resultSet=null;
		try
		{
			String query="";
			for(int i=0;i<v.size();i++)
				query+=" u_name!='"+v.get(i)+"' and";
			query = query.substring(0, query.length()-1);
			query = query.substring(0, query.length()-1);
			query = query.substring(0, query.length()-1);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			System.out.println("sql is--select * from m_user where "+query+"");
			resultSet = statement.executeQuery("select u_name from m_user where "+query+"");
			
			//System.out.println(" No Of Rows :"+resultSet.getRow());
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUsers(Vector v)....."+e);
		}
		
		return resultSet;
	}
	
	
	
	
	public static ResultSet getalluserid() 
	{
		ResultSet resultSet=null;
		try
		{
			
			
			con=DBConnection.getConnection1();
		
			statement=con.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUsers(Vector v)....."+e);
		}
		
		return resultSet;
	}
	
	
	public static String chkStatus(String user,String id)
	{
		
		String status="";
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			String sql="select req_status from m_request where req_from='"+user+"' and req_to='"+id+"'";
		//	System.out.println(sql);
		   ResultSet resultSet  = statement.executeQuery(sql);
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
			//System.out.println("User req Status : "+status);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chkStatus(String user,String id)....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return status;
	}
	
	public static Vector getReq(String id)
	{
		Vector <String> v=new Vector<String>();
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
		   ResultSet resultSet  = statement.executeQuery("select req_from from m_request where req_to='"+id+"' and req_status='pending'");
			while(resultSet.next())
			{
				v.add(resultSet.getString(1));
			}
			System.out.println("User req from : "+v);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Vector getReq(String id)....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return v;
	}
	
	public static String chkStatus(String id)
	{
		String status="";
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			String sql="select req_status from m_request where req_to='"+id+"'";
			//System.out.println(sql);
			ResultSet resultSet  = statement.executeQuery(sql);
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
			//System.out.println("User req Status : "+status);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		/*finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}*/
		return status;
	}
	
	public static boolean chkUpdate(String id)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			ResultSet resultSet  = statement.executeQuery("select * from m_update where up_to='"+id+"' and flag='true'");
			while(resultSet.next())
			{
				flag=true;
			}
			//System.out.println("User chaeck Update Status : "+flag);
			
			con.close();
			statement.close();
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static Vector getUpd(String id)
	{
		Vector <String> v=new Vector<String>();
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			ResultSet resultSet  = statement.executeQuery("select up_msg from m_update where up_to='"+id+"' and flag='true'");
			while(resultSet.next())
			{
				v.add(resultSet.getString(1));
			}
			System.out.println("User update from : "+v);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return v;
	}
	
	public static boolean changeStatus(String user)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("update m_update set flag='false' where up_to='"+user+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User change req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}

	public static int getuserid(String usernames) {
		int uid=0;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection1();
			statement=con.createStatement();
			sql="select m_id from m_user where m_user='"+usernames+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				uid=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		return uid;
	}
	
	
	
	
	
	public static ArrayList<String> read(int uid)
	{	
		ArrayList<String> data=new ArrayList<String>();
	try
	{
		
		con=DBConnection.getConnection1();
		statement=con.createStatement();
		sql="select m_urlid from m_track where m_userid='"+uid+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
	
	while(rs.next())
	{
		data.add(rs.getString(1));
	}
	
	for(int i=0;i<data.size();i++)
	{
		System.out.println(data.get(i));
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return data;
	
	}
	
	public static ArrayList<String> read1(String  data)
	{	
		ArrayList<String> dataa=new ArrayList<String>();
	try
	{
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select m_urlid from m_track where m_userid='"+data+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
	
	while(rs.next())
	{
		dataa.add(rs.getString(1));
	}
	
	for(int i=0;i<dataa.size();i++)
	{
		System.out.println(dataa.get(i));
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return dataa;
	
	}	
	
	
	
	
	
			
			public static ArrayList<String> readwebsitesnum(String  data)
			{	
				ArrayList<String> dataa=new ArrayList<String>();
			try
			{
				
				con=DBConnection.getConnection();
				statement=con.createStatement();
				sql="select visitedsites from m_sessionsite where u_id='"+data+"'";
				System.out.println(sql);
				rs=statement.executeQuery(sql);	
				
			
			while(rs.next())
			{
				dataa.add(rs.getString(1));
			}
			
		for(int i=0;i<dataa.size();i++)
			{
				System.out.println(dataa.get(i));
			}
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return dataa;
			
			}	
			
	
	public static ArrayList<String> getalluserid1()
	{	
		ArrayList<String> data1=new ArrayList<String>();
	try
	{
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select * from m_user1";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
	
	while(rs.next())
	{
		data1.add(rs.getString(1));
	}
	
	for(int i=0;i<data1.size();i++)
	{
		System.out.println(data1.get(i));
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return data1;
	
	}
	public static boolean truncatetable()
	{
		boolean flag=false;
		try
		{
			
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			//int i  = statement.executeUpdate("insert in bto friend_recommand (user_id,full_pattern) values('"+aaa+"','"+countdata+"')");
			int i  = statement.executeUpdate("TRUNCATE TABLE frequent_set;");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static boolean truncatetablee()
	{
		boolean flag=false;
		try
		{
			
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			//int i  = statement.executeUpdate("insert in bto friend_recommand (user_id,full_pattern) values('"+aaa+"','"+countdata+"')");
			int i  = statement.executeUpdate("TRUNCATE TABLE file_websites;");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	public static boolean truncatetable1()
	{
		boolean flag=false;
		try
		{
			
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			//int i  = statement.executeUpdate("insert in bto friend_recommand (user_id,full_pattern) values('"+aaa+"','"+countdata+"')");
			int i  = statement.executeUpdate("TRUNCATE TABLE friend_recommand;");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
	
	
	public static ArrayList<String> getallusername() {
		{	
			ArrayList<String> username=new ArrayList<String>();
		try
		{
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select * from m_user1";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			username.add(rs.getString(2));
		}
		
		for(int i=0;i<username.size();i++)
		{
			System.out.println(username.get(i));
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return username;
		
		}
	}
	
	
	
	public static ArrayList<String> read3(String  usernames)
	{	
		ArrayList<String> particularuser=new ArrayList<String>();
	try
	{
		
		con=DBConnection.getConnection1();
		statement=con.createStatement();
		sql="select m_id from m_user where m_user='"+usernames+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
	
	while(rs.next())
	{
		particularuser.add(rs.getString(1));
	}
	
	for(int i=0;i<particularuser.size();i++)
	{
		System.out.println(particularuser.get(i));
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return particularuser;
	
	}

	public static int getparticularuserid(String name) {
		
		int uid=0;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select m_id from m_user1 where m_user='"+name+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				uid=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		return uid;
	
	
	}

	public static String Getparfrequentset(int userid) {
		
	
		String paruserfrequentset=null;
		try
		{
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select freq_items from frequent_set where user_id='"+userid+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			paruserfrequentset = rs.getString(1);
		}
		
		/*for(int i=0;i<paruserfrequentset.size();i++)
		{
			System.out.println(paruserfrequentset.get(i));
		}
		*/
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return paruserfrequentset;
	
	}

	
	
	
	
	public static String Getparticularuserplace(String userid) {
		
		
		String paruserfrequentset=null;
		try
		{
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select place from m_user where u_name='"+userid+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			paruserfrequentset = rs.getString(1);
		}
		
		/*for(int i=0;i<paruserfrequentset.size();i++)
		{
			System.out.println(paruserfrequentset.get(i));
		}
		*/
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return paruserfrequentset;
	
	}

	public static ArrayList<String> getusersdetails() {
		
		
		ArrayList<String> userdetails=new ArrayList<String>();
		
		try
		{
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select m_user from m_user1";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			userdetails.add(rs.getString(1));
		}
		
		/*for(int i=0;i<userdetails.size();i++)
		{
			System.out.println(userdetails.get(i));
		}*/
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userdetails;
	
	}
	
	public static String getstatus(String a,String b)
	{
		String status="";
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			String sql="select req_status from m_request where req_from='"+a+"' and req_to='"+b+"'";
			
			ResultSet resultSet  = statement.executeQuery(sql);
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
			//System.out.println("User req Status : "+status);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		/*finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}*/
		return status;
	}

	public static int compare(String bb) {
		
		
		int uid=0;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection1();
			statement=con.createStatement();
			sql="select m_id from m_user where m_user='"+bb+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				uid=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		return uid;
		
		
		
		
	}

	public static int compare1(String ff) {

		int uid1=0;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection2();
			statement=con.createStatement();
			sql="select m_id from m_user where m_user='"+ff+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				uid1=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		return uid1;
	}

	public static boolean getunfriends(String c, String d) {
		
		
		
		
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection1();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into m_unfriends (u_from,u_to) values('"+c+"','"+d+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
		
	}

	public static ArrayList<String> getfriendsdetails(String name) {
		
		
		
		ArrayList<String> frienddetails=new ArrayList<String>();
		try
		{
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select m_user from m_user1  where m_user in (select grp_in  from m_group where grp_uid='"+name+"')";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			frienddetails.add(rs.getString(1));
		}
		
		/*for(int i=0;i<userdetails.size();i++)
		{
			System.out.println(userdetails.get(i));
		}*/
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return frienddetails;
	
		
	}
	
/*public static ArrayList<String> getfriendslist(String name) {
		
		
		
		ArrayList<String> frienddetails=new ArrayList<String>();
		try
		{
			String accepted="accepted";
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select * from m_request where req_from="+name+" or req_to="+name+" and req_status="+accepted+"";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
		
		while(rs.next())
		{
			frienddetails.add(rs.getString(1));
		}
		
		for(int i=0;i<userdetails.size();i++)
		{
			System.out.println(userdetails.get(i));
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return frienddetails;
	
		
	}

*/


public static ArrayList<String> getfriendslist(String name) {
	
	
	
	ArrayList<String> frienddetails=new ArrayList<String>();
	try
	{
		String accepted="accepted";
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select m_user from m_user1  where m_user in (select grp_in  from m_group where grp_uid='"+name+"')";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
	while(rs.next())
	{
		frienddetails.add(rs.getString(1));
	}
	
	/*for(int i=0;i<userdetails.size();i++)
	{
		System.out.println(userdetails.get(i));
	}*/
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return frienddetails;

	
}

































	
	public static String getuserid1(String usernames) {
		String uid=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select m_id from m_user1 where m_user='"+usernames+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				uid=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		return uid;
	}

	public static String getfrequentsets(String uid) {
		
		
		
		
		
		String frequent_set=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select freq_items from frequent_set where user_id='"+uid+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				frequent_set=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		
		
		
		return frequent_set;
	}
	
	public static boolean deleterecords()
	{
		boolean flag=false;
		try
		{
			
			con=DBConnection.getConnection();
			String usercode="";
			String sql="TRUNCATE TABLE friend_recommand;";
			statement=con.createStatement();
			int i  = statement.executeUpdate(sql);
			System.out.println(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}

	
	public static boolean updatefriendrecomand(String aaa,int countdata)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+countdata);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			//int i  = statement.executeUpdate("insert into friend_recommand (user_id,full_pattern) values('"+aaa+"','"+countdata+"')");
			int i  = statement.executeUpdate("update  friend_recommand  set full_pattern='"+countdata+"' where user_id='"+aaa+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
	public static boolean updatedistance(String aaa,String distance)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+distance);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			ResultSet rs=statement.executeQuery("SELECT ASCII('"+distance+"')AS Lower_Case");
			int ascii=0;
			while(rs.next())
			{
				ascii=rs.getInt(1);
			}
			
			if(ascii== 63)
			{
				distance="0";
				
				
				System.out.println("================distance=================="+distance);
			}
			
			//int i  = statement.executeUpdate("insert into friend_recommand (user_id,full_pattern) values('"+aaa+"','"+countdata+"')");
			int i  = statement.executeUpdate("update  friend_recommand  set distance_calculation='"+distance+"' where user_id='"+aaa+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	public static boolean updatefriendrecomand1(String aaa,int countdata)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+countdata);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into friend_recommand (user_id,browse_pattern) values('"+aaa+"','"+countdata+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	public static boolean updatefriendrecomand2(String aaa,String countdata)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>browsedata>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>countdata>>>>>>>>>>>>>>"+countdata);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			
			int i  = statement.executeUpdate("update  friend_recommand  set browse_pattern='"+countdata+"' where user_id='"+aaa+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}

	public static boolean updatefriendrecomand5(String aaa,String countdata)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>iduser place>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>place>>>>>>>>>>>>>>"+countdata);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			
			int i  = statement.executeUpdate("update  friend_recommand  set place_pattern='"+countdata+"' where user_id='"+aaa+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}

	
	
	
	public static boolean updatefriendrecomand3(String aaa,String countdata)
	{
		boolean flag=false;
		try
		{
			System.out.println(">>>>>>>>>>>>hobyuserid>>>>>>>>>>>>>>>>>>"+aaa);
			System.out.println(">>>>>>>>>>>>>>>>hobbyweitage>>>>>>>>>>>>>>"+countdata);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			
			int i  = statement.executeUpdate("update  friend_recommand  set hobby_pattern='"+countdata+"' where user_id='"+aaa+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}

	
	
	
	
public static boolean insertontpatt(String c, String d) {
		
		
		
		
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection1();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate("insert into friend_recommand(user_id,ont_pattern) values('"+c+"','"+d+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-update()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
		
	}

	
	
	
	
	

	public static boolean updateCount(int userid, int count) 
	{
		boolean flag=false;
		String sql="update friend_recommand set no_of_sites='"+count+"' where user_id='"+userid+"'";
		System.out.println("======== "+sql);
		try
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userid);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+count);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-updateCount()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}	
	
	
	
	public static ResultSet getusersfriendrecomend() 
	{
		ResultSet rs=null;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			rs = statement.executeQuery("select * from  friend_recommand");
		
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-getUsers()....."+e);
		}
		finally
		{
		//DBConnection.CloseConnection(rs, statement, con);
		}
		return rs;
	}
	
	
	
	
	public static ResultSet getuserpatterndetails(String uid) 
	{
		ResultSet rs=null;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			rs = statement.executeQuery("select * from  friend_recommand where user_id='"+uid+"' ");
		
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-getUsers()....."+e);
		}
		finally
		{
		//DBConnection.CloseConnection(rs, statement, con);
		}
		return rs;
	}
	
	public static String getusersfriendrecomend1() {
		
		
		String paruserfrequentset1="";
		try
		{
			
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			sql="select user_id from friend_recommand";
			System.out.println(sql);
		    ResultSet rs1=stmt.executeQuery(sql);	
			
		
		while(rs1.next())
		{
			System.out.println("-----------------------------------");
			paruserfrequentset1 = rs1.getString(2);
		}
		
		/*for(int i=0;i<paruserfrequentset.size();i++)
		{
			System.out.println(paruserfrequentset.get(i));
		}
		*/
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return paruserfrequentset1;
	
	}

	public static boolean updatetotalWeightage(int userid, String sum) 
	{
		boolean flag=false;
		String sql="update friend_recommand set total_weightage='"+sum+"' where user_id='"+userid+"'";
		System.out.println("======== "+sql);
		try
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userid);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sum);
			con=DBConnection.getConnection();
			String usercode="";
			statement=con.createStatement();
			int i  = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in GroupDAO-updateCount()....."+e);
		}
		finally
		{
		DBConnection.CloseConnection(rs, statement, con);
		}
		return flag;
	}
	
	
	
public static String getusernamesofsimilarfriends(int uid) {
		
		
		
		
		
	String similarfriends=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select m_user from m_user1 where m_id='"+uid+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				similarfriends=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		
		
		
		return similarfriends;
	}

public static int truncateTables()
{
	int id=0;
	try
	{
		con=DBConnection.getConnection();
		statement=con.createStatement();
		
		
		String sql1="truncate table friend_recommand";
		
		
		int k=statement.executeUpdate(sql1);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getDataOwnerId(String username): ");
		e.printStackTrace();
	}
	return id;
}

public static String getparticularuserhobby(String name) {
	
	String hobby=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select hobbies from m_user where u_name='"+name+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				hobby=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		
		
		
		return hobby;
	}




public static String getparticularlocationid(String name) {
	
	String location=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select l_no from m_user where u_name='"+name+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				location=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		
		
		
		return location;
	}


public static String[] getlat_longd(String loc_name)
{
	String[] parm_values=new String[2];
	try
	{
		con=DBConnection.getConnection();
		statement=con.createStatement();
		
		sql="select L_lat,L_long from u_landmark where L_no='"+loc_name+"' ";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
		
		while(rs.next())
		{
			parm_values[0]=rs.getString(1);
			parm_values[1]=rs.getString(2);
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Exception in Location_dao class-->getLocation() : "+e);
	}
	
	return parm_values;
}





public static String getparticularuserontologypattern(String name) {
	
	String pro=null;
		try{
		//boolean	flag=false;
		
			
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select ontology_pattern from m_user where u_name='"+name+"'";
			System.out.println(sql);
			rs=statement.executeQuery(sql);	
			
			
			while(rs.next())
			{
				pro=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
		}
		
		
		
		return pro;
	}
public static ResultSet getlandmark() 
{
	ResultSet resultSet=null;
	try
	{
		con=DBConnection.getConnection();
		statement=con.createStatement();
		resultSet = statement.executeQuery("select * from m_landmark;");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in GroupDAO-getUsers()....."+e);
	}
	finally
	{
	DBConnection.CloseConnection(rs, statement, con);
	}
	return resultSet;
}



	
public static String getpolicy_status(String uid) {
	
	
	
	
	
	String policy_status=null;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select policy from m_user where u_code='"+uid+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
		
		while(rs.next())
		{
			policy_status=rs.getString(1);
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return policy_status;
}




public static boolean check_friends(String from_id,String to_id) {
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select * from m_request where req_from='"+from_id+"' and req_to='"+to_id+"' and req_status='accepted'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
		
		while(rs.next())
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}





public static boolean check_non_friends(String to_id) {
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="select * from m_user where u_code='"+to_id+"'";
		System.out.println(sql);
		rs=statement.executeQuery(sql);	
		
		
		while(rs.next())
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}





public static boolean update_m_votes(int face_no,int non_frnd,int no_frnds,int unknwn, int pos_vote, int neg_vote, String vote_status, String post_id) 
{
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="insert into m_votes(total_faces,no_of_nonfriends,no_of_friends,no_unknown,pos_vote,neg_vot,status,post_code_id)  values('"+face_no+"','"+non_frnd+"','"+no_frnds+"','"+unknwn+"','"+pos_vote+"','"+neg_vote+"','"+vote_status+"','"+post_id+"')";
		System.out.println(sql);
		int i=statement.executeUpdate(sql);	
		
		
		if(i>0)
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}






public static boolean update_m_req(String reqfrom,String req_to,String post_id) 
{
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="insert into  post_req(post_req_from,post_req_to,p_id) values('"+reqfrom+"','"+req_to+"','"+post_id+"')";
		System.out.println(sql);
		int i=statement.executeUpdate(sql);	
		
		
		if(i>0)
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}


public static String chk_post_req_Status(String id)
{
	String status="";
	try
	{
		con=DBConnection.getConnection();
		String usercode="";
		statement=con.createStatement();
		String sql="select status from post_req where post_req_to='"+id+"'";
		System.out.println(sql);
		ResultSet resultSet  = statement.executeQuery(sql);
		while(resultSet.next())
		{
			status=resultSet.getString(1);
		}
		//System.out.println("User req Status : "+status);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	/*finally
	{
	DBConnection.CloseConnection(rs, statement, con);
	}*/
	return status;
}


public static Vector get_post_Req(String id)
{
	Vector <String> v=new Vector<String>();
	try
	{
		con=DBConnection.getConnection();
		String usercode="";
		statement=con.createStatement();
	   ResultSet resultSet  = statement.executeQuery("select post_req_from  from  post_req where post_req_to='"+id+"' and status='pending'");
	 
		while(resultSet.next())
		{
			v.add(resultSet.getString(1));
		}
		System.out.println("User req from : "+v);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	DBConnection.CloseConnection(rs, statement, con);
	}
	return v;
}



public static Vector get_post_Req_id(String id)
{
	Vector <String> v=new Vector<String>();
	try
	{
		con=DBConnection.getConnection();
		String usercode="";
		statement=con.createStatement();
	   ResultSet resultSet  = statement.executeQuery("select p_id  from  post_req where post_req_to='"+id+"' and status='pending'");
	 
		while(resultSet.next())
		{
			v.add(resultSet.getString(1));
		}
		System.out.println("User req from : "+v);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	DBConnection.CloseConnection(rs, statement, con);
	}
	return v;
}






public static boolean update_m_pos_status(String id) 
{
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="update m_votes set pos_vote=pos_vote+1 where post_code_id='"+id+"'";
		System.out.println(sql);
		int i=statement.executeUpdate(sql);	
		
		
		if(i>0)
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}



public static boolean update_m_neg_status(String id) 
{
	
	
	
	
	
	boolean friend_status=false;
	try{
	//boolean	flag=false;
	
		
		con=DBConnection.getConnection();
		statement=con.createStatement();
		sql="update m_votes set neg_vot=neg_vot+1 where post_code_id='"+id+"'";
		System.out.println(sql);
		int i=statement.executeUpdate(sql);	
		
		
		if(i>0)
		{
			friend_status=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-rmvGrp()....."+e);
	}
	
	
	
	return friend_status;
}





public static boolean change_main_post_Status(String p_id)
{
	boolean flag=false;
	try
	{
		con=DBConnection.getConnection();
		String usercode="";
		statement=con.createStatement();
		String sq="update m_votes set status='post' where pos_vote>neg_vot and post_code_id='"+p_id+"'";
		String sq1="update m_votes set status='block' where pos_vote<=neg_vot and post_code_id='"+p_id+"'";
		
		
		int i  = statement.executeUpdate(sq);
		int i1  = statement.executeUpdate(sq1);
		
		if(i!=0 || i1!=0)
		{
			flag=true;
		}
		System.out.println("User change req Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in changeStatus(String from,String to,String status)....."+e);
	}
	finally
	{
	DBConnection.CloseConnection(rs, statement, con);
	}
	return flag;
}



}


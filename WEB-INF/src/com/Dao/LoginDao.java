package com.Dao;



import java.sql.*;

import  com.DataBase.DBConnection;
import com.exception.ImageException;








public class LoginDao 
{
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	static String sql="";
	static boolean flag=false;
	
	//----------------------------- Register -------------------------------------------
	
	public static boolean register(String id,String pass,String name,String gender,String d_o_b,String cell_no,String profile,String hobby,String policy,String imgFeature)
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="insert into m_user (u_login_id,u_pwd,u_name,u_gender,d_o_b,u_cell_no,u_profile_pic,hobbies,policy,feature)values " +
					"('"+id+"','"+pass+"','"+name+"','"+gender+"','"+d_o_b+"','"+cell_no+"','"+profile+"','"+hobby+"','"+policy+"','"+imgFeature+"')";
			System.out.println("Sql....."+sql);
			st.executeUpdate(sql);
			
			sql="insert into m_status (u_name) values ('"+name+"')";
			st1.executeUpdate(sql);
			System.out.println(sql);
			
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet landmark()
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="Select * from u_landmark;";
				
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			
		
			System.out.println(sql);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	public static boolean register1(String pass,String name)
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="insert into m_user1 (m_user,m_pass)values " +
					"('"+pass+"','"+name+"')";
			System.out.println("Sql....."+sql);
			st.executeUpdate(sql);
			
			flag=true;
			System.out.println("values inserted into db_data successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	public static boolean updatePhotoCounts(int photo)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "update imagecount set Count1='"+photo+"' where s_no=1 ";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			i = st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			con.close();
			st.close();
			System.out.println("Change Image status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------- Login -------------------------------------------
	public static boolean login(String id,String pass)
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select * from m_user where u_name='"+id+"' and u_pwd='"+pass+"'";
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			flag=rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean ChkUser(String id)
	{
		boolean result=true;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select * from m_user where u_name='"+id+"'";
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				result=false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("User id is not present--->"+result);
		return result;
	}
	
	//----------------------------- Login user name -------------------------------------------
	public static ResultSet loginusername(String id)
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select u_profile_pic from m_user where u_name='"+id+"' ";
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			String sql="update m_user set u_login_id='"+s[1]+"',u_cell_no='"+s[2]+"',u_gender='"+s[3]+"' where u_code='"+s[0]+"'";
			
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile()....."+e);
		}
		return flag;
	}
	
	public static ResultSet getProfile(String id)
	{
		ResultSet resultSet=null;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			resultSet = st.executeQuery("select * from m_user where u_name='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			System.out.println("select * from m_user where u_name='"+name+"' and u_pwd='"+pass+"'");
			ResultSet resultSet = st.executeQuery("select * from m_user where u_name='"+name+"' and u_pwd='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-loginCHK()....."+e);
		}
		return flag;
	}
	
	public static boolean chnagePass(int id, String cpass)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			int i=st.executeUpdate("update m_user set u_pwd='"+cpass+"' where u_code='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass()....."+e);
		}
		return flag;
	}
	public static boolean chnagePassword(int id, String cpass)
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			int i=st.executeUpdate("update m_user1 set m_pass='"+cpass+"' where m_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass()....."+e);
		}
		return flag;
	}
	
	
	
	
	
	
	
	public static ResultSet get_mage()
	{
		
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="select u_code,u_profile_pic,u_name from m_user";
				
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			
		
			System.out.println(sql);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	
	
	public static int get_mage_count()
	{
		int count=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="select Count1 from imagecount";
				
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			
		while(rs.next())
		{
			count=rs.getInt(1);
		}
			System.out.println(sql);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	
	
	
	public static boolean resetmatches()
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "update m_user set matches_points=0";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			i = st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			con.close();
			st.close();
			System.out.println("Change Image status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	public static boolean updatematches(int id,int count)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "update m_user set matches_points='"+count+"' where u_code='"+id+"' ";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			i = st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			con.close();
			st.close();
			System.out.println("Change Image status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	
	
	public static boolean updateTest(int id,int count)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "insert into  test(dist,id) values ('"+count+"','"+id+"')";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			i = st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			con.close();
			st.close();
			System.out.println("Change Image status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	
	public static boolean emptyTest()
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "truncate test";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			i = st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			con.close();
			st.close();
			System.out.println("Change Image status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	
	
	public static ResultSet select_Test_id()
	{
		boolean flag=false;
		String sql="";
		ResultSet rs=null;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql = "select distinct id from test where dist>=30";
			System.out.println("********** Change Image  Info **********");
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return rs;
	}
	
	
	
	public static String select_User_name(String id)
	{
		boolean result=true;
		String name="";
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select u_name from m_user where u_code='"+id+"'";
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				name=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("User id is not present--->"+name);
		return name;
	}
	
	
	
	
	public static boolean select_post_status(String id)
	{
		boolean result=false;
		String name="";
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select * from m_votes  where post_code_id='"+id+"' and status='post' ";
			System.out.println("Sql..post..."+sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				 result=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("User id is not present--->"+name);
		return result;
	}
	
	//priya code
	
	
	public static String select_User_id(String id)
	{
		boolean result=true;
		String name="";
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select u_name from m_user where u_name='"+id+"'";
			System.out.println("Sql....."+sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				name=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("User id is not present--->"+name);
		return name;
	}
	
	
	public static int adduidimg(String uidimg,String userid)
	{
		int flag=0;
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			Statement st1=con.createStatement();
			sql="update m_user set u_uid_img='"+uidimg+"' where u_name='"+userid+"'";
			System.out.println("Sql....."+sql);
			st.executeUpdate(sql);
			
			//sql="insert into m_status (u_name) values ('"+name+"')";
			
			
			flag=1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static String selectumail(String id)
	{
		boolean result=false;
		String name="";
		try
		{
			con=DBConnection.getConnection();
			st=con.createStatement();
			sql="select u_login_id from m_user  where u_name='"+id+"' ";
			System.out.println("Sql..post..."+sql);
			rs=st.executeQuery(sql);
			/*while(rs.next())
			{
				 result=true;
			}*/
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("User id is not present--->"+name);
		return name;
	}
	
	
	 public static String selectocrid(String userId) throws Exception
	 {
			String ocrid="";
			
			String sql = "";
			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
                sql = "select ocr_id from m_user where u_name='"+userId+"'";
                System.out.println("********** Check User Voting Information *********");
              
				rs=st.executeQuery(sql);
				while(rs.next())
				{
					ocrid=rs.getString(1);
				}
				System.out.println("Voting Status : " + ocrid);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			

			return ocrid;
		}
	 
	 public static String checkUser(String userid) throws ImageException
		{
			String image="";
			
			
			
			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
				
				String sqlquery = "select u_uid_img from m_user where u_name='"+userid+"'";
				
				rs = st.executeQuery(sqlquery);
				
				while(rs.next())
				{
					image=rs.getString(1);
				}
				
				System.out.println("Check User Flag : "+image);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			return image;
		}
		
	 
	  public static int logindao(String id, String pass) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;

			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
				
			

				String sql="select u_name,u_pwd from m_user where u_name='"+id+"' and u_pwd='"+pass+"'";		
				System.out.println(":::::::::::sql user query is:::::::::::"+sql);
				rs=(ResultSet) st.executeQuery(sql);

				while(rs.next())
				{
					
					flag=1;
				}
				

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	   
	  public static String username(String id) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String name="";
			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
				
			

				String sql="select u_name from m_user where u_name='"+id+"'";
				
				rs=(ResultSet) st.executeQuery(sql);

				while(rs.next())
				{
					name=rs.getString("user_name");
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				con.close();
			}

			return name;
		}
	  
	  public static String code(String id) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String code="";
			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
				

				String sql="select u_code from m_user where u_name='"+id+"'";
				
				rs=(ResultSet) st.executeQuery(sql);

				while(rs.next())
				{
					code=rs.getString("user_code");
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				con.close();
			}

			return code;
		}
	  
	  public static int checkUserpass(String userId,String pwd) throws Exception
		 {
				int check=0;
				
				String sql = "";
				try
				{
					con=DBConnection.getConnection();
					st=con.createStatement();
					System.out.println("Statment Established !");
					

	                sql = "select * from m_user where u_name='"+userId+"' and u_pwd='"+pwd+"'";
	                System.out.println("********** Check User Voting Information *********");
	                System.out.println(sql);
					rs=st.executeQuery(sql);
					while(rs.next())
					{
						check=1;
					}
					System.out.println("Voting Status : " + check);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
				return check;
			}
	 
	  public static int update_user_Id(String user_id,String newid) throws SQLException
		{
			int flag=0;

			

			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				System.out.println("Statment Established !");
				
				String sql="update m_user set ocr_id='"+newid+"' where u_name='"+user_id+"'";
				System.out.println("ocr update done>>>>>>>>>>>>>>"+sql);
				int n=st.executeUpdate(sql);
				
System.out.println("n>>>>>>>>>>"+n);
				if(n==1)
				{
					flag=1;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return flag;
		}
}

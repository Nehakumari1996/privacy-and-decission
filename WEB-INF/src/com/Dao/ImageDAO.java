package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DataBase.DBConnection;


public class ImageDAO 
{
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	static String sql="";
	static boolean flag=false;

	
	//------------------------------------ UploadImage into (m_image)-----------------------------
	
	public static ResultSet UploadImage(String filename,String userid,String m_today_date)
	{
		try 
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
			sql="select u_code from m_user where u_name='"+userid+"'";
			System.out.println("sql  :"+sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				usercode=rs.getString(1);
			}
			sql="insert into m_image (u_code,i_file_name,img_tag_date) values ('"+usercode+"','"+filename+"','"+m_today_date+"')";
			System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
			sql="select i_code from m_image where i_file_name='"+filename+"'";
			System.out.println("sql  :"+sql);
			rs=st.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
	
//------------------------------------ Upload Profile picture into (m_image)-----------------------------
	
	public static boolean UploadProfile(String filename,String user)
	{
		try 
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
			sql="update m_user set u_profile_pic='"+filename+"' where u_name='"+user+"' ";
			System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		DBConnection.CloseConnection(rs, st, con);
		}
		return true;
		
	}
	
	//------------------------------------ CommentSubmit into (m_comment)-----------------------------
	public static boolean CommentSubmit(String userid, String m_image_code,String m_comment) 
	{
		try 
		{
			con=DBConnection.getConnection();
			 String usercode="";
			  st=con.createStatement();
			   int x_image_code=Integer.parseInt(m_image_code);
			    sql="select u_code from m_user where u_name='"+userid+"'";
			     System.out.println("sql  :"+sql);
			      rs=st.executeQuery(sql);
			       while(rs.next())
			       {
			         usercode=rs.getString(1);
			        }
			       String date=Utility.getDate()+" "+Utility.getTime();
			     sql="insert into m_tag (i_code,u_code,tag,time) values ('"+x_image_code+"','"+usercode+"','"+m_comment+"','"+date+"')";
			   System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
		
	}
	

	
	public static String getkeywordname(int co_code) throws SQLException
	{
		
		String con_name="root";
		try
		{
			con=DBConnection.getConnection();
			 String usercode="";
			  st=con.createStatement();
			  rs = st.executeQuery("select keyword from m_keyontology where k_code='"+co_code+"' ");
			System.out.println("select keywords from m_content_ontology where co_code='"+co_code+"'");
			while(rs.next())
			{
				con_name=rs.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Content_dao class-->getContentName() : "+e);
		}
		finally
		{
			//DBConnection.closeConnection(connection, statement, resultSet);
		}
		return con_name;
	}
	
	
	public static ResultSet getkeywordDetails() throws SQLException
	{
		ArrayList<String> loc_names=new ArrayList<String>();
		try
		{
			con=DBConnection.getConnection();
			 String usercode="";
			  st=con.createStatement();
			rs = st.executeQuery("select * from m_keyontology ");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ImageDAO->ImageDAO() : "+e);
		}
		finally
		{
			//DBConnection.closeConnection(connection, statement, resultSet);
		}
		return rs;
	}
	
	public static ResultSet getdefaultwebsites() throws SQLException
	{
		ArrayList<String> loc_names=new ArrayList<String>();
		try
		{
			con=DBConnection.getConnection();
			 String usercode="";
			  st=con.createStatement();
			rs = st.executeQuery("select * from m_site");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ImageDAO->ImageDAO() : "+e);
		}
		finally
		{
			//DBConnection.closeConnection(connection, statement, resultSet);
		}
		return rs;
	}
	
	public static ResultSet SelectPosts(String x_user_id) 
	{
		ResultSet resultSet=null;
		Statement statement=null;
		Connection connection=null;
		try 
		{
			ArrayList<String> names=new ArrayList<String>();
			ArrayList<String> u_code=new ArrayList<String>();
			connection=DBConnection.getConnection();
			statement=connection.createStatement();
		
			sql="select grp_in from m_group where grp_uid='"+x_user_id+"'";
			//System.out.println(sql);
			resultSet=statement.executeQuery(sql);
			//To get their own posts
			names.add(x_user_id);
			
			//To get the Group peoples name
			while(resultSet.next())
			{
				names.add(resultSet.getString(1));
			}
			
			
			
			//To get their u_code
			for(int i=0;i<names.size();i++)
			{
				sql="select u_code from m_user where u_name='"+names.get(i)+"'";
			//	System.out.println(sql);
				resultSet=statement.executeQuery(sql);
				while(resultSet.next())
				{
					u_code.add(String.valueOf(resultSet.getInt(1)));
				
				}
			//	System.out.println("Names are---->"+names.get(i));
			}
			
		
			
			//query for retriving posts
			sql="select u.u_name,u.u_profile_pic,i.i_code,i.i_file_name from m_image i left join m_user u  on u.u_code=i.u_code where u.u_code='"+u_code.get(0)+"'"; 
                   
			
                if(u_code.size()>1)
                  {
                	  for(int i=1;i<u_code.size();i++)
                	  {
                	  sql=sql+" or u.u_code='"+u_code.get(i)+"'";
                	  }
                  }
					
				sql=sql+"order by i.i_code desc";
				resultSet=statement.executeQuery(sql);
				System.out.println(sql);;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*finally
		{
			DBConnection.Close(connection);
		}*/
		return resultSet;
		
	}


	public static ResultSet AllPosts() 
	{
		ResultSet resultSet=null;
		Statement statement=null;
		Connection connection=null;
		try 
		{
			ArrayList<String> names=new ArrayList<String>();
			ArrayList<String> u_code=new ArrayList<String>();
			 connection=DBConnection.getConnection();
			 statement=connection.createStatement();
		
			sql="select grp_in from m_group";
			//System.out.println(sql);
			 resultSet=statement.executeQuery(sql);
			//To get their own posts
			
			
			//To get the Group peoples name
			while(resultSet.next())
			{
				names.add(resultSet.getString(1));
			}
			
			
			//if(names.size()>0)
			//To get their u_code
			for(int i=0;i<names.size();i++)
			{
				sql="select u_code from m_user where u_name='"+names.get(i)+"'";
			//	System.out.println(sql);
				resultSet=statement.executeQuery(sql);
				while(resultSet.next())
				{
					u_code.add(String.valueOf(resultSet.getInt(1)));
				
				}
			//	System.out.println("Names are---->"+names.get(i));
			}
			
		
			
			//query for retriving posts
			sql="select u.u_name,u.u_profile_pic,i.i_code,i.i_file_name from m_image i left join m_user u  on u.u_code=i.u_code where u.u_code='"+u_code.get(0)+"'"; 
                   
                if(u_code.size()>1)
                  {
                	  for(int i=1;i<u_code.size();i++)
                	  {
                	  sql=sql+" or u.u_code='"+u_code.get(i)+"'";
                	  }
                  }
					
				sql=sql+"order by i.i_code desc";
				resultSet=statement.executeQuery(sql);
				//System.out.println(sql);;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*finally
		{
			DBConnection.CloseConnection(resultSet, statement, connection);
		}*/
		return resultSet;
		
	}

	public static boolean addContent(String con_name, String parent) {
		try 
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
			sql="insert into m_keyontology (keyword,parent) values ('"+con_name+"','"+parent+"')";
			System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		DBConnection.CloseConnection(rs, st, con);
		}
		return true;
		
	
	
}
	public static boolean check(String wor)
	{
		boolean flg = false;
		try
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
		String sql = "select *from t_word where f_word='"+wor+"'";
		
		//System.out.println(sql);
		rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static int takeontologypattern(String word) throws SQLException
	{
		
		int patternnum=0;
		try
		{
			con=DBConnection.getConnection();
			 String usercode="";
			  st=con.createStatement();
			  rs = st.executeQuery("select k_code from m_keyontology where keyword='"+word+"'");
			System.out.println("select k_code from m_keyontology where keyword='"+word+"'");
			while(rs.next())
			{
				patternnum=rs.getInt(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Content_dao class-->getContentName() : "+e);
		}
		finally
		{
			//DBConnection.closeConnection(connection, statement, resultSet);
		}
		return patternnum;
	}

	public static boolean insertontologypattern(String removedbrace,
			String sb11,String name) {
		try 
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
			sql="update m_user set tell_about='"+removedbrace+"', ontology_pattern='"+sb11+"' where u_name='"+name+"' ";
			System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		DBConnection.CloseConnection(rs, st, con);
		}
		return true;
		
}
	
	public static boolean insertontologypattern11(String removedbrace,String data,
			String name) {
		try 
		{
			con=DBConnection.getConnection();
			String usercode="";
			st=con.createStatement();
			sql="update m_user set tell_about='"+removedbrace+"',ontology_pattern='"+data+"' where u_name='"+name+"' ";
			System.out.println("sql  :"+sql);
			st.executeUpdate(sql);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		DBConnection.CloseConnection(rs, st, con);
		}
		return true;
		
}
	//priya code//
		public static ResultSet selectuserid_img()
		{
			
			try
			{
				con=DBConnection.getConnection();
				st=con.createStatement();
				Statement st1=con.createStatement();
				sql="select u_code,u_name, u_login_id,u_uid_img from m_user";
					
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

		
		 public static int checkid(String id) throws Exception
			{
				int check=0;

				Connection con=null;
				Statement stmt = null;
				ResultSet rs=null;
				
				try
				{
					con=DBConnection.getConnection();
					st=con.createStatement();
					Statement st1=con.createStatement();

					rs=stmt.executeQuery("select user_id from m_user where user_id='"+id+"'");

					while(rs.next())
					{
						check=1;
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

				return check;
			}
			
		 public static ResultSet selectuid() throws SQLException
			{
				
				try
				{
					con=DBConnection.getConnection();
					
					  st=con.createStatement();
					rs = st.executeQuery("select * from m_user");
					/*while(rs.next())
					{
						String userid=rs.getString(5);
						System.out.println("userid is>>>>>>>>>>>>>"+userid);
					}
					*/
				}
				catch(Exception e)
				{
					System.out.println("Exception in ImageDAO->ImageDAO() : "+e);
				}
				
				return rs;
			}
		    
		 
		 public static String selectumail(String id)
			{
				//boolean result=false;
				String u_login_id="";
				try
				{
					con=DBConnection.getConnection();
					st=con.createStatement();
					sql="select u_login_id from m_user  where u_name='"+id+"' ";
					System.out.println("Sql..post..."+sql);
					rs=st.executeQuery(sql);
				while(rs.next())
					{
						 u_login_id=rs.getString(1);
						 System.out.println("u_login_id>>>>>>>>>>>>"+u_login_id);
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					
				}
				
				return u_login_id;
			}
}
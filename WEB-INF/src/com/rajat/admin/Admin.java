/**
 * 
 */
package com.rajat.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.DataBase.DBConnection;
import com.Dao.*;





public class Admin 
{
	static Connection con=null;
	static Statement statement=null;
	static ResultSet resultSet=null;
	static String sql="";
	static boolean flag=false;
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			resultSet = statement.executeQuery("select * from adminlogin where adminid='"+name+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	
	public static ResultSet getProfile(String name)
	{
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="select * from adminlogin where adminid='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="update adminlogin set name='"+s[1]+"',email='"+s[2]+"',phone='"+s[3]+"' where id='"+s[0]+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	


	public static boolean chnagePass(int id, String cpass) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			int i=statement.executeUpdate("update adminlogin set password='"+cpass+"' where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass()....."+e);
		}
		return flag;
	}
	public static ResultSet getUsers() 
	{
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			resultSet = statement.executeQuery("select * from userlogin");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	public static ResultSet getStatus() 
	{
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			resultSet = statement.executeQuery("select * from m_user left join m_status on m_user.u_name=m_status.u_name");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getStatus()....."+e);
		}
		return resultSet;
	}
	
	public static ResultSet getStatusByName(String name) 
	{
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select * from m_status where u_name='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getStatusByName()....."+e);
		}
		return resultSet;
	}
	
	
	public static int getUserCode(String name)
	{
		int u_code=0;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="select * from m_user where u_name='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				u_code=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getuserCode()....."+e);
		}
		return u_code;
	}
	
	
	public static boolean deleteUser(int u_code) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_user where u_code='"+u_code+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
	
	public static boolean deleteUserFrom_m_update(String up_to) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_update where up_to='"+up_to+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_update : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_update()....."+e);
		}
		return flag;
	}
	
	public static boolean deleteUserFrom_m_status(String u_name) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_status where u_name='"+u_name+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_status()....."+e);
		}
		return flag;
	}
	public static boolean deleteUserFrom_m_request(String req_from) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_request where req_from='"+req_from+"' or req_to='"+req_from+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_request : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_request()....."+e);
		}
		return flag;
	}
	
	
	public static boolean deleteUserFrom_m_image(int u_code) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_image where u_code='"+u_code+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_image : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_image()....."+e);
		}
		return flag;
	}
	
	public static boolean deleteUserFrom_m_tag(int u_code) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_tag where u_code='"+u_code+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_image : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_image()....."+e);
		}
		return flag;
	}
	
	public static boolean deleteUserFrom_m_group(String username) 
	{
		boolean flag=false;
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			String sql="delete from m_group where grp_uid='"+username+"' or grp_in='"+username+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user From m_group : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUserFrom_m_group()....."+e);
		}
		return flag;
	}
	
	
	
	
	
	public static  void UpdateStatusFirstStage() 
	{
		//System.out.println("In Update Status");
		boolean flag=false;
		ArrayList<String>name=new ArrayList<String>();
		ArrayList<Integer> total_request=new ArrayList<Integer>();
		ArrayList<Integer> accepted_request=new ArrayList<Integer>();
		ArrayList<Integer> rejected_request=new ArrayList<Integer>();
		ArrayList<Integer> pending=new ArrayList<Integer>();
		ArrayList<String>  rejection_ratio=new ArrayList<String>();
		ArrayList<String>  status=new ArrayList<String>();
		
		float rejection_percentage=0;
		float pending_percentage=0;
		float total_percentage=0;
		
		int th1=Integer.parseInt(Utility.getPro("th1"));
		int th2=Integer.parseInt(Utility.getPro("th2"));
		int rr1=Integer.parseInt(Utility.getPro("rr1"));
		int rr2=Integer.parseInt(Utility.getPro("rr2"));
		
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			Statement statement1=con.createStatement();
			ResultSet rs=null;
			resultSet=statement.executeQuery("select * from m_status");
			//ADding the data of m_status in a arraylist
			while(resultSet.next())
			{
				name.add(resultSet.getString(2));
				total_request.add(resultSet.getInt(3));
				accepted_request.add(resultSet.getInt(4));
				rejected_request.add(resultSet.getInt(5));
				pending.add(resultSet.getInt(6));
				rejection_ratio.add(resultSet.getString(7));
				status.add(resultSet.getString(8));	
			}
			
			
			//loop to know about all users who are in monitoring state
			for(int i=0;i<name.size();i++)
			{
				
				System.out.println("Names----"+name.get(i)+"--TH1--"+th1);
				
					if(rejected_request.get(i)>0)
					{
					System.out.println("Rejected requests---"+rejected_request.get(i)+"--TH1 value---"+th1);
					System.out.println("Total requests----"+total_request.get(i)+"-----RR1----"+rr1);
					
					int reject=rejected_request.get(i);
					int total=total_request.get(i);
					
					//calculating the rejection of particular user
					System.out.println("Reject---"+reject+"--total---"+total);
					
					rejection_percentage=(reject * 100/total);
						
					//calculating their rejection percentage
					 System.out.println("Rejection percentage---"+rejection_percentage);
					 System.out.println("Pending value---"+pending.get(i));
					 if(pending.get(i)>0)
					 {
						//check to know about status of pending requests 
					 pending_percentage=((pending.get(i)*100/total_request.get(i)))/2;
					 System.out.println("Pending percentage---"+pending_percentage);
					 }
					 else
					 {
						 pending_percentage=0;
					 }
					  
					total_percentage=rejection_percentage+pending_percentage;
					
					//Check to take threshold value 1 is exceeding or not
					if(rejected_request.get(i)>=th1)
					{
						
					if(total_percentage>=rr1)
					{
						//if exceeding their monitoring
					sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='monitor' where u_name='"+name.get(i)+"'";
					System.out.println(sql+"\n");
					statement1.executeUpdate(sql);
					
					
					}
					else
					{
						//after monitoring it may go into general state again
						sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='general' where u_name='"+name.get(i)+"'";
						statement1.executeUpdate(sql);
						System.out.println(sql+"\n");
						
					 }
				   }
					//else in general case
					else
					{
						sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='general' where u_name='"+name.get(i)+"'";
						statement1.executeUpdate(sql);
						System.out.println(sql+"\n");
						
					   }
				 }	
			
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-UpdateStatus()....."+e);
		}
		
	}
	
	//After monitoring status only thie method works
	public static  void UpdateStatusSecondStage() 
	{
		//System.out.println("In Update Status");
		boolean flag=false;
		ArrayList<String>name=new ArrayList<String>();
		ArrayList<Integer> total_request=new ArrayList<Integer>();
		ArrayList<Integer> accepted_request=new ArrayList<Integer>();
		ArrayList<Integer> rejected_request=new ArrayList<Integer>();
		ArrayList<Integer> pending=new ArrayList<Integer>();
		ArrayList<String>  rejection_ratio=new ArrayList<String>();
		ArrayList<String>  status=new ArrayList<String>();
		
		float rejection_percentage=0;
		float pending_percentage=0;
		float total_percentage=0;
		
		int th1=Integer.parseInt(Utility.getPro("th1"));
		int th2=Integer.parseInt(Utility.getPro("th2"));
		int rr1=Integer.parseInt(Utility.getPro("rr1"));
		int rr2=Integer.parseInt(Utility.getPro("rr2"));
		
		try
		{
			con=DBConnection.getConnection();
			statement=con.createStatement();
			Statement statement1=con.createStatement();
			ResultSet rs=null;
			resultSet=statement.executeQuery("select * from m_status where u_status='monitor'");
			
			while(resultSet.next())
			{
				name.add(resultSet.getString(2));
				total_request.add(resultSet.getInt(3));
				accepted_request.add(resultSet.getInt(4));
				rejected_request.add(resultSet.getInt(5));
				pending.add(resultSet.getInt(6));
				rejection_ratio.add(resultSet.getString(7));
				status.add(resultSet.getString(8));	
			}
			
			for(int i=0;i<name.size();i++)
			{
				System.out.println("Names----"+name.get(i)+"--TH2--"+th2);
				
					System.out.println("Rejected requests---"+rejected_request.get(i)+"--TH2 value---"+th2);
					System.out.println("Total requests----"+total_request.get(i)+"----RR2----"+rr2);
					
					int reject=rejected_request.get(i);
					int total=total_request.get(i);
					
					System.out.println("Reject---"+reject+"--total---"+total);
					rejection_percentage=(reject * 100/total);
								
					 System.out.println("Rejection percentage---"+rejection_percentage);
					 
					 System.out.println("Pending value---"+pending.get(i));
					 
					 if(pending.get(i)>0)
					 {
					 pending_percentage=((pending.get(i)*100/total_request.get(i)))/2;
					 System.out.println("Pending percentage---"+pending_percentage);
					
					 }
					 else
					 {
						 pending_percentage=0;
					 }
					  
					total_percentage=rejection_percentage+pending_percentage;
					
				if(rejected_request.get(i)>=th2)
				{
					if(total_percentage>=rr2)
					{
					sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='fake' where u_name='"+name.get(i)+"'";
					System.out.println(sql+"\n");
					statement1.executeUpdate(sql);
					
					
					}
				else if(total_percentage>=rr1)
					{
						sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='monitor' where u_name='"+name.get(i)+"'";
						System.out.println(sql+"\n");
						statement1.executeUpdate(sql);
						
					}
				else
				{
					sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='general' where u_name='"+name.get(i)+"'";
					System.out.println(sql+"\n");
					statement1.executeUpdate(sql);
				}
					
				}
				else
				{
				 if(rejected_request.get(i)>=th1)
				  {
						
					if(total_percentage>=rr1)
					{
						//if exceeding their monitoring
					sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='monitor' where u_name='"+name.get(i)+"'";
					System.out.println(sql+"\n");
					statement1.executeUpdate(sql);
					
					
					}
					else
					{
						//after monitoring it may go into general state again
						sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='general' where u_name='"+name.get(i)+"'";
						statement1.executeUpdate(sql);
						System.out.println(sql+"\n");
						
					 }
					
					}
				 else
				  {
					sql="update m_status set rej_ratio ='"+rejection_percentage+"',pen_ratio='"+pending_percentage+"',total_ratio='"+total_percentage+"',u_status='general' where u_name='"+name.get(i)+"'";
					System.out.println(sql+"\n");
					statement1.executeUpdate(sql);
				  }
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-UpdateStatusSecondStage()....."+e);
		}
		
	}



	
}

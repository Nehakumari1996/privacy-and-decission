package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DataBase.DBConnection;

public class StatusDAO {
	
	static Connection con=null;
	static Statement statement=null;
	static ResultSet rs=null;
	static String sql="";
	static boolean flag=false;
	
	
	public static boolean updateToatalRequests(String from)
	{
		boolean flag=false;
		try
		{
			int total_requests=0;
			int pending_requests=0;
			con=DBConnection.getConnection();
			statement=con.createStatement();
			sql="select tot_req,pending from m_status where u_name='"+from+"' " ;
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next())
			{
				total_requests=rs.getInt(1);
				pending_requests=rs.getInt(2);
				
				total_requests=total_requests+1;
				pending_requests=pending_requests+1;
				
				sql="update m_status set tot_req='"+total_requests+"',pending='"+pending_requests+"' where u_name='"+from+"'";
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
			}
			else
			{
				sql="insert into m_status set u_name='"+from+"',tot_req='1',pending='1'";
				int i=statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
			}	
			System.out.println("update Toatal Requests status--->"+flag);
			//System.out.println("User send req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in ststusDao updateToatalRequests....."+e);
		}
		
		return flag;
	}
	
	public static boolean updateAcceptRequests(String from)
	{
		boolean flag=false;
		try
		{
			int accept_requests=0;
			int pending=0;
			con=DBConnection.getConnection();
			statement=con.createStatement();
			Statement statement1=con.createStatement();
			sql="select acc_req,pending from m_status where u_name='"+from+"' " ;
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next())
			{
				accept_requests=rs.getInt(1);
				pending=rs.getInt(2);
				
				accept_requests=accept_requests+1;
				pending=pending-1;
				
				sql="update m_status set acc_req='"+accept_requests+"',pending='"+pending+"' where u_name='"+from+"'";
				System.out.println(sql);
				int i=statement1.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
			
			}	
			System.out.println("update Accept Requests status--->"+flag);
			//System.out.println("User send req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in statusDao AcceptRequests....."+e);
		}
		
		return flag;
	}
	
	public static boolean updateRejectRequests(String from)
	{
		boolean flag=false;
		try
		{
			int reject_requests=0;
			int pending=0;
			con=DBConnection.getConnection();
			statement=con.createStatement();
			Statement statement1=con.createStatement();
			sql="select rej_req,pending from m_status where u_name='"+from+"' " ;
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next())
			{
				reject_requests=rs.getInt(1);
				pending=rs.getInt(2);
				
				reject_requests=reject_requests+1;
				pending=pending-1;
				
				
				sql="update m_status set rej_req='"+reject_requests+"',pending='"+pending+"' where u_name='"+from+"'";
				System.out.println(sql);
				int i=statement1.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
			}
				
			System.out.println("update Accept Requests status--->"+flag);
			//System.out.println("User send req Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in satusDao RejectRequests....."+e);
		}
		
		return flag;
	}
	

}

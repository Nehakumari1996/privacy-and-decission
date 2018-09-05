package com.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection 
{
	
	
	public static Connection getConnection()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myprivacy_ocr","root","admin");
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	
	
	
	
	public static Connection getConnection1()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");// Type 4 driver
			//System.out.println("Driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/friendbook","root","admin");
			//System.out.println("connection established");
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	public static Connection getConnection2()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");// Type 4 driver
			//System.out.println("Driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/friendbook","root","admin");
			//System.out.println("connection established");
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return con;
		
	}
	public static void CloseConnection(ResultSet rs,Statement st,Connection con) 
	{
		if(rs!=null)
		{
			try 
			{
				rs.close();
				rs=null;
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(st!=null)
		{
			try 
			{
				st.close();
				st=null;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(con!=null)
		{
			try 
			{
				con.close();
				con=null;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		//System.out.println("connection closed ");
	}
	
	public static void Close(Connection con) 
	{
		
		
		
		if(con!=null)
		{
			try 
			{
				con.close();
				con=null;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		//System.out.println("connection closed ");
	}
}

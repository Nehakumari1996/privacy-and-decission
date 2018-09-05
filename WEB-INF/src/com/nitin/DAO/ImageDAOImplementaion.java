/*package com.nitin.DAO;

import com.exception.ImageException;


import java.sql.*;
import java.util.Vector;

public class ImageDAOImplementaion implements ImageDAO
{
	public int getTotalImages()throws ImageException
	{
		int count=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			rs = null;
			
			String sqlquery = "select * from m_pwdimage where img_flag='f'";
			
			rs = stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				count+=1;
			}
			
			System.out.println("Total no. of images in DB : "+count);
			
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return count;		
	}
	
	
	public int getTotalUsers()throws ImageException
	{
		int count=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			rs = null;
			
			String sqlquery = "select * from m_user where user_pwd='-null-'";
			
			rs = stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				count+=1;
			}
			
			System.out.println("Total no. of users in DB : "+count);
			
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return count;		
	}
	
	
	public Vector[] getImages(int totalimages) throws ImageException
	{
		Vector imagelist[] = new Vector[totalimages];
		
		String imgcode=null,imgname=null,imgword=null;
		
		int count=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			rs = null;
			
			String sqlquery = "select * from m_pwdimage where img_flag='f'";
			
			rs = stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				imgcode = rs.getString("img_code").trim();
				
				imgword = rs.getString("img_word").trim();
				
				imgname = rs.getString("img_filename").trim();		
				
				Vector v = getVector(imgcode, imgword, imgname);
				
				imagelist[count++] = v;
			}			
			
			//System.out.println("Image vector size : "+imagelist.length);
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return imagelist;		
	}
	
	
	public Vector[] getUser(int totalusers) throws ImageException
	{
		Vector userlist[] = new Vector[totalusers];
		
		String userid=null,useremail=null,usercode=null;
		
		int count=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			rs = null;
			
			String sqlquery = "select * from m_user where user_pwd='-null-'";
			
			rs = stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				usercode = rs.getString("user_code").trim();
				
				userid = rs.getString("user_id").trim();
				
				useremail = rs.getString("user_email").trim();
				
				Vector v = getVector(usercode, userid, useremail);
				
				userlist[count++] = v;
			}			
		
			//System.out.println("User vector size : "+userlist.length);
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return userlist;		
	}
	
	
	public int setUserFlag(String userid,String password,String imagecode,String userflag) throws ImageException
	{
		int updateflag=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			String sqlquery = "update m_user set user_pwd='"+password+"',user_flag='"+userflag+"',img_code='"+imagecode+"' where user_id='"+userid+"'";
			
			updateflag = stmt.executeUpdate(sqlquery);
					
			//System.out.println("The User Update Flag : "+updateflag);
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return updateflag;
	}
	
	
	public int setImageFlag(int[] imagecode,String imageflag) throws ImageException
	{
		int updateflag=0;
		
		Connection con = null;
		
		Statement stmt = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			String sqlquery = "update m_pwdimage set img_flag='"+imageflag+"' where img_code="+imagecode+"";
			
			for(int i=0;i<imagecode.length;i++)
			{
				updateflag = stmt.executeUpdate("update m_pwdimage set img_flag='"+imageflag+"' where img_code="+imagecode[i]+"");
			}
			
			//System.out.println("The Image Update Flag : "+updateflag);
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return updateflag;
	}
	
	
	public Vector getVector(String value1,String value2,String value3)
	{
		Vector v = new Vector();
		
		v.addElement(value1);
		v.addElement(value2);
		v.addElement(value3);
		
		return v;		
	}
	
	
	public int resetPassword() throws ImageException
	{
		int resetflag1=0,resetflag2=0,flag=0;
		
		Connection con = null;
		
		Statement stmt1 = null,stmt2 = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt1 = con.createStatement();
			
			stmt2 = con.createStatement();
			
			String sqlquery1 = "update m_user set user_pwd='-null-',user_flag='f',img_code=0";
			
			String sqlquery2 = "update m_pwdimage set img_flag='f'";
			
			resetflag1 = stmt1.executeUpdate(sqlquery1);
			
			System.out.println(resetflag1);
			
			if(resetflag1!=1)
			{
				resetflag2 = stmt2.executeUpdate(sqlquery2);
				System.out.println(resetflag2);
				if(resetflag2!=1)
				{
					flag=1;
				}
			}
					
			System.out.println("The reset flag : "+flag);
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt1 != null)
					stmt1.close();
					stmt2.close();
			}

			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return flag;
	}
	
	
	public String checkUser(String userid) throws ImageException
	{
		String image="";
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			serverconnector sc=new serverconnector();
			
			con=sc.connector();
			
			stmt = con.createStatement();
			
			rs = null;
			
			String sqlquery = "select user_image from m_user where user_id='"+userid+"'";
			
			rs = stmt.executeQuery(sqlquery);
			
			while(rs.next())
			{
				image=rs.getString(1);
			}
			
			System.out.println("Check User Flag : "+image);
			
		}
		catch(Exception e)
		{
			throw new ImageException(e);
		}
		finally
		{
			try 
			{
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}
			catch (Exception e) 
			{
				throw new ImageException(e);
			}
		}
		return image;
	}
	

}
*/
<%@page import="com.Dao.ImageDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<%=request.getContextPath() %>/css/menu.css" rel="stylesheet" type="text/css" />
 <link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
 <link href="<%=request.getContextPath()%>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>

<style type="text/css" media="screen">
	#menuh{float:none;}
	body{behavior:url(csshover.htc); font-size:75%;  }
	#menuh ul li{float:left; width: 70%;}
	#menuh a{height:1%;font:normal 1em/1.6em  helvetica,  "Trebuchet MS", arial, sans-serif;}
</style>
<%
response.setIntHeader("Refresh",7);
%>
</head>
<body >
		<div id="container">
		<div id="content" style="padding-top: 30px;padding-right: 10px;">
			<%!
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				ResultSet rs1=null;
				String sql="";
				int count=0;
				int i=0;
				int j=0;
				
				
				ArrayList arr_name=new ArrayList();
				ArrayList arr_profile=new ArrayList();
				ArrayList<Integer> arr_icode=new ArrayList<Integer>();
				ArrayList arr_fname=new ArrayList();
				ArrayList arr_comment=new ArrayList();
				
			
			%>
			
			<%
					con=DBConnection.getConnection();
					st=con.createStatement();
					
					rs=ImageDAO.AllPosts();
					while(rs.next())
					{
						
						arr_name.add(rs.getString(1));
						arr_profile.add(rs.getString(2));
						arr_icode.add(rs.getInt(3));
						arr_fname.add(rs.getString(4));
					}
					
					if(count==0)
					{
						for(;i<arr_name.size();i++)
						{
							
					%>
					<!---------------------------------- User Profile and User name and Uploaded Image  ------------------------------->
					<table>
						<tr style="margin-top: 60px;">
							<td>
								<table>
								<tr>
								<td >
									<span style="color:navy;font-family: georgia,sans-serif;font-weight: bold;"><%=arr_name.get(i) %></span>
								</td>
								</tr>
								<tr ><td ><img src="<%=request.getContextPath()%>/user_input_image/<%=arr_fname.get(i)%>" ></img></td></tr>
								</table>
							</td>
						</tr> 
					</table>
						
				<!-------------------------------------------- Corresponding image Comments  ------------------------------->
						
						<div style="">
						<% 	
							int i_code= arr_icode.get(i);
							//System.out.println("i_code is-------->"+i_code);
							String sql="select u.u_name,c.tag from m_tag c join m_user u on u.u_code=c.u_code where i_code='"+i_code+"'";
							//System.out.println(sql);
							rs=st.executeQuery(sql);
							while(rs.next())
							{ %>
							<table  style="background-color: #EEE9E9;	width: 400px; padding-left: 20px;"  >
							<tr >
								<td width="20px" ><span style="color:navy;font-family: georgia,sans-serif;font-weight: bold;"><%=rs.getString(1) %></span></td>
								<td ><%=rs.getString(2) %></td>
								
							</tr>
							<tr><td colspan="2"><hr color="white" size="2" align="right"></hr></td></tr>
						</table>
						
				<!---------------------------------------------- User Comments  ------------------------------->				
							<% }	%>
							
						<% }
						
						i=arr_name.size();
						} 
					
						%>
		 </div>
		
		
		  </div>
		
</body>
</html>
<%@page import="com.Dao.LoginDao"%>
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

<link href="<%=request.getContextPath() %>/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Resources/CSS/button.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Resources/CSS/message.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>

<style type="text/css" media="screen">
#menuh {
	float: none;
}

body {
	behavior: url(csshover.htc);
	font-size: 75%;
}

#menuh ul li {
	float: left;
	width: 70%;
}

#menuh a {
	height: 1%;
	font: normal 1em/1.6em helvetica, "Trebuchet MS", arial, sans-serif;
}
</style>
<%
String x_name=(String)session.getAttribute("user_id"); 
String x_profile=(String)session.getAttribute("x_profile");		
response.setIntHeader("Refresh", 15);
%>
</head>
<body>
	<div id="container">
		<div id="content" style="padding-top: 30px; padding-right: 5px;">
			<%!
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				ResultSet rs1=null;
				String sql="";
				int count=0;
				int i=0;
				int j=0;
				
				
				ArrayList<Object> arr_name=new ArrayList<Object>();
				ArrayList<Object>arr_profile=new ArrayList<Object>();
				ArrayList<Integer> arr_icode=new ArrayList<Integer>();
				ArrayList<Object> arr_fname=new ArrayList<Object>();
				ArrayList<Object>arr_comment=new ArrayList<Object>();
				
			
			%>

			<%
					con=DBConnection.getConnection();
					st=con.createStatement();
					String x_user_id=session.getAttribute("user_id").toString();
					
					String id=LoginDao.select_User_id(x_user_id);
					
					
					
					
						
					rs=ImageDAO.SelectPosts(x_user_id);
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
							
							boolean post_status=LoginDao.select_post_status(arr_icode.get(i).toString());
							if(post_status)
							{
							
					%>
			<!---------------------------------- User Profile and User name and Uploaded Image  ------------------------------->
			<table>
				<tr style="padding-top: 0px;">
					<td style="padding-bottom: 60px;">
					<td style="padding-right: 100px;">
					<img
						src="<%=request.getContextPath()%>/profile_pics/<%=arr_name.get(i)%>/<%=arr_profile.get(i)%>"
						width="40px;" height="40px;"></img></td>
					<td>
						<table>
							<tr>
								<td><span
									style="color: navy; font-family: georgia, sans-serif; font-weight: bold;"><%=arr_name.get(i) %></span>
								</td>
							</tr>
							<tr>
								<td><img
									src="<%=request.getContextPath()%>/user_input_image/<%=arr_fname.get(i)%>" width="80px;" height="80px;"></img></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<!-------------------------------------------- Corresponding image Comments  ------------------------------->

			<div style="padding-left: 140px;">
				<% 	
							int i_code= arr_icode.get(i);
							//System.out.println("i_code is-------->"+i_code);
							String sql="select u.u_name,c.tag from m_tag c join m_user u on u.u_code=c.u_code where i_code='"+i_code+"' order by c.time";
							System.out.println("----"+sql);
							rs=st.executeQuery(sql);
							while(rs.next())
							{ %>
				<table
					style="background-color: #EEE9E9; width: 400px; padding-left: 20px;">
					<tr>
						<td width="20px"><span
							style="color: navy; font-family: georgia, sans-serif; font-weight: bold;"><%=rs.getString(1) %></span></td>
						<td><%=rs.getString(2) %></td>

					</tr>
					<tr>
						<td colspan="2"><hr color="white" size="2" align="right"></hr></td>
					</tr>
				</table>

				<!---------------------------------------------- User Comments  ------------------------------->
				<% }	%>
				<form action="<%=request.getContextPath()%>/CommentSubmit1"
					method="post">
					<table
						style="background-color: #EEE9E9; width: 400px; padding-left: 20px;">
						<tr>
							<td width="20px"><span
								style="color: navy; font-family: georgia, sans-serif; font-weight: bold;"><%=x_name %></span></td>

							<td><input id="s" type="text" name="comment" size="45px"
								placeholder="Write a comment..."
								style="font-size: 10px; color: black;" /> <input id="x"
								type="submit" value="comment" /></td>
							<td><input type="hidden" name="image_code"
								value="<%=i_code %>"></input></td>
						</tr>

					</table>
				</form>
				<hr color="white" size="0.01"></hr>
			</div>
			<hr size="0.01" width="450px" align="left"></hr>
			<% }
					}		
						i=arr_name.size();
			  } %>
		</div>


	</div>

</body>
</html>
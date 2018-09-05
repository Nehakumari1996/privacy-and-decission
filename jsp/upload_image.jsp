<%@page import="java.sql.ResultSet"%>
<%@page import="com.Dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<script language="javascript">
	function check()
	{
		if(document.f1.file.value.length==0)
		{
			alert("Please Select a File");
			return false
		}
		else
		{
			return true;
		}
	}
</script>
</head>
<body >
	
		
		 <h3>Upload<span style="color:#710069;font-family: georgia,sans-serif;font-weight: bold;"> Post</span> </h3>
		<%
			String x_name=(String)session.getAttribute("x_name"); 
			String x_profile=(String)session.getAttribute("x_profile");		
			String i_code=(String)request.getAttribute("i_code");
			String x_filename=(String)request.getAttribute("filename");
			String coowner=(String)request.getParameter("coowner");
			System.out.println("i_code jsp :"+i_code);
			System.out.println("x_filename jsp :"+x_filename);
			System.out.println("coowner :"+coowner);
			

			
			
		%>
		  
			<div style="height: 100%" >
				<table  align="center" bordercolor="" width="100px;" height="200px;" >
				 <form name="f1" action="<%=request.getContextPath()%>/ReadFile" method="post" enctype="multipart/form-data">
					
					<tr>
					<!-- <td style="padding-right: 100px;"> -->
						<td style="color: #710069;" ><b>File Name</b></td>
						<td>:</td>
						<td><input type="file"  name="file" required="required"></input></td>
						<td><input type="submit"  value="Upload Image" class="gradientbuttons" onclick="return check();"></input></td>
					</tr>
				
		  		</form>
				  <form name="f1" action="<%=request.getContextPath()%>/CommentSubmit1" method="post" >
					<tr>
						<td style="color: #710069; width: 150px" ><b>Image</b></td>
							<td>:</td>
							<td><img src="<%=request.getContextPath()%>/user_input_image/<%=x_filename %>" width="100px;" height="100px;"></img></td>
					</tr>
					<tr>
						<td style="color: #710069; width: 150px" ><b>Comment</b></td>
							<td>:</td>
							<td>
								<input id="s1" type="text" name="comment"   placeholder="Write a comment..." style="font-size: 15px; color: black;"/>
							
							</td>
							<td><input type="hidden" name="image_code" value="<%=i_code %>"></input></td>
							<td><input type="hidden" name="u_name" value="<%=x_name %>"></input></td>	
					</tr>
						
		
				</table>
				        <td style="padding-right: 100px;">
						<div align="center">
							<input  type="submit" name="login" value="Submit" class="gradientbuttons" onclick="return Changepass()"></input>
						
							<input  type="reset" name="reset" class="gradientbuttons" value="Reset"/>
						</div>
				</div>	
			
			<div align="center">
			<table>
						<tr>
						<td style="color: #710069; width: 250px; left: 250px;"> OWNER IS <%=x_name %>
	                                                                     <br> <%=coowner%>
	 </td>
						</tr>
		</table>
		</div>
			</form>
		
	
</body>


</html>
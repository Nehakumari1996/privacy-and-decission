
<%@page import="com.Image.Utility"%>
<%@page import="com.Dao.GroupDAO"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
int no=Utility.parse(request.getParameter("no"));
%>
<html>
<head>

	<link href="<%=request.getContextPath() %>/Res/CSS/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/Res/JS/style.js"></script>
	<link href="<%=request.getContextPath() %>/Res/CSS/message.css" rel="stylesheet" type="text/css" /> 
</head>
<body onload="startTimer();">
<%
if(no==2)
{
%>

<br>

<h3><font color="#710069">Your Group(Click on Image to Remove)</font></h3>
<%
		
	String user=GroupDAO.parse1(request.getAttribute("user"));
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	Vector<String> v=new Vector<String>();
	if(rs!=null)
		while(rs.next())
		{%>
			<a href="<%=request.getContextPath() %>/CreateGroup?task=delete&grp_in=<%=rs.getString(3) %>&grp_uid=<%=rs.getString(2) %>">
			<img height="50" width="50" src="<%=request.getContextPath() %>/Res/Images/user.png" style="padding-top:10px" title="<%=rs.getString(3) %>"></img></a>
			<p id="grp"><%=rs.getString(3) %></p>		
		<%
		v.add(rs.getString(3));
		}
	v.add(user);
	ResultSet rs1=GroupDAO.getUsers(v);
	%>
		<br></br>
		<h3><font color="#710069">Add to Group(Click on Image to Add)</font></h3>
	<%
	if(rs1!=null)
		while(rs1.next())
		{if(!GroupDAO.chkStatus(user,rs1.getString(1)).equalsIgnoreCase("pending")){%>
			<a href="<%=request.getContextPath() %>/SendRequest?from=<%=user %>&to=<%=rs1.getString(1) %>">
			<img height="50" width="50" src="<%=request.getContextPath() %>/Res/Images/user.png" style="padding-top:10px" title="<%=rs1.getString(1) %>"></img></a>
			<p id="grp"><%=rs1.getString(1) %></p>		
		<%}}
		}
%>

<%


if(no==1)
{%>
	<div class="error" id="message" style="margin-top: 30px;">	
		<p>Already Friend Request Sent...!</p>
	</div>			
<%}

%>

</body>
</html>	
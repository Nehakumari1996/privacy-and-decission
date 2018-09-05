
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


 <link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" /> 
     
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" /> 
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	
	<script src="<%=request.getContextPath() %>/Resources/JS/jquery-1.6.4.min.js" type="text/javascript"></script>


</head>
<body onload="startTimer();">
<%

int no=Integer.parseInt(request.getParameter("no"));
if(no==1)
{%>
	<div class="success" id="message">	
		<p>Your Friend Request Sent Successfully...!</p>
	</div>			
<%}else
if(no==11)
{
%>
<div class="success" id="message">	
		<p>Your Comment Posted Successfully...!</p>
	</div>

<%
}else
	if(no==2)
	{
%>
<div class="error" id="message">	
		<p>Problem Occured...Try Again!</p>
	</div>
<%} else
if(no==50)
{
%>
<div class="success" id="message">	
		<p>Removed Successfully...!</p>
	</div>

<%} %>
</body>
</html>
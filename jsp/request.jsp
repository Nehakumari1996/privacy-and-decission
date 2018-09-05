<%@page import="com.Dao.GroupDAO"%>

<%@ page import="java.util.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/Res/CSS/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%
	String user = request.getParameter("user");
	Vector <String> v=GroupDAO.getReq(user);
	for(int i=0;i<v.size();i++)
	{%>
		<div class="request">
		<form action="<%=request.getContextPath() %>/CreateGroup">
		<p><%=v.get(i) %></p>
		<img height="50" width="50" src="<%=request.getContextPath() %>/Res/Images/user.png" style="padding-left:22px" title="<%=v.get(i) %>"></img></a>
		<input type="hidden" name="from" value="<%=v.get(i) %>">
		<input type="hidden" name="to" value="<%=user %>">
		<input id="button" type="submit" value="Accept" name="task"><input id="button" name="task" type="submit" value="Reject">
		</form>
		</div>
	<%}
%>
	
</body>
</html>
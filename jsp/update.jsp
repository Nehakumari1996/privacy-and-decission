<%@page import="com.Dao.GroupDAO"%>

<%@ page import="java.util.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	String user = request.getParameter("user");
	Vector <String> v=GroupDAO.getUpd(user);
	GroupDAO.changeStatus(user);
	for(int i=0;i<v.size();i++)
	{%>
		<li>
			<%=v.get(i) %>
		</li>
	<%}
%>
</body>
</html>
<%@ page import="com.Image.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String user = Utility.parse1(session.getAttribute("userid"));
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	int no = Utility.parse(request.getParameter("no"));
	int id = 0;
	String userid = "", name = "", gender = "", add = "", email = "", phone = "", city = "";
	if (no == 0)
		while (rs.next()) {
			id = rs.getInt(1);
			userid = rs.getString(2);
			name = rs.getString(4);
			phone = rs.getString(5);
			email = rs.getString(6);

		}
%>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
	<link href="<%=request.getContextPath()%>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	
				<style>
table, tr, td
th, td
{
padding:10px;
}
</style>
</head>
<body onload="startTimer()">
		<%
			if (no == 1) {
		%>
					<div class="error" id="message">	
						<p>Opp's,Seems something went wrong ..!</p>
					</div>
				<%
					}
					if (no == 0) {
				%>
					
					
					<div style="margin-left: 400px; margin-top: 30px;">
							<a class="gradientbuttons"
								href="<%=request.getContextPath()%>/EditProfile1?name=<%=user%>&no=1" target="afrm">Edit Profile</a>
							<a class="gradientbuttons" href="<%=request.getContextPath()%>/ChangePass1?name=<%=user%>&no=1&id=<%=id%>" target="afrm">Change Password

							</a>	
				</div>
				
			<div align="center" style="margin-top:10px;">
					<table  style="width: 400px  ;color: #F4CC70; size: 5;; font-family: cursive; " >
					<tr>
							<td align="center" colspan="5"><label><font
							style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">Admin Profile</font></label></td>
						</tr>
						<tr><td>ID No : </td><td><%=id%></td></tr>
						<tr><td>Name : </td><td><%=userid%></td></tr>
						<tr><td>User ID: </td><td><%=name%></td></tr>
						<tr><td>Mail ID: </td><td><%=email%></td></tr>
						<tr><td>Cell No: </td><td><%=phone%></td></tr>
						
					
						</table></div>
				<%
					if (Utility.parse(request.getParameter("no1")) == 1) {
				%>
						<div class="success" id="message">	
							<p>Your profile updated successfully ..!</p>
						</div>
					<%
						}
						}
					%>
</body>
</html>
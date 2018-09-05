<%@ page import="com.Image.*" %>
<%@ page import="java.sql.*" %>
<html>
<%
	String user = Utility.parse1(session.getAttribute("userid"));
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	int no = Utility.parse(request.getParameter("no"));
	int id = 0;
	String username = "",email="",mob="", status = "";

	
%>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
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
			if (no == 2) {
			%>
						<div class="error" id="message">	
							<p>No Records TO Show ..!</p>
						</div>
					<%
						}
		
		
		
		
					if (no == 0) {
				%>
					
					
				
				
			<div align="center" style="margin-top:10px; margin-left: 0px;">
					<table  style="width: 700px  ;color: #F4CC70; size: 5;; font-family: cursive; " >
					<tr>
							<td align="center" colspan="5"><label><font
							style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">User's Status</font></label></td>
						</tr>
						
						<tr>
						<th>User Name : </th>
						<th>E-mail id : </th>
						<th>Mobile No : </th>
						
						</tr>
						<%
						
						while (rs.next()) {
							
							username = rs.getString(4);
							email = rs.getString(2);
							mob = rs.getString(7);
							
	
						%>
						<tr align="center">
						<td><font color="#fedcba;"><%=username%></font></td>
						<td><font color="#fedcba;"><%=email%></font></td>
						<td><font color="#fedcba;"><%=mob%></font></td>
						
						<td><a href="<%=request.getContextPath()%>/DeleteUser?name=<%=username%>" class="gradientbuttons"/>Delete</td>
						</tr>
						
						<%} %>
					
						</table></div>
				<%
					if (Utility.parse(request.getParameter("no1")) == 1) {
				%>
						<div class="success" id="message">	
							<p>User Deleted Successfully ..!</p>
						</div>
					<%
						}
				
					if (Utility.parse(request.getParameter("no1")) == 2) {
						%>
							<div class="error" id="message">	
								<p>Problem In Deleting User!!! Try Again ..!</p>
							</div>
						<%
							}		
				
				
						}
					%>
</body>
</html>
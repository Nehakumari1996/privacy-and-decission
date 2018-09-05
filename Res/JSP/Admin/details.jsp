<%@ page import="com.Image.*" %>
<%@ page import="java.sql.*" %>
<html>
<%

	ResultSet rs = (ResultSet) request.getAttribute("rs");
	int no = Utility.parse(request.getParameter("no"));
	int id = 0,tot_req=0,acc_req=0,rej_req=0,pending=0;
	String userid = "", rej_ratio = "", total_ratio = "", pending_ratio = "", status = "", phone = "", city = "";
	if (no == 0)
		while (rs.next()) {
			id = rs.getInt(1);
			userid = rs.getString(2);
			tot_req=rs.getInt(3);
			acc_req=rs.getInt(4);
			rej_req=rs.getInt(5);
			pending=rs.getInt(6);
			rej_ratio=rs.getString(7);
			pending_ratio=rs.getString(8);
			total_ratio=rs.getString(9);
			status=rs.getString(10);
		

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
				
				
			<div align="center" style="margin-top:10px;">
					<table  style="width: 400px  ;color: #F4CC70; size: 5;; font-family: cursive; " >
					<tr>
							<td align="center" colspan="5"><label><font
							style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">User Details</font></label></td>
						</tr>
						<tr><td>ID No : </td><td><%=id%></td></tr>
						<tr><td>Name : </td><td><%=userid%></td></tr>
						<tr><td>Total Requests: </td><td><%=tot_req%></td></tr>
						<tr><td>Accepted Request: </td><td><%=acc_req%></td></tr>
						<tr><td>Rejected Requests </td><td><%=rej_req%></td></tr>
						<tr><td>Pending Requests </td><td><%=pending%></td></tr>
						<tr><td>Rejected Ratio </td><td><%=rej_ratio%></td></tr>
						<tr><td>Pending Ratio </td><td><%=pending_ratio%></td></tr>
						<tr><td>Total Ratio</td><td><%=total_ratio%></td></tr>
						<tr><td>Status</td><td><%=status%></td></tr>
						
					
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
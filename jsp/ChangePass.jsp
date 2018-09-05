
<%@ page import="com.Image.*" %>
<html>
<head>
	<%
		String user=Utility.parse1(request.getAttribute("user"));
		int no=Utility.parse(request.getParameter("no"));
		int id=Utility.parse(request.getParameter("id"));
	%>
	<link href="<%=request.getContextPath()%>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	
<style>
table, tr, td
{
padding:12px;
}
</style>
</head>
<body onload="startTimer()">

<form action="<%=request.getContextPath() %>/ChangePass">
		<input type="hidden" name="user" value="<%=user %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>

		
		
			<div style="margin-left: 430px; margin-top: 50px;">
			<input class="gradientbuttons" type="submit"  value="Save Updates"/>
			<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?name=<%=user %>&no=1"  target="afrm">
			Edit Profile</a>		
				</div>
		
		<div  style="margin-top: -30px; margin-left: 120px;">
		<table style="width: 400px;color: #F4CC70;">
						
						<tr>
							<td align="center" colspan="5"><label><font
									style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">Change Password</font></label></td>
						</tr>
						
						<tr>
							<td><label><font style="font-family: cursive;">Your Id</font></label>
								</td><td>
								<input type="text" value="<%=user %>"
								tabindex="1" name="id" class="input" placeholder="User Id"
								readonly="readonly">
								</td></tr>
								<tr>
								<td>
								<label>
							<font style="font-family: cursive;">Current Password</font></label>
							</td><td>
							 <input type="password" tabindex="1" class="input" name="pass"
								 required>
						</td></tr>
					
						

						<tr>
							<td><label><font style="font-family: cursive;">New Password</font></label>
							</td><td>
								 <input type="password" tabindex="1"  class="input" name="npass" 
								required>
								</td></tr>
								<tr>
								<td>
								<label><font
									style="font-family: cursive;">Confirm New Password</font></label>
								</td><td>
								<input type="password" class="input" tabindex="2" name="cpass"
								required></td>
						</tr>
					

					</table>
				</div>
<%
if(no==1)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,your current password is wrong ..!</p>
		</div>
	<%
}
if(no==2)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,your new password do not match with confirm password ..!</p>
		</div>
	<%
}
if(no==3)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,Seems something went wrong....!</p>
		</div>
	<%
}
%>	
	
</body>
</html>
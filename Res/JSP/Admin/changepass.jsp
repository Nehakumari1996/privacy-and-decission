
<%@ page import="com.Image.*" %>
<html>
<head>
	<%
		String user=(String)(session.getAttribute("admin"));
		int no=Utility.parse(request.getParameter("no"));
		int id=Utility.parse(request.getParameter("id"));
	%>
	<link href="<%=request.getContextPath()%>/Files/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	
<style>
table, tr, td
{
padding:12px;
}
</style>
</head>
<body onload="startTimer()">

<form action="<%=request.getContextPath() %>/ChangePass1">
		<input type="hidden" name="user" value="<%=user %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		
	<%-- 		<a class="button_example" href="<%=request.getContextPath() %>/EditProfile2?name=<%=user %>&no=1" target="afrm">Edit Profile</a>
			<input type="submit" value="Save Updates" class="button_example" id="a1"/> --%>
		
		
			<div style="margin-left: 400px; margin-top: 30px;">
		<input class="gradientbuttons" type="submit"  value="Save Updates"/>
		<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile1?name=<%=user %>&no=1"  target="afrm">
			Edit Profile</a>
		</div>
			
		
		<div  style="margin-top: 20px; margin-left: 50px;">
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
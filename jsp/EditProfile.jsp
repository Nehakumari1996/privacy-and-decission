<%@ page import="com.Image.*"%>
<%@ page import="java.sql.*"%>
<html>
<%
String user=Utility.parse1(request.getAttribute("user"));
ResultSet rs=(ResultSet)request.getAttribute("rs");
int no=Utility.parse(request.getParameter("no"));
int id=0;
String userid="",name="",gender="",add="",email="",phone="",city="";
if(no==0)
while(rs.next())
{
	id = rs.getInt(1);
	email = rs.getString(2);
	userid = rs.getString(4);
	gender = rs.getString(5);
	phone = rs.getString(7);
}
%>
<head>
	<link href="<%=request.getContextPath()%>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
<style>
table, tr, td
th, td
{
padding:12px;
}

</style>
<style> 
#popup {

    box-shadow: 10px 10px 50px #1A1A14;
}
</style>
</head>
<body onload="startTimer()">
	<div>
		<div  style="height: 400px; width: 600px; padding: 10px; background-color: ;">
			<%
			if(no==1)
			{
				%>
			<div class="error" id="message">
				<p>Opp's,Seems something went wrong ..!</p>
			</div>
			<%
			}
			if(no==0)
			{
				%>


			<form action="<%=request.getContextPath() %>/EditProfile">
					<input type="hidden" name="user" value="<%=user %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					
					
					<div style="margin-top: -20px; margin-left: 100px;">	
				<table  style="width: 400px">
				
					
					<tr>
							<td align="center" colspan="5"><label><font
							style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">Edit Your Details</font></label></td>
						</tr>
					
					<tr><td><label><font style="color: #F4CC70; font-family: cursive;">your Id</font></label></td>
					<td><input type="text" value="<%=id %>" tabindex="1" name="id" class="input"
						placeholder="User Id" readonly="readonly">&nbsp;&nbsp;</td><td>
						
					
					<tr><td><font style="color: #F4CC70; font-family: cursive;">User's id</font></td>
					<td> <input type="text" value="<%=userid %>" 
						class="input" name="name" required>&nbsp;&nbsp;</td></tr>
					
					<tr>
						<td><label> <font style="color: #F4CC70; font-family: cursive;">Gender
						</font></label></td><td> <input type="text" value="<%=gender %>" 
							class="input" name="gender" required>&nbsp;&nbsp;</td>
					</tr>

					<tr>

						<td> <label><font style="color: #F4CC70; font-family: cursive;">Email</font></label></td>
							
							<td><input type="text" tabindex="1" class="input" name="email"
							value="<%=email %>"
							pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" required>&nbsp;&nbsp;</td>
							
							<td></tr>
							<tr><td>
							<label> <font style="color: #F4CC70; font-family: cursive;">Phone</font></label></td>
							<td>
							 <input type="text"
							class="input"  name="phone" value="<%=phone %>"
							pattern="[7-9]{1}[0-9]{9}"
							required></td>
					</tr>
				</table>
				</div>
					
				<div style="margin-top:20px; margin-left: 130px;">
				<input class="gradientbuttons" type="submit"  value="Save Updates"/>
				<a class="gradientbuttons" href="<%=request.getContextPath()%>/ChangePass?name=<%=user%>&no=1&id=<%=id%>" target="afrm">
				  Change Password</a>
				</div>
				
				
		</div>

		</form>

	</div>
	
	<%
			}
		%>
</body>
</html>
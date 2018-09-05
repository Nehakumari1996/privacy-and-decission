
<%@page import="com.Image.Utility"%>
<%@page import="com.Dao.GroupDAO"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<String> similarfriend=new ArrayList<String>();
similarfriend=(ArrayList)request.getAttribute("similarfriend");
int size=similarfriend.size();
StringBuffer buffer = new StringBuffer();
if(size==0)
{%>
	
<div class="gradientbuttons" id="message" style="position:absolute;top:100px;left:0px">
	<p><font color="green"><h2>There are no friends who are similar to your life style</h2></font></p>
<center>
	<div>
</div></center>
	
</div>	
	
<%}
else
{
System.out.println("--------------------------------------------------"+size);


for(int i=0;i<size;i++)
{
	%>

	
	<img height="50" width="50" src="<%=request.getContextPath() %>/Resources/Images/user.png" style="padding-top:20px"></img></a>
	
	<%
	
	
	String uid=GroupDAO.getuserid1(similarfriend.get(i));
	System.out.println("---sinilar friend userid is-----------------------------------------------"+uid);
	
	ResultSet  rs=GroupDAO.getuserpatterndetails(uid);
	double finalontper1=0.0,finalbrowsepat1=0.0,finalhobbypat1=0.0,finalplacepat1=0.0;
	while(rs.next())
	{
		double ontpatt=Double.parseDouble(rs.getString(3));
		
		double browsepatt=Double.parseDouble(rs.getString(4));
		double hobbypattern=Double.parseDouble(rs.getString(5));
		double placepatt=Double.parseDouble(rs.getString(6));
		
		double finalontper=ontpatt*100;
	  finalontper1=  Math.round (finalontper * 10000.0) / 10000.0; 
		System.out.println("---sinilar friend ontology pattern percentage--------------------------------------------"+finalontper1);
		
		double finalbrowsepat=browsepatt*100;
		 finalbrowsepat1=  Math.round (finalbrowsepat * 10000.0) / 10000.0; 
		System.out.println("---sinilar friend browsing pattern percentage------------------------------"+finalbrowsepat1);
		
		double finalhobbypat=hobbypattern*100;
		 finalhobbypat1=  Math.round (finalhobbypat * 10000.0) / 10000.0; 
		System.out.println("---sinilar friend hobby pattern percentage----------------------------------"+finalhobbypat1);
		
		double finalplacepat=placepatt*100;
		 finalplacepat1=  Math.round (finalplacepat * 10000.0) / 10000.0; 
		System.out.println("---sinilar friend place pattern percentage--------------------------------------------"+finalplacepat1);
	}
	%>
	
	
	
	<p id="grp"><font color="green"><h4><%=similarfriend.get(i)%></h4></font></p>
	<p style="display:inline"><font color="maroon"><%=finalontper1%>&nbsp;% &nbsp;of Ontology pattern is similar</font></p>
	<BR>
	<p style="display:inline"><font color="maroon"><%=finalbrowsepat1%>&nbsp;% &nbsp;of Browsing pattern is similar</font></p>
	<BR>
	<p style="display:inline"><font color="maroon"><%=finalhobbypat1%>&nbsp;%&nbsp; of Hobby pattern is similar</p>
	<BR>
	<p style="display:inline"><font color="maroon"><%=finalplacepat1%>&nbsp;% &nbsp;of Place pattern is similar</p>
	<BR>
	
	
		
<% 
System.out.println("--------------------------------------------------"+similarfriend.get(i));
buffer.append(similarfriend.get(i)+" ");
}
int no=Utility.parse(request.getParameter("no"));


String output1 = buffer.toString();
%>
<html>
<head>

	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" /> 
</head>
<body >




<%} %>
</body>
</html>	















<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.pmse.dao.Location_dao"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.pmse.dao.Content_dao"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>PMSE</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/map.js"></script>

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />

<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyByHt0Rn3cnw6t-IIWO18CR0Wv0QX1v6tk&sensor=false">
</script>
<script type="text/javascript">
function Check()
{
	
	var con_name=document.getElementById("address");
	
	if(con_name.value.length==0)
	{
		alert("Please,Enter Keyword..");
		con_name.focus();
		return false;
	}

	
	else

		return true;
}
function checkboxval()
{
	
	var id=document.getElementsByName("con_code");
	
	var no=0;
	
	for(var i=0;i<id.length;i++)
	{
		if(id[i].checked)
			{
				no++;
			}
	}
	if(no==0)
	{
		alert("You must Select atleast one checkbox");
		return false;
	}
	else
	
		return true;
}

</script>
<style type="text/css">
.scrollbar
{
	margin-left: 30px;
	float: left;
	height: 230px;
	width: 450px;
	
	overflow: auto;
	margin-bottom: 25px;
}

#style-1::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: #F5F5F5;
}

#style-1::-webkit-scrollbar
{
	width: 12px;
	background-color: #F5F5F5;
}

#style-1::-webkit-scrollbar-thumb
{
	border-radius: 10px;
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
	background-color: #555;
}


</style>

</head>

<body>
<div id="main_header">
<div id="header">
  
  
  <ul class="navi">
  <li><a href="<%=request.getContextPath()%>/jsp/admin/location.jsp">Location Ontology</a></li>
    <li><a href="<%=request.getContextPath()%>/jsp/admin/content.jsp">Content Ontology</a></li>
    <li><a href="<%=request.getContextPath()%>/jsp/admin/postings.jsp">Postings</a></li>
    <li><a href="<%=request.getContextPath()%>/jsp/admin/changepass.jsp">Change Pass</a></li>
     <li class="li1"><a href="<%=request.getContextPath()%>/Logout">Logout</a></li>
  </ul>
</div>
</div>
<div id="main_body">
	<div id="body">
	    <!--latest event start -->
	    <%! String con_code=null;
	    %>
	  <div id="event">
	   <h2 style="background:url(<%=request.getContextPath()%>/images/content.png) no-repeat ; ">Content  <span>Ontology</span></h2>
	   <form action="<%=request.getContextPath()%>/ContentDetails" method="post">
	   <div style="position: absolute;top: 200px;left: 150px;">
	   <table id=t1>
	   <tr >
		<td>KeyWord</td>
	<%
	con_code=(String)request.getParameter("con_code");
		if(con_code==null)
		{%>
		  	<td><input type="text" name="con_name" id="address" placeholder="Enter Keyword" style="width: 100px;" required="yes"></input></td>
		<%}
		else
		{
			String con_name=Content_dao.getContentName(Integer.parseInt(con_code));
		%>	
	
	   		<td><input type="text" name="con_name" id="address"  value="<%=con_name%>" style="width: 100px;"></input></td>
	   	<%}%>		
	   		<td  style="width: 100px;">Parent</td>
	   		<td><select id="parent" name="parent" style="width: 120px;" required="yes"><option value="0" >root</option>
	   	<%
	   		ResultSet parent=Content_dao.getContentDetails();
		   	while(parent.next())
		   	{
		   	%>
		   		<option value="<%=parent.getInt(1) %>"><%=parent.getString(4) %></option>
	   		<%} %> 
	   		</select></td>
	   	</tr>
		<tr><td><input type="hidden"   name="co_code" value="<%=con_code%>" ></input></td></tr>
		<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
	   	<tr>
	   		
	   		<td style="width: 130px; "align="right"><input type="submit" id="add" name="submit" value="Add" onclick="return Check()"></input></td>
	   		<td style="width: 130px;" align="right"><input type="submit" id="update" name="submit" value="Update" onclick="return Check()" ></input></td>
	   		<td></td>
	   		<td><input type="submit" name="submit" id="add" value="Delete" align="left" onclick="return checkboxval()"></input>	</td>
	   	</tr>
	   
	   </table>
		</div>
			
			<div id="body_content2"  >
			<div class="scrollbar" id="style-1">
		  	<table  style="width: 400px; ">
		  	<tr style="color: black;">
		  			<th></th>
		  			<th>Keyword</th>
		  			<th>Parent</th>
		  			<th></th>
		  		</tr>
		  	<%
			ResultSet rs=Content_dao.getContentDetails();
			while(rs.next())
			{
			%>
		  		<tr>
		  			<td ><input type="checkbox" name="con_code" value="<%=rs.getInt(1)%>" ></input></td>
		  			<td ><input type="text" name="con_name" value="<%=rs.getString(2)%>" style="width: 100px;"></input></td>
		  			<td ><input type="text" name="parent" value="<%=Content_dao.getContentName(rs.getInt(3))%>" style="width: 100px;"></input></td>
		  			<td><a href="<%=request.getContextPath()%>/jsp/admin/content.jsp?con_code=<%=rs.getInt(1)%>" id="l" style="width: 100px;" onclick="Modified()">  Edit</a></td>
		  		</tr>
		  	<%} %>
		  	</table>
		  	
	    </div>
</div>
	    <br></br>
	
			
		

		
	    </form>
	  </div>
	  <!--latest event end -->
	  <br class="balnk" />
	</div>
</div>
<div id="main_footer">
	<div id="footer"><!--footer navigation start -->
		<ul>
			<li><a href="<%=request.getContextPath()%>/jsp/admin/location.jsp" class="mg">Location Ontology</a>|</li>
			<li><a href="<%=request.getContextPath()%>/jsp/admin/content.jsp">Content Ontology</a>|</li>
			<li><a href="<%=request.getContextPath()%>/jsp/admin/postings.jsp"> Postings</a>|</li>
			<li><a href="<%=request.getContextPath()%>/jsp/admin/changepass.jsp">Change Password</a>|</li>

		</ul>
	</div><!--footer navigation end -->
</div>
<%
	String status=null;
	status=request.getParameter("status");
	if(status!=null)
	{
		int k=Integer.parseInt(status);
		if(k==1)
		{%>
			<script >alert("Content Added Sucessfully")</script>
	<% }else if(k==2)
	{%>
		<script >alert("Content Edited Sucessfully")</script>
	<%}else if(k==3)
	{%>
		<script >alert("Content Deleted Sucessfully")</script>
	<%}}%>


</body>
</html>

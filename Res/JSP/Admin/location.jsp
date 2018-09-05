<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.pmse.dao.Location_dao"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.util.ArrayList"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>PMSE</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/map.js"></script>

<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/popup.css" rel="stylesheet" type="text/css" />

<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyByHt0Rn3cnw6t-IIWO18CR0Wv0QX1v6tk&sensor=false">
</script>
<script type="text/javascript">
function Check()
{
	
	var loc_name=document.getElementById("address");
	
	if(loc_name.value.length==0)
	{
		alert("Please,Enter Location..");
		loc_name.focus();
		return false;
	}

	var latitude=document.getElementById("x");
	
	if(latitude.value.length==0)
	{
		alert("Please,Enter Latitude..");
		latitude.focus();
		return false;
	}
	var longitude=document.getElementById("y");
	if(longitude.value.length==0)
	{
		alert("Please,Enter Longitude..");
		longitude.focus();
		return false;
	}
	else

		return true;
}
function checkboxval()
{
	
	var id=document.getElementsByName("loc_code");
	
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
	width: 670px;
	
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
	    <%! String loc_code=null;
	    %>
	  <div id="event">
	   <h2 style="background:url(<%=request.getContextPath()%>/images/location.png) no-repeat ; " >Location  <span>Ontology</span></h2>
	   <form action="<%=request.getContextPath()%>/LocationDetails" method="post">
	   <div style="position: absolute;top: 200px;left: 150px;">
	   <table id=t1>
	   	<tr>
		  	<th align="left">Location</th>
		  	<th  align="left">Latitude</th>
		  	<th  align="left">Longitude</th>
		  	<th  align="left">Parent</th>
		</tr>
	<%
	loc_code=(String)request.getParameter("loc_code");
		if(loc_code==null)
		{%>
			<tr>
	   		<td><input type="text" name="loc_name" id="address" placeholder="Enter Location Name" ></input></td>
	   		<td><input type="text"   id="x" name="latitude"  placeholder="Enter The Latitude" ></input></td>
	   		<td><input type="text"  id="y" name="longitude" placeholder="Enter The Longitude" ></input></td>
	   		<td><select id="parent" name="parent"><option value="0" >root</option>
	   	<%
	   		ResultSet parent=Location_dao.getParentNames();
		   	while(parent.next())
		   	{
		   	%>
		   		<option value="<%=parent.getInt(1) %>"><%=parent.getString(2) %></option>
	   		<%} %> 
	   		</select></td>
	   	</tr>
		<%}
		else
		{
			
			ResultSet rs=Location_dao.getLocationDet(Integer.parseInt(loc_code));
			while(rs.next())
			{
		%>
			
			<tr>
	   		<td><input type="text" name="loc_name" id="address"  value="<%=rs.getString(1)%>"></input></td>
	   		<td><input type="text"   id="x" name="latitude"   value="<%=rs.getDouble(2)%>"></input></td>
	   		<td><input type="text"  id="y" name="longitude" value="<%=rs.getDouble(3)%>"></input></td>
	   		<td><select id="parent" name="parent"><option value="0" >root</option>
	   	<%
			}	
	   	ResultSet parent=Location_dao.getParentNames();
		   	while(parent.next())
		   	{
		   	%>
		   		<option value="<%=parent.getInt(1) %>"><%=parent.getString(2) %></option>
	   		<%} %> 
	   		</select></td>
	   		<td><input type="hidden"   name="lo_code" value="<%=loc_code%>"></input></td>
	   	</tr>
	<%}
	%>		
	   	
	   
	   	<tr>
	   		<td style="width: 200px;height: 50px;"><input type="image" value="submit" src="<%=request.getContextPath()%>/images/google_maps.png" onclick="return getMap()"></input></td>
	   		<td style="width: 200px;"><input type="submit" id="add" name="submit" value="Add" onclick="return Check()"></input></td>
	   		<td style="width: 200px;"><input type="submit" id="update" name="submit" value="Update" onclick="return Check()" ></input></td>
	   		<td><input type="submit" name="submit" id="add" value="Delete" onclick="return checkboxval()"></input>	</td>
	   	</tr>
	   
	   </table>
		</div>
			<div id="light" class="white_content" > 
				<a href = "javascript:void(0)" onclick = "closelightbox()" style="float:right"><img src="<%=request.getContextPath()%>/images/close.gif" alt="" /></a>
				<div id="googleMap"  style="width:675px;height:300px;"></div>
			</div>
		
			<div id="fade" class="black_overlay"></div>
			<div id="body_content" >
			<div class="scrollbar" id="style-1">
		  	<table  style="width: 350px; ">
		  	
		  		<tr style="color: black;">
		  		
		  			<th></th>
		  			<th>Location</th>
		  			<th>Latitude</th>
		  			<th>Longitude</th>
		  			<th>Parent</th>
		  			<th></th>
		  		
		  		</tr>
		  		
		  	<%
			ResultSet rs=Location_dao.getLocationDetails();
			while(rs.next())
			{
			%>
		  		<tr>
		  			<td ><input type="checkbox" name="loc_code" value="<%=rs.getInt(1)%>" style="width: 50px;border-color: white;"></input></td>
		  			<td ><input type="text" name="loc_name" value="<%=rs.getString(2)%>" style="width: 100px;border-color: white;"></input></td>
		  			<td ><input type="text" name="latitude" value="<%=rs.getDouble(3)%>" style="width: 120px;border-color: white;"></input></td>
		  			<td ><input type="text" name="latitude" value="<%=rs.getDouble(4)%>" style="width: 120px;border-color: white;"></input></td>
		  			<td ><input type="text" name="parent" value="<%=Location_dao.getLocationName(rs.getInt(5))%>" style="width: 100px;border-color: white;"></input></td>
		  			<td><a href="<%=request.getContextPath()%>/jsp/admin/location.jsp?loc_code=<%=rs.getInt(1)%>" id="l" style="width: 80px;" >  Edit</a></td>
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
			<script >alert("Location Added Sucessfully")</script>
	<% }else if(k==2)
	{%>
		<script >alert("Location Edited Sucessfully")</script>
	<%}else if(k==3)
	{%>
		<script >alert("Location Deleted Sucessfully")</script>
	<%}}%>


</body>
</html>

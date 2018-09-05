<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Dao.*"%>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath() %>/pagenationcss.css" />
<script src="<%=request.getContextPath() %>/pagenation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%-- <%String usercode="",userid="",userid_img="",emailid="";%> --%>
<%
String passstatus="",mergeSatus="",mergingStatus="",share1_file="",share2_file="";
share1_file = request.getAttribute("share1").toString();
		share2_file = request.getAttribute("share2").toString();
	%>
</head>
<body>
	   
	   		<div class="CSSTableGenerator"  style="width:200px;height:150px; left:100px; position:absolute; top:120px">
 
	   	<center><h4><font color=blue>User ID Authentication sucess... !</font></h4></center>
	
	 <form name="adminloginform" id="quote" action="<%=request.getContextPath() %>/User_Password" method="post" onsubmit="return checkFormValidator()">

 
			
	  		<label><font color=#000000 size="4" >Password:</font></label>
	  		<input type="password" name="password" size="20" /> <br> <br>

	  		<input type="submit" value="Login"> &nbsp;&nbsp;&nbsp; <input type="reset" value="Reset" />
	  		</form>
	  		
	  		
	  		<table>
				         <tr>
				        
				                 <td align="center">
				                 <br>
				                 <br>
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/<%=share1_file%>" width="100px" height="100px">
				                 	    <br>
				                 	  Share1 Image
				                 	  
				                 	
				                 </td>
				                 
				                 <td align="center">
				                 <br>
				                 <br>
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/<%=share2_file %>" width="100px" height="100px">
				                 	   <br>
				                 	   
				                 	  Share2 Image
				                 	  
				                 	
				                 </td>
				                  
				                  <td align="center">
				                 <br> <br>
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/res.png" width="100px" height="100px">
				                 	 <br>
				                 	  Your Authenticated Image
				                 	  
				                 	
				                 </td>
				                 
				                   <td align="center">
				               
				                 	   <font color=red >OCR EXTRACTED DATA IS :</font>
				                 	
				                 </td> 
				                 <td align="center">
				               
				                 	   <font color=blue size=6><b> <%=session.getAttribute("user_id").toString() %> </b></font>
				                 	
				                 </td> 
				         </tr>
				         
				        
				        
				                 
				                 
				         
				 </table>
</div>

	   		
	   		

   	  

</body>


</html>

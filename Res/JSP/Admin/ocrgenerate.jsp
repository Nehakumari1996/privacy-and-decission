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

<%String usercode="",userid="",userid_img="",emailid="";%>

</head>
<body>
	   
	   		<div class="CSSTableGenerator"  style="width:200px;height:150px; left:100px; position:absolute; top:120px">

	   	<form action="<%=request.getContextPath() %>/adduseraction" onsubmit="return checkFormValidator()"  method="post" enctype="multipart/form-data">
	   	<h2 style="color:#069">Generate OCR Key</h2>
	  
	   		<td  style="width: 40px;"><h3 style="color:#069">Select Userid</h3></td>
	   		<td><select id="parent" name="user_id" style="width: 120px;" required="yes"><option value="0" >Userid</option>
	   		
	   	<%
	   		ResultSet rs=ImageDAO.selectuid();
		   	while(rs.next())
		   	{
		   	%>
		   		<option value="<%=rs.getString(5)%>"><%=rs.getString(5) %></option>
	   		<%} %> 
	   		</select>&nbsp;&nbsp;&nbsp;&nbsp;
	   		
	   		</td>
	   		
	   		
	   		 	
	   		<!-- 
	   			<td><h3 style="color:#069">User Id(Image)</h3></td>
	   		
							<td><input type="file" name="user_id_image" id="address" style="width: 100px;" required="yes"></input>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								
							</br></br>	 -->
	   		
	   		
	   		<td  style="width: 100px;">
	   		<input type="submit" id="add" name="submit" value="Add" onclick="return Check()">
	   		</input>
	   		</td>
	   		
	   		 </table> 
	   		</form>
	   		
	  </div>
	   				
	   	<div id="pageNavPosition"  style="position: absolute;top: 460px;left: 150px; height:150px;" ></div>  
<br />  
<script type="text/javascript"><!--  
        var pager = new Pager('results', 4); 
      <%--   var tempValue = '<%=pageno1%>'; --%>
        pager.init();   
        pager.showPageNav('pager', 'pageNavPosition');   
        pager.showPage(1);  
    //--></script>  
	
	  <br class="balnk" />
	</div>
</div>
	   		
	   		
	

<%
	String status=null;
	status=request.getParameter("status");
	if(status!=null)
	{
		int n=Integer.parseInt(status);
		if(n==1)
		{%>
			<script >alert("OCR Generated Sucessfully ")</script>
	<% }else if(n==2)
	{%>
		<script >alert("Content Edited Sucessfully")</script>
	<%}else if(n==3)
	{%>
		<script >alert("Content Deleted Sucessfully")</script>
	<%}}%>

   	  

</body>


</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Image.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script>
        function toggleDisable(cb) {
        	alert('hai');
            var theDiv = document.getElementById('theContainer1');
            theDiv.disabled = !cb.checked;
        }
    </script>
    
   <%
		String user=Utility.parse1(request.getAttribute("user"));
		int no=Utility.parse(request.getParameter("no"));
		int id=Utility.parse(request.getParameter("id"));
	%> 
    
    <script type="text/javascript">
function toggleOther(chosen){
	var piece_to_hide = document.getElementById("otherValues");
	
	if (chosen =='disable') {  
		
	  piece_to_hide.style.display='none'; 
	  
	} 
	else if(chosen =='enable')
	{
	  piece_to_hide.style.display='block'; 
	  
	 
	  document.myform.other.value = '';
	}
	
	}
</script>
    
    
<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<link href="<%=request.getContextPath()%>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 
 
<form  action="<%=request.getContextPath() %>/Tellaboutyourself"  method="post" > 
<div style="position: absolute;top: 100px;left: 150px; height:150px;">
<table>
<tr>
	<td><h3 style="color:#069">Dear User Tell About Yourself:</h3></td>
</tr>
<tr>
 <td>  <textarea name="msg"  rows="5" cols="60"></textarea></td>
   
    </tr>
    
    </table>
    <table>
    
   
 <tr>
 <td><h4 style="color:#069">Upload Browser History</h4></td>
 <td> <select name="values" >

 <option selected value="disable">Disable</option>
 <option value="enable">Enable</option>
 
 </select></td>
 </tr>
  
    <tr>
 <td>
 <input type="submit" name="submit" value="Save"  class="gradientbuttons" >
 </td>

 </tr>
 </table>
 </div>
 </form>
  
  
 <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.js"></script>   
    <script>
        $('#checkbox2').change(function () {
            $('#theContainer2').prop('disabled', !$(this).prop('checked'));
        });
    </script> 
    
    
    
    
    <%
if(no==1)
{
	%>
		<div class="error" id="message">	
			<p>Please Give Some Introduction About You</p>
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

if(no==7)
{
	%>
		<div class="success" id="message">	
			<p>File uploaded successfully..!</p>
		</div>
	<%
}

if(no==8)
{
	%>
		<div class="error" id="message">	
			<p>Opp's,somethong went wrong.!</p>
		</div>
	<%
}
if(no==3)
{
	%>
		<div class="success" id="message">	
			<p>Thanks for your Introduction:)!</p>
		</div>
	<%
}

if(no==10)
{
	%>
		<div class="success" id="message">	
			<p>Please give input file</p>
		</div>
	<%
}
%>
</body>
</html>
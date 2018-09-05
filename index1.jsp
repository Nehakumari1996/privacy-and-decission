<%@page import="com.Image.Utility"%>
<%@page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Insert Search</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="description" content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
        <meta name="keywords" content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript"/>
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
          <link rel="stylesheet" type="text/css" href="css/message.css" />
          	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
		<script src="<%=request.getContextPath()%>/js/cufon-yui.js" type="text/javascript"></script>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/login.js"></script>

		<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
		
		<link href="css/js-image-slider.css" rel="stylesheet" type="text/css" />
   		<script src="<%=request.getContextPath()%>/js/js-image-slider.js" type="text/javascript"></script>

    </head>
    <body onload="startTimer()">
    	<img src="<%=request.getContextPath() %>/images/titleimage.png"  width="100%"  "></img>
   		 <div id="slider" style="margin-top: 15px;" >
        	<img src="<%=request.getContextPath()%>/Web_work/1a.jpg" />
        	<img src="<%=request.getContextPath()%>/Web_work/2a.jpg"  />
        	<img src="<%=request.getContextPath()%>/Web_work/5a.jpg"  />
        	<img src="<%=request.getContextPath()%>/Web_work/7a.jpg"  />
       		<img src="<%=request.getContextPath()%>/Web_work/8a.jpg"  />
       		<img src="<%=request.getContextPath()%>/Web_work/9a.jpg"  />
       		<img src="<%=request.getContextPath()%>/Web_work/10a.jpg"  /> 	 
       		
   		 </div>
   		 <div id="textscrolling" style="margin-top: 50px;" >
			<marquee scrollamount="2" scrolldelay="10"  direction="up" width="350" height="500"
			 onmouseover="this.setAttribute('scrollamount',0,0)" 
			 onmouseout="this.setAttribute('scrollamount',2,0)"  
			 style="font-family: cursive; font-size: 12pt">
					One characteristic of online social networking services
					is their emphasis on the users and their connections,
					in addition to the content as seen in traditional Internet services. 
					<br><br>
					Online social networking data, once published, are of
					great interest to a large audience: Sociologists can verify
					hypotheses on social structures and human behavior
					patterns
					<br><br>
					

			</marquee>
		</div>
		<div class="wrapper">
	
				<div id="form_wrapper" class="form_wrapper" >
				
		
					
					<!-------------------------------Login Form -------------------------------------->
					
					<form class="login active" action="<%=request.getContextPath()%>/AdminLogin" method="post">
						<h3 style="height: 60px;">Admin Login</h3>
						<div style="height: 130px">
							<label style="padding-top: 30px;height: 40px;">User ID:</label>
							<input type="text" name="userid" id="userid" required="yes"/>
							
						</div>
						<div style="height: 110px">
							<label style="height: 40px;">Password: </label>
							<input type="password" name="password" id="password" required="yes"/>
							
						</div>
						
						
						

							<input type="submit" value="Login" onclick="return login()"></input>
							<a href="<%=request.getContextPath() %>/register.jsp"  >New User?</a>
							<div class="clear"></div>
							<a href="<%=request.getContextPath() %>/index.jsp"  >User?</a>
							<div class="clear"></div>
						
					</form>
					
			

			<%
		int no=Utility.parse(request.getParameter("no"));
			
		if(no==1)
{
	%>
		
			<div class="success" id="message" style=" left:300px;height: 100px;width: 300px;" >	
			<p>Account Created Sucessfully!! Login To Continue... </p>
		</div>
			
	<%
}
		if(no==2)
{
	%>
		
			<div class="error" id="message" style=" left:300px;height: 100px;width: 300px;" >	
			<p>Error Occured.. Plss Try Again...</p>
		</div>
			
	<%
}	
		if(no==3)
{
	%>
		
			<div class="success" id="message" style="margin-left:-400px; margin-top:-200px; height: 100px;width: 300px;" >	
			<p>Logout Successfully... </p>
		</div>
			
	<%
}
		if(no==4)
{
	%>
		
			<div class="error" id="message" style=" left:300px;height: 100px;width: 300px;" >	
			<p>Login Failure... </p>
		</div>
			
	<%
}
		%>
		
    </body>
</html>
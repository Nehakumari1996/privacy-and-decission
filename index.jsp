<!DOCTYPE html>
<html lang="en">
  <%@ page import="com.util.*" %>
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Creative - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    
<link rel="stylesheet" type="text/css" href="css/style.css" />
    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">
<!--  -->

    <!--  <link rel="stylesheet" type="text/css" href="css/style1.css" /> -->
  </head>
  
  <%
    int no=Utility.parse(request.getParameter("no"));
    		%>
<%!

	String loginstatus="";
String ocrstatus="";
%>

<%
	loginstatus=request.getParameter("loginstatus");

loginstatus=request.getParameter("loginstatus");
%>
<%!

	String passstatus="",mergeSatus="",mergingStatus="",share1_file="",share2_file="";
%>

<%
	//loginstatus=request.getParameter("loginstatus");
	passstatus=(String)request.getAttribute("passstatus");
	mergeSatus=(String)request.getAttribute("mergeSatus");
	mergingStatus=(String)request.getAttribute("mergingStatus");
%>
  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">My Privacy My Decision</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Admin Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">User Registration</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">User Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <h1 class="text-uppercase">
              <strong>My Privacy My Decision:<br> Control of Photo Sharing on Online Social Networks</strong>
            </h1>
            <hr>
          </div>
          <div class="col-lg-8 mx-auto">
           <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Find Out More</a>
          </div>
        </div>
      </div>
    </header>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-white">My Privacy My Decision:</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">	One characteristic of online social networking services
					is their emphasis on the users and their connections,
					in addition to the content as seen in traditional Internet services. 
					<br><br>
					Online social networking data, once published, are of
					great interest to a large audience: Sociologists can verify
					hypotheses on social structures and human behavior
					patterns</p>
           
          </div>
        </div>
      </div>
    </section>

    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading">Admin Login</h2>
            <center>
            <hr class="my-4">
            
            	<form class="login active" action="<%=request.getContextPath()%>/AdminLogin" method="post">
					
						<div style="height: 130px">
							<label style="padding-top: 30px;height: 40px;">User ID:</label>
							<input type="text" name="userid" id="userid" required="yes"/>
							
						</div>
						<div style="height: 110px">
							<label style="height: 40px;">Password: </label>
							<input type="password" name="password" id="password" required="yes"/>
							
						</div>
						
						
						

							<input type="submit" class="btn btn-primary btn-xl js-scroll-trigger"   value="Login" onclick="return login()"></input>
							
						
					</form>
					</center>
          </div>
        </div>
      </div>
      
      
    </section>

    <section class="p-0" id="portfolio">
       <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">User Registration</h2>
          <center>
         <!--  <div class="wrapper">
		
			<div class="content">

				<div id="form_wrapper" class="form_wrapper" style="margin-top: 12px;"> -->
				
				<!-------------------------------Register Form -------------------------------------->
					<form class="register active" action="<%=request.getContextPath()%>/Register" enctype="multipart/form-data" method="post" >
						<h3 style="height: 15px;">Register</h3>
						
							<label style="padding-top: 20px;height: 40px;">Name</label>
								&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;
								<input type="text" name="name" required="yes"/>
								
							
							
								<label style="padding-top: 20px;height: 40px;">User ID(Email ID):</label>
								 <input type="text" name="userid" pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"  required /> 
							
						
							
								<label style="padding-top: 20px;height: 40px;">Password:</label>
								&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;	
								<input type="password" name="password"  required="yes"/>
								
							<br>
						<table>
						<tr>
							<label style="padding-top: 20px;height: 40px;">Birthday:</label></tr>
						<tr>
						<td><select name="day" id="day"  class="day" required="yes">
								<option value="">Day</option>
									<%
										for(int i=1; i<=31;i++)
										{%>
											<option value="<%=i %>"><%=i %></option>
									<%} %>
							</select></td>
							<td >	
						<select id="BirthMonth" name="BirthMonth" class="month" required="yes" >
							<option value="">Month</option>
								  <option value="01" >
								  January</option>
								  <option value="02" >
								  February</option>
								  <option value="03" >
								  March</option>
								  <option value="04" >
								  April</option>
								  <option value="05" >
								  May</option>
								  <option value="06" >
								  June</option>
								  <option value="07" >
								  July</option>
								  <option value="08" >
								  August</option>
								  <option value="09" >
								  September</option>
								  <option value="10" >
								  October</option>
								  <option value="11" >
								  November</option>
								  <option value="12" >
								  December</option>
							</select></td>
						<td><select name="year" id="year"  class="year" required="yes"> 
								<option value="">year</option>
									<%
										for(int i=1950; i<=2014;i++)
										{%>
											<option value="<%=i %>"><%=i %></option>
									<%} %>
							</select></td>
							</tr>
							</table>
							
								<label style="padding-top: 20px;height: 40px;">Gender:</label>
								<select id="gender" name="gender" class="gender" required="yes">
	  									<option value="">I am...</option>
										<option value="FEMALE" >
										Female</option>
										<option value="MALE" >
										Male</option>
										<option value="OTHER" >
										Other</option>
								</select>
								
							
							
								<label style="padding-top: 20px;height: 40px;">Hobby:</label>
								&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;
								<input type="text" name="hobby" required="yes"/>
							
							
							<br>
								<label style="padding-top: 20px;height: 40px;">Policy:</label>
								&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;
								<select id="policy" name="policy" class="policy" required="yes">
	  									<option value="">Select</option>
										<option value="Friends" >
										Friends</option>
										<option value="Public" >
										Public</option>
										<option value="Get Aproval" >
										Get Aproval</option>
								</select>
								
							
							<br>
								<label style="padding-top: 20px;height: 40px;">Mobile No.</label>
								&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;
								<input type="text" name="mobile"  required="yes"  pattern="[7-9]{1}[0-9]{9}"  maxlength="10" height="10" />
								
						
						
								<label style="padding-top: 20px;height: 40px;">Upload Profile Pic</label>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" class="btn btn-light btn-xl sr-button"  name="pfl_pic"  required="yes"  />
							
						<br>
						
							<br>	
							
							<input type="submit" class="btn btn-primary btn-xl js-scroll-trigger"  value="Register" onclick="return register()"/>
						
							
					</form>
						
				</div>
				<div class="clear"></div>
			</div>
							

		<!-- </div>
		
          </div>
        </div>
      </div> -->
    </section>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
   <br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
   
    <section id="contact">
      <div class="container">
        <div class="row">
  
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">User Login</h2>
                <center>
             <hr class="my-4">
               
            <form class="login active" action="<%=request.getContextPath()%>/userloginaction" method="get">
						
						<div style="height: 130px">
							<label style="padding-top: 30px;height: 40px;">User ID:</label>
							<input type="text" name="user_id" id="userid" required="yes"/>
							
						</div>
						
						
						
						<input type="submit" name="login" value="Get Authentication share2">
						
	
	  		<br> <br>
	  		<input type="submit" name="login" value="Authenticate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

							
							
							<div class="clear"></div>
						
					</form> 
										 <%
    
   	if(no==2)
    {%>
					 <%
	if(loginstatus==null)
	{
		
	}

	else if(loginstatus.equals("failed"))
	{
		%>
	<br><br><br>	
	<center><h4><font color=red>Login Failed, Invalid User!!!</font></h4></center>
<%
	}

%> 	   

<%

	if(passstatus==null)
	{
		
	}

	else if(passstatus.equals("success"))
	{
		%>
	<br><br>	
	<center><b><a href="<%=request.getContextPath()%>/download">Click here to Download share II</a></b></center>
<%
	}
	else if(passstatus.equals("failure"))
	{
%> 	  
	<br><br>	
	<center><h4><font color=red>Invalid user id or password not yet assigned !</font></h4></center>
<%
	}
%>

<%
	if(mergeSatus==null)
	{
		
	}

	else
	{
	%>

	
		<h4><font color=green> 
		
		Choose Share1 and Share2 Image To Merge</font></h4>
		
		<div style="left:200">
		<form action="<%=request.getContextPath() %>/MergeImage" id="quotem" enctype="multipart/form-data" method="post">
		

	  		Choose Share1 &nbsp;&nbsp;&nbsp;
	  		<input type="file" name="share1" size="10" /> 
	  		<br>
	  	
	  		Choose Share2 &nbsp;&nbsp;&nbsp;
	  		<input type="file" name="share2" size="10" /> 
	  		<br>
	  		<input type="submit" value="Merge">
	  		<br> <br>
	  		
	  		</form>
	  		</div>
	
	
<%
	}

%> 	

<%
	if(mergingStatus==null)
	{
		
	}

	else
	{
		share1_file = request.getAttribute("share1").toString();
		share2_file = request.getAttribute("share2").toString();
	%>
	
	<center>
	         <br>
	         <form  action="<%=request.getContextPath() %>/OCR" id="quotem" method="post">
	         <font color="green" size="4"> Your Authenticated Image Details </font>
	          
	            <table>
				         <tr>
				                 <td align="center">
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/<%=share1_file%>" width="100px" height="100px">
				                 	   <br>
				                 	  Share1 Image
				                 	  
				                 	
				                 </td>
				                 
				                 <td align="center">
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/<%=share2_file %>" width="100px" height="100px">
				                 	   <br>
				                 	  Share2 Image
				                 	  
				                 	
				                 </td>
				                  
				                  <td align="center">
				                  <br>
				               
				                  
				                 	   <img alt="" src="<%=request.getContextPath()%>/image_vc/Merged/res.png" width="100px" height="100px">
				                 	 
				                 	  Your Authenticated Image
				                 	  
				                 	
				                 </td>
				                 
				                  <td align="center">
				             <input type="submit" name="login" value="OCR_Process">   	  
				                 	   
				                 	
				                 </td>
				         </tr>
				         
				        
				        
				                 
				                 
				         
				 </table>
				 </form>
	</center>

<%
}
%>   
	 
	  	 
	  	 
	  	 
	  	 
   		
   	<%
   	
   	}
   	
   	
   	
   	
   	
   	
   	
	else if(no==3)
   	{
   		%>
		<center><h4><font color=red> OCR ID and USER ID is Not matching !</font></h4></center>
		
	<%	
		
   	}
   	%>
     
					</center>
					 </div>
        </div>
        
        </div>
      
    </section>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>

  </body>

</html>

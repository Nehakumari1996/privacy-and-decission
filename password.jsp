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
          
            <center>
            <hr class="my-4">
            
            	<center><h4><font color=blue>User ID Authentication sucess... !</font></h4></center>
	
	 <form name="adminloginform" id="quote" action="<%=request.getContextPath() %>/User_Password" method="post" onsubmit="return checkFormValidator()">

<!-- <IMG SRC="images/Web_Header2.jpg" width=100% BORDER="0" ALT="">
 -->
 
 			
 
 
			
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

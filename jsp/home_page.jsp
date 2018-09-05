<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%--  <link href="<%=request.getContextPath() %>/css/stylehome.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/demo.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/style_new.css" rel="stylesheet" type="text/css" />
  <link href='http://fonts.googleapis.com/css?family=Terminal+Dosis' rel='stylesheet' type='text/css' />
   <link href="<%=request.getContextPath() %>/css/stylehome.css" rel="stylesheet" type="text/css" />   --%>


 <link href="<%=request.getContextPath() %>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<%=request.getContextPath() %>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="<%=request.getContextPath() %>/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
    <!-- Custom styles for this template -->
   <link href="<%=request.getContextPath() %>/css/creative.min.css" rel="stylesheet">
<title>User Home</title>


<%
String x_name=(String)session.getAttribute("user_id"); 

System.out.print("login username>>>>>>>>>>>>"+x_name);
String x_profile=(String)session.getAttribute("x_profile");

System.out.print("x_profile image is >>>>>>>>>>>>"+x_profile);
%>
</head>


<body >

<%-- <div style="margin-top: 25px; margin-left: 850px;">
		<label><font style="font-family: Monotype Corsiva; font-size: 25px; color: #DAA520;">Welcome <%=x_name %></font></label>
		</div> --%>

		
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
<span style="color: red;margin-left: -15px;" id='ct' ></span>
				<iframe src="<%=request.getContextPath() %>/jsp/request-message.jsp?user=<%=x_name %>" 
				height="30" width="80" id="req" scrolling="no" frameborder="0" ></iframe> 
				
			<span style="color: red; margin-left: -65px;" id='ct' ></span>
				<iframe src="<%=request.getContextPath() %>/jsp/request-posting.jsp?user=<%=x_name %>" 
				height="30" width="80" id="req" scrolling="no" frameborder="0" ></iframe> 	
				
				
				<div style="margin-top: 10px; margin-left: -35px;">
		<label><font style="font-family: Monotype Corsiva; font-size: 21px; color: #DAA520;">Welcome <%=x_name %></font></label>
		</div>
      <div class="container">
       
        <a class="navbar-brand js-scroll-trigger" href="#page-top">My Privacy My Decision</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          
         
         
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/jsp/posts.jsp" target="afrm" >Home</a>
            </li> 
            
            
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/Profile"  target="afrm">Profile</a>
            </li>
            
           
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/jsp/upload_image.jsp"  target="afrm">Post</a>
            </li>
            
            
              <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath() %>/GroupDetails?name=<%=x_name %>&no=1"  target="afrm">Friend_Request's</a>
            </li>
            
            
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/Logout">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
        
        
        <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
       
      </div>
    </header>













<%-- <img src="<%=request.getContextPath() %>/images/titleimage.png"  width="100%"  "></img>
		<div style="margin-top: 25px; margin-left: 850px;">
		<label><font style="font-family: Monotype Corsiva; font-size: 25px; color: #DAA520;">Welcome <%=x_name %></font></label>
		</div>
		<div>
			 <ul>
				<span style="color: red" id='ct' ></span>
				<iframe src="<%=request.getContextPath() %>/jsp/request-message.jsp?user=<%=x_name %>" 
				height="30" width="100" id="req" scrolling="no" frameborder="0" ></iframe>
				</ul>
		</div>
		
			 
			
			<div class="container">   
             <div class="content">
               <ul class="ca-menu">
                    <li>
                        <a href="<%=request.getContextPath()%>/jsp/posts.jsp" target="afrm">
                            <span class="ca-icon">Home</span>
                            <div class="ca-content">
                               
                                
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/Profile"  target="afrm">
                            <span class="ca-icon">Profile</span>
                            <div class="ca-content">
                        
                            </div>
                        </a>
                    </li>
                    
                    <li>
                        <a href="<%=request.getContextPath()%>/jsp/textarea.jsp"  target="afrm">
                            <span class="ca-icon">Fill_YourDetails</span>
                            <div class="ca-content">
                        
                            </div>
                        </a>
                    </li>
                    
                    <li>
                        <a href="<%=request.getContextPath()%>/jsp/upload_image.jsp" target="afrm">
                            <span class="ca-icon">Post</span>
                            <div class="ca-content">
                                
                            </div>
                        </a>
                    </li>
                   
                    
                    <li>
                        <a href="<%=request.getContextPath() %>/FriendRecommandation?action=Recomand" target="afrm">
                            <span class="ca-icon">Suggested_Friends</span>
                            <div class="ca-content">
                                
                            </div>
                        </a>
                    </li>
                     <li>
                        <a href="<%=request.getContextPath() %>/GroupDetails?name=<%=x_name %>&no=1" target="afrm">
                            <span class="ca-icon">Friend_Request's</span>
                            <div class="ca-content">
                                
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/Logout">
                            <span class="ca-icon">Logout</span>
                            <div class="ca-content">
                              
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div> --%>
			
			<div style="position:absolute;top:170px;left:350px;">
			<iframe src="<%=request.getContextPath() %>/jsp/posts.jsp" frameborder="0" scrolling="auto"
			 name="afrm"  ;margin-left: 100px; margin-top: 100px;" height="500px" width="730px;"></iframe>
			</div> 
		
		 <script src="<%=request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="<%=request.getContextPath() %>/vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="<%=request.getContextPath() %>/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="<%=request.getContextPath() %>/js/creative.min.js"></script>
	
</body>
</html>
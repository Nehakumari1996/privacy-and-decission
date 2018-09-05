<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Admin Home</title>
 <link href="<%=request.getContextPath() %>/css/stylehome.css" rel="stylesheet" type="text/css" /> 


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
</head>



<body id="page-top" >

        
        
        
        
        
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">My Privacy My Decision</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/Res/JSP/Admin/allposts.jsp" target="afrm" >Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/AdminProfile"  target="afrm">Profile</a>
            </li>
            
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/Res/JSP/Admin/ocrgenerate.jsp"  target="afrm">Generate OCR Key</a>
            </li>
            
            
            
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/Status" target="afrm">Users</a>
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
        
        
        
        
        
        
        
        
			
			<div style="position:absolute;top:130px;left:350px;">
			<iframe frameborder="0" scrolling="auto"
			 name="afrm"; src="<%=request.getContextPath()%>/Res/JSP/Admin/allposts.jsp"
			 margin-left: 60px; margin-top: 100px;" height="470px" width="730px;"></iframe>
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
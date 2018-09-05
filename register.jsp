<%@page import="java.sql.ResultSet"%>
<%@page import="com.Dao.Utility"%>
<%@page import="com.Dao.LoginDao"%>
<%@page session="false" %>
<html>
<head>
<style type="text/css">
.checkboxFour {
	width: 40px;
	height: 40px;
	background: #ddd;
	margin: 20px 90px;

	border-radius: 100%;
	position: relative;
	box-shadow: 0px 1px 3px rgba(0,0,0,0.5);
}
</style>
<script>
        function validateEmail(emailField)
        {
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

        if (reg.test(emailField.value) == false) 
        {
            alert('Invalid Email Address');
            emailField.value = null;
            return false;
        }

        return true;

}
        </script>


        
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/style1.css" />
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		
		
					<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/register.js"></script>
		<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
		
		<link href="css/js-image-slider.css" rel="stylesheet" type="text/css" />
   		<script src="<%=request.getContextPath()%>/js/js-image-slider.js" type="text/javascript"></script>
	 	 <link rel="stylesheet" type="text/css" href="css/style.css" />
         <link rel="stylesheet" type="text/css" href="css/message.css" />
         <script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
         <%
		  ResultSet rs= LoginDao.landmark();
         System.out.println("}}}}}}}}}}}}}}}}}}}}"+rs);
		%>
		
		<script type="text/javascript">
    var mytextbox = document.getElementById('mytext');
    var mydropdown = document.getElementById('dropdown');

    mydropdown.onchange = function(){
          mytextbox.value = mytextbox.value  + this.value; //to appened
         //mytextbox.innerHTML = this.value;
    }
</script>
		
		
		
    </head>
    <body>
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
			<marquee scrollamount="2" scrolldelay="10"  direction="up" width="350" height="500" onmouseover="this.setAttribute('scrollamount',0,0)" onmouseout="this.setAttribute('scrollamount',2,0)"  style="font-family: cursive; font-size: 12pt">
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
		
			<div class="content">

				<div id="form_wrapper" class="form_wrapper" style="margin-top: 12px;">
				
				<!-------------------------------Register Form -------------------------------------->
					<form class="register active" action="<%=request.getContextPath()%>/Register" enctype="multipart/form-data" method="post" >
						<h3 style="height: 25px;">Register</h3>
						
							<div style="height: 65px">
								<label style="padding-top: 10px;">Name:</label>
								<input type="text" name="name" required="yes"/>
								<span class="error">This is an error</span>
							</div>
							<div style="height: 65px">
								<label>User ID(Email ID):</label>
								 <input type="text" name="userid" pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"  required /> 
							<!-- 	<input type="text" name="userid" onblur="validateEmail(this);" required /> -->
								
								<span class="error">This is an error</span>
							</div>
						
							<div style="height: 65px">
								<label>Password:</label>
								<input type="password" name="password"  required="yes"/>
								<span class="error">This is an error</span>
							</div>
							
						<table>
						<tr>
							<label>Birthday:</label></tr>
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
							<div style="height: 65px">
								<label>Gender:</label>
								<select id="gender" name="gender" class="gender" required="yes">
	  									<option value="">I am...</option>
										<option value="FEMALE" >
										Female</option>
										<option value="MALE" >
										Male</option>
										<option value="OTHER" >
										Other</option>
								</select>
								<span class="error">This is an error</span>
							</div>
							
							
							<div style="height: 65px">
								<label style="padding-top: 10px;">Hobby:</label>
								<input type="text" name="hobby" required="yes"/>
								<span class="error">This is an error</span>
							</div>
							
							<div style="height: 65px">
								<label style="padding-top: 10px;">Place:</label>
								<input type="text" name="place" required="yes"/>
								<span class="error">This is an error</span>
							</div>
							
							<div style="height: 65px">
								<label>Mobile No.</label>
								<input type="text" name="mobile"  required="yes"  pattern="[7-9]{1}[0-9]{9}"  maxlength="10" height="10" />
								<span class="error">This is an error</span>
							</div>
						
						<div style="height: 55px">
								<label>Upload Profile Pic</label>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="pfl_pic"  required="yes"  />
								<span class="error">This is an error</span>
							</div>
						
						
						
						<div class="bottom">
							<!-- <div class="remember">
								<input type="checkbox" />
								<span>Send me updates</span>
							</div> -->
							<input type="submit" value="Register" onclick="return register()"/>
							<a href="index.jsp" rel="login" >You have an account already? Log in here</a>
							<div class="clear"></div>
						</div>
					</form>
						
				</div>
				<div class="clear"></div>
			</div>
							

		</div>
		

					<%
		int no=Utility.parse(request.getParameter("no"));
			
		if(no==1)
{
	%>
		
			<div class="error" id="message" style="margin-left:-400px; margin-top:-200px; height: 100px;width: 300px;" >	
			<p>User Name Already Exists!! Try With Another One... </p>
		</div>
<%
}
%>

    </body>
</html>

<%@page import="com.Dao.GroupDAO"%>
<html>
<head>
	<link href="<%=request.getContextPath() %>/Res/CSS/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Res/JS/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
function getReq(timeoutPeriod) 
{
	setTimeout("location.reload(true);",timeoutPeriod);
}
function change(val)
{
	
	if(val=="req")
		document.getElementById('request').className='redcolor';
	else if(val=="msg")
		document.getElementById('msg').className='redcolor';
	else if(val=="upd")
		document.getElementById('upd').className='redcolor';
}
function change1(val)
{
	if(val=="req")
		document.getElementById('request').className='Ncolor';
	else if(val=="msg")
		document.getElementById('msg').className='Ncolor';
	else if(val=="upd")
		document.getElementById('upd').className='Ncolor';
}
function call(val,user)
{
	if(val=="req")
		top.frames['afrm'].location.href = 'request.jsp?user='+user;
	else if(val=="upd")
		top.frames['afrm'].location.href = 'update.jsp?user='+user;
	else if(val=="msg")
		top.frames['afrm'].location.href = 'msg.htm';
}
</script>	
<%

	String user=(String)session.getAttribute("user_id");
	String status=GroupDAO.chkStatus(user);
	if(status.equalsIgnoreCase("pending"))
	{%>
		<script type="text/javascript">
		$(document).ready(function(){
			$('a#arequest').trigger('click');
			});
		</script>
	<%}
	boolean update=GroupDAO.chkUpdate(user);
	if(update)
	{%>
		<script type="text/javascript">
		$(document).ready(function(){
			$('a#aupd').trigger('click');
			});
		</script>
	<%}
%>
</head>


<%--
<body onload="JavaScript:getReq(5000);">
 --%>
 
 
<body onload="JavaScript:getReq(5000);">
<a href="#" id="arequest" onclick="change('req');"></a>
<a href="#" id="amsg" onclick="change('msg');"></a>
<a href="#" id="aupd" onclick="change('upd');"></a>

	<a href="#" onclick="call('req','<%=user %>');"><img id="request" src="<%=request.getContextPath() %>/Res/Images/req.png" style="position: absolute;top:-05px;"></img></a>
	<%-- <a href="#" onclick="call('msg','<%=user %>');"><img id="msg" src="<%=request.getContextPath() %>/Resources/Images/msg.png" style="position: absolute;top:-05px;left:40px"></img></a>--%>

</body>
</html>
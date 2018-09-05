function login()
{
	
	var myform=document.forms[0];
	var userId=myform.userid;
	
	if(userId.value.length==0)
	{
		
		alert("Please,Enter your userId ...");
		userid.focus();
		return false;
	}
	
	var pass=myform.password;
	if(pass.value.length==0)
	{
		alert("Please,Enter your Password..");
		password.focus();
		return false;
	}
	
	
	else
		return true;
	
}
function register()
{
	
	var myform=document.forms[0];
	
	var name=myform.name;
	
	if(name.value.length==0)
	{
		
		alert("Please,Enter your name ...");
		name.focus();
		return false;
	}
	
	var userId=myform.userid;
	
	if(userId.value.length==0)
	{
		
		alert("Please,Enter your userId ...");
		userId.focus();
		return false;
	}
	
	var pass=myform.password;
	if(pass.value.length==0)
	{
		alert("Please,Enter your Password..");
		pass.focus();
		return false;
	}
	
	
	var a=myform.BirthMonth;
	
	if(BirthMonth.value=="")
	{
		alert("Please,Enter your Month..");
		BirthMonth.focus();
		return false;
	}
	
	var day=myform.day;
	
	if(day.value=="")
	{
		alert("Please,Enter your Day..");
		day.focus();
		return false;
	}
	
	var year=myform.year;
	
	if(year.value=="")
	{
		alert("Please,Enter your Year..");
		year.focus();
		return false;
	}	
	
	var gender=myform.gender;
	
	if(gender.value=="")
	{
		alert("Please,Enter your Gender..");
		gender.focus();
		return false;
	}	
	
	var moblie=myform.moblie;
	if(moblie.value.length==0)
	{
		alert("Please,Enter your Moblie No..");
		moblie.focus();
		return false;
	}
	
	var num=/[0-9]/;
	if(!moblie.value.match(num))
	{
		alert("Please enter only numbers");
		moblie.value="";
		moblie.focus();
		return false;
	}
	
	if(moblie.value.length<10)
	{
		alert(" Moblie No Must contain 10 numbers..");
		moblie.value="";
		moblie.focus();
		return false;
	}
	
	else
		return true;
	
}
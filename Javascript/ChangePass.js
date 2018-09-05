function Changepass()
		{
	
			var MyForm=document.forms[0];
			var old_pass=MyForm.old_pass;
			
			
				if(old_pass.value.length==0)
				{
					alert("Please,Enter your Password..");
					old_pass.focus();
					return false;
				}

				var new_pass=MyForm.new_pass;
				 if(new_pass.value.length==0)
				{
					alert("Please,Enter your New Password..");
					new_pass.focus();
					return false;
				}

				var re_pass=MyForm.re_pass;
				if(re_pass.value.length==0)
				{
					alert("Please,Enter your Retype_Password..");
					re_pass.focus();
					return false;
				}
				if(new_pass.value!=re_pass.value)
				{
					alert("New password and retype password is mismatched");
					re_pass.focus();
					return false;
				}

				
				else

					return true;
		}

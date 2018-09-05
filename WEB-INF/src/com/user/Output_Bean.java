package com.user;

public class Output_Bean 
{
private static String output;

public String getOutput() 
{
	
	System.out.println("------------------------------------------"+output);
	return output;
}

public void setOutput(String output) 
{
	System.out.println("------------------------------------------"+output);
	this.output = output;
}
}

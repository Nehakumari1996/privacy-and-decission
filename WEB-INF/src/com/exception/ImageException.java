
package com.exception;

public class ImageException extends Exception 
{
	private String error;

	private Throwable cause;

	public ImageException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public ImageException(String message) 
	{
		super(message);
	}

	public ImageException(Throwable cause) 
	{
		super(cause);
	}

	public String getError() 
	{
		return error;
	}

	public void setError(String error) 
	{
		this.error = error;
	}

	public Throwable getCause() 
	{
		return cause;
	}

	public void setCause(Throwable cause) 
	{
		this.cause = cause;
	}
}

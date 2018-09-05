package com.nitin.DAO;

import java.io.*;
import java.util.Vector;

import com.exception.ImageException;

public interface ImageDAO 
{
	public int getTotalImages()throws ImageException;
	
	public int getTotalUsers()throws ImageException;
	
	public Vector[] getImages(int totalimages)throws ImageException;
	
	public Vector[] getUser(int totalusers)throws ImageException;
	
	public int setUserFlag(String userid,String password,String imagecode,String userflag)throws ImageException;
	
	public int setImageFlag(int[] imagecode,String imageflag)throws ImageException;
	
	public int resetPassword()throws ImageException;
	
	public String checkUser(String userid)throws ImageException;	
	
}

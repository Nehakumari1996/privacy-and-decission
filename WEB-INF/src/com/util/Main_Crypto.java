package com.util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class Main_Crypto
{
	
	
	public static boolean runProg(String load, int type,String share1path,String share2path) 
	{

	     boolean valid = false;

	     BufferedImage input;
	     
	     input = InOutImage.loadImage(load);
	     valid = InOutImage.validateImage(input);
	     if (valid==true) {
	       input = AlterImage.monochrome(input);
	       BufferedImage pad1 = AlterImage.createRandom(input);
	       BufferedImage pad2 = AlterImage.meldImages(input, pad1);
	       valid = InOutImage.saveImage(AlterImage.makeGrey(pad1), share1path+"_1", type);
	       valid = InOutImage.saveImage(AlterImage.makeGrey(pad2), share2path+"_2", type);
	       
	     }

	     return valid;
	   }
	
	
	
	
	
	
public static void main(String[] args)
{
	
	 
	runProg("Text6.png", 0,"share1","share1");
	
	MergeImage.mergeImage("share1_1.png", "share1_2.png", "op.png");
}
}

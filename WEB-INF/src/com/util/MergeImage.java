package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 */

/**
 * @author 
 *Mar 29, 2012 4:37:19 PM
 *Project:-ImageStegno
 *Package:-
 *File:-MeargeImage.java
 */
public class MergeImage
{
	public static void mergeImage(String share1ImgPath,String share2ImgPath,String outImagePath)
	{
		try
		{
			BufferedImage img1=readImage(share1ImgPath);
			BufferedImage img2=readImage(share2ImgPath);
			int w1=img1.getWidth();
			int h1=img1.getHeight();
			BufferedImage I = new BufferedImage(w1, h1, BufferedImage.TYPE_BYTE_BINARY);
			WritableRaster wr = I.getRaster();
			int[] a = new int[4];
			int[] b = new int[4];
			for (int i = 0; i < w1; i++)
	        {
	            for (int j = 0; j < h1; j++) 
	            {
	            	int pixel1 = img1.getRGB(i, j);
	            	int pixel2 = img2.getRGB(i, j);
	            	a=getARGBPixelData(pixel1);
	            	b=getARGBPixelData(pixel2);
	            	//System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]);
	            	//System.out.println(b[0]+" "+b[1]+" "+b[2]+" "+b[3]);
	            	if(a[0]==0 && a[1]==0 && a[2]==0 && a[3]==255)
	            	{
	            		wr.setPixel(i, j, a);
	            	}
	            	else
	            	{
	            		wr.setPixel(i, j, b); 
	            	}
	            }
	        }
			ImageIO.write(I, "png", new File(outImagePath));
		}
		catch(Exception e)
		{
			
		}
	}
	private static BufferedImage readImage(String fileLocation)
	{
        BufferedImage img = null;
        try 
        {
            img =ImageIO.read(new File(fileLocation));
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	private static int[] getARGBPixelData(int pixel)
	{
		int[] a = new int[4];
		try
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >>8 ) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0]=red;
        	a[1]=green;
        	a[2]=blue;
        	a[3]=alpha;
		}
		catch(Exception e)
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+e);
		}
		return a;
	}
	public static void main(String maisn[])
	{
		MergeImage.mergeImage("C:\\ShareTest\\dina_1.png","C:\\ShareTest\\dina_2.png","C:\\ShareTest\\res.png");
		
		System.out.println("Image Merge Process Done Sucessfully...");
	}
}

/**
 * 
 */
package com.user;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



/**
 * @author bharath
 *
 */
public class Binory_Image_Convert 
{


public static void convert2(String path,String op) throws IOException
{
	BufferedImage img=ImageIO.read(new File(path));
	
	BufferedImage img2=criaImagemBinaria(img);
	
	
	
	ImageIO.write(img2, "jpg", new File(op));
	
}

public static BufferedImage criaImagemBinaria(BufferedImage imgJPEG)
{
    // Create a new Binary Buffer
    BufferedImage img = new BufferedImage(imgJPEG.getWidth(), imgJPEG.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
    WritableRaster raster = img.getRaster();
    WritableRaster rasterPB =imgJPEG.getRaster();
    // Foreach pixel  check if the new one must be white or black 
    
   System.out.println("-----"+raster.getHeight());
    for(int h=0;h<raster.getHeight();h++)
    {
            for(int w=0;w<raster.getWidth();w++) 
            {
                    int[] p = new int[256];
                   
                    rasterPB.getPixel(w, h, p);
                    if(p[0] > 80) 
                    { 
                    	
                            raster.setSample(w, h, 0, 1);
                            
                    } 
                    else 
                    { 
                    	
                            raster.setSample(w, h, 0, 0);
                            
                    }
            }
            }
    return img;
}

public static void main(String[] args) throws IOException 
{
//	convert2("region_growing.jpg");
}

}

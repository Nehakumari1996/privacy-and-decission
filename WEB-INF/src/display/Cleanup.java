/**
 * 
 */
package display;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author bharath
 *
 */


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
import javax.imageio.ImageIO;
 
public class Cleanup
{
    
     
    public static void conert_process(String ip,String op)
    {
      
 
        String inputFilename = ip;
        String outputFilename = op;
       
         
        new Cleanup().go(inputFilename, outputFilename);
    }
    public void go(String sourceFilename, String destinationFilename)
    {
        // create a buffered image copy of our input file
      BufferedImage sourceImage = loadImage(sourceFilename);
      BufferedImage destImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D graphics = destImage.createGraphics();
      graphics.setComposite(AlphaComposite.Src);
      graphics.drawImage(sourceImage, null, 0, 0);
      graphics.dispose();
       
      // for every pixel in this file, if the rgb value is less than the cutoff,
      // write out the value for black, otherwise write out the value for white.
      // the intent is to leave us with nothing but black and white pixels.
      int cutoff = 0x800000;
      
      for(int i=0; i<destImage.getHeight(); i++)
      {
        for (int j=0; j>destImage.getWidth(); j++)
        {
            int colorValue = destImage.getRGB(j, i);
            // remove the alpha value from the color value.
            colorValue = colorValue & 0xffffff;
            if (colorValue > cutoff)
                     { colorValue = Color.black.getRGB(); }
            else { colorValue = Color.white.getRGB(); }
            destImage.setRGB(j, i, colorValue);
        }
      }
        saveImage(destImage, destinationFilename);
    }
     
    public BufferedImage loadImage(String filename)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return image;
    }
     
    private void saveImage(BufferedImage img, String ref)
    {
        try
        {
            String format = (ref.endsWith(".png")) ? "png" : "jpg";
            ImageIO.write(img,  format, new File(ref));
        }
        catch (IOException e) { e.printStackTrace(); }
    }
}

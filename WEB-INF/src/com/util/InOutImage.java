package com.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class InOutImage {
//no class constructors needed

  static BufferedImage loadImage(String filename){
	  System.out.println("its came inside BufferedImageloadImage");
    BufferedImage in;
    try {
      File filein = new File(filename);
      in = ImageIO.read(filein);
    }
    catch (Exception ex) {
      in = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }
    return in;
  }

  static boolean validateImage(BufferedImage pic)
  {
	  System.out.println("its came inside validateImage");
    boolean valid;
    int x=pic.getWidth();
    if (x>0) {
      x=pic.getHeight();
      if (x>0) valid=true;
        else valid=false;
    }
    else valid=false;
    return valid;
  }

  static boolean saveImage(BufferedImage pic, String filename, int format)
  {
	  System.out.println("its came inside saveImage method");
    boolean valid=false;
    String type="png";
    if (format==1) type="gif";
    filename.trim();
    filename=filename+"."+type;
    try {
      File fileout = new File(filename);
      ImageIO.write(pic,type,fileout);
      valid=true;
    }
    catch (Exception ex) {
      valid = false;
    }
    System.out.println("boolean value is "+valid);
    return valid;

  }

}
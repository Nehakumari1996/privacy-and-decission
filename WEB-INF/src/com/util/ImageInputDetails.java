package com.util;

import java.awt.image.*;

import com.nitin.DAO.*;

public class ImageInputDetails
{

   public static boolean runProg(String load, String name, int type,String share1path,String share2path) {

	   System.out.println("load value is>>>>>>>>>>>>>>>"+load);
     boolean valid = false;

     BufferedImage input;
     
     input = InOutImage.loadImage(load);
     System.out.println("input value is>>>>>>>>>>>>>>>"+input);
     valid = InOutImage.validateImage(input);
     System.out.println("valid value is>>>>>>>>>>>>"+valid);
     if (valid==true) {
       input = AlterImage.monochrome(input);
       BufferedImage pad1 = AlterImage.createRandom(input);
       BufferedImage pad2 = AlterImage.meldImages(input, pad1);
       valid = InOutImage.saveImage(AlterImage.makeGrey(pad1), share1path+name+"_1", type);
       valid = InOutImage.saveImage(AlterImage.makeGrey(pad2), share2path+name+"_2", type);
     }

     return valid;
   }

   static String getName(String path) {
     String named = "";
     String name = "";
     int i,j=0;

     String[] pathall = path.split("\\\\");

     named=pathall[pathall.length-1];

     String[] nameall = named.split("");

     for (i=0;i<nameall.length;i++) if (nameall[i].equals(".")) j=i;

     for (i=0;i<j;i++) name = name + nameall[i];

     return name;
   }

  /* public static void main(String args[])
   {
	   boolean flag=runProg("Image_DB//cv3.jpg", "vc3", 0);
	   System.out.println("Flag : "+flag);
   }*/

}
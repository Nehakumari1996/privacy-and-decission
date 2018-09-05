package com.user;
import org.bytedeco.javacpp.*;
import org.junit.Test;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;
import static org.junit.Assert.assertTrue;

public class BasicTesseractExampleTest 
{
	public static String op;
    @Test
    public static String givenTessBaseApi_whenImageOcrd_thenTextDisplayed(String path) throws Exception
    {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead(path);
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        op = outText.getString();
       
        assertTrue(!op.isEmpty());
        System.out.println("OCR output:" + op);
       
        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
		return op;
    }
    
    public static void main(String[] args) throws Exception 
    {
	givenTessBaseApi_whenImageOcrd_thenTextDisplayed("binary.png");
	}
}
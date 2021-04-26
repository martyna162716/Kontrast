package kontrast;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Kontrast {
  
 BufferedImage image;
 int width;
 int height;
 
 
public Kontrast () {

 try {
   
 File input = new File("widok.jpg");
 image = ImageIO.read(input);
 width = image.getWidth();
 height = image.getHeight();


 for(int i=0; i<height; i++){
 for(int j=0; j<width; j++){

 Color c = new Color(image.getRGB(j, i));
     
 
 int red = (int)(c.getRed());
 int green = (int)(c.getGreen());
 int blue = (int)(c.getBlue());

 int x, y, z;
 
 x = 0;
 y = 0;
 z = 0;

 if ( i>=0 && i<=469 && j>=0 && j<=768 )
   
 {
     
 x = 60; //czerwony
 y = 30; // zielony
 z = -50; //niebieski

 
 }
   
 if (red + x >= 0 && red + x <= 255) red = red + x;
 else red = red;

 if (green + y >= 0 && green + y <= 255) green = green + y;
 else green = green;

 if (blue + z >= 0 && blue + z <= 255) blue = blue + z;
 else blue = blue;
     
 Color newColor = new Color(red, green,blue);
 image.setRGB(j,i,newColor.getRGB());

 } 
 }
   
 File ouptut = new File("widok1.jpg");
 ImageIO.write(image, "jpg", ouptut);

 } catch (IOException e) { }
  
 }
    
    
 static public void main(String args[]) throws Exception
 {
 Kontrast obj = new Kontrast();
 }
}

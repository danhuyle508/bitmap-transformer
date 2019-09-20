package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;
import java.io.*;

public class Bitmap {
    BufferedImage image;
    String url;

    //constructor
    Bitmap(String url){
        try {
            this.url = url;
            this.image = ImageIO.read(new File(url));
        } catch(Exception e) {
            System.out.println("Couldn't find the file");
        }
    }

    //flip horizontally
    public void flipHoriz(String fileOut) {
        System.out.println("Inside flip horizontal");

        //replace in place
        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = 0; x < (this.image.getWidth()) / 2; x++) {
                //Store the first pixel
                int tmpRGB = this.image.getRGB(x, y);

                //replace first pixel with last pixel
                int lastpxl = this.image.getRGB(this.image.getWidth() - x -1, y);
                this.image.setRGB(x, y, lastpxl);

                //set last pixel to tmp/first pixel
                this.image.setRGB(this.image.getWidth() - x - 1, y, tmpRGB);
            }
        }
        try {
            ImageIO.write(this.image, "BMP", new File(fileOut));
        } catch (Exception e) {
            System.out.println("Failed to write hortizontal flip file.");
        }
    }

    public void flipVert(String fileOut) {

        //replace in place
        for (int x = 0; x < this.image.getHeight(); x++) {
            for (int y = 0; y < this.image.getWidth() / 2; y++) {
                //Store the first pixel
                int tmpRGB = this.image.getRGB(x, y);

                //replace first pixel with last pixel
                int lastpxl = this.image.getRGB(x, this.image.getHeight() - y -1);
                this.image.setRGB(x, y, lastpxl);

                //set last pixel to tmp/first pixel
                this.image.setRGB(x, this.image.getHeight() - y - 1, tmpRGB);
            }
        }
        try {
            ImageIO.write(this.image, "BMP", new File(fileOut));
        } catch (Exception e) {
            System.out.println("Failed to write vertical flip file.");
        }
    }

    public void tiedye(String fileOut) {
        for (int x = 0; x < this.image.getHeight(); x++) {
            for (int y = 0; y < this.image.getWidth(); y++) {

                int rgb = this.image.getRGB(x, y);

                //shamelessly copied from; https://stackoverflow.com/questions/4801366/convert-rgb-values-to-integer
                int r = (int) ((Math.pow(256,3) + rgb) / 65536);
                int g = (int) (((Math.pow(256,3) + rgb) / 256 ) % 256 );
                int b = (int) ((Math.pow(256,3) + rgb) % 256);

                int rgbOut = new Color(b, r, g).getRGB();

                this.image.setRGB(x, y, rgbOut);
            }
        }
        try {
            ImageIO.write(this.image, "BMP", new File(fileOut));
        } catch (Exception e) {
            System.out.println("Failed to write vertical flip file.");
        }
    }

}

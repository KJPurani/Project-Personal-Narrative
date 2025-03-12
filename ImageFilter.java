import org.code.theater.*;
import org.code.media.*;

/**
 * ImageFilter extends ImagePlus to provide simple image filtering methods.
 *
 * Preconditions: The image must be loaded correctly.
 * Postconditions: The pixel data is modified based on the applied filter.
 */
public class ImageFilter extends ImagePlus{

  /**
   * Constructor for ImageFilter.
   * @param filename The name of the image file.
   */
  public ImageFilter(String filename){
    super(filename);
  }

  /**
   * Applies a grayscale filter by setting each pixel's red, green, and blue values to their average.
   */
  public void applyGrayscale(){
    Pixel[][] px=getPixels();
    for(int r=0;r<px.length;r++){
      for(int c=0;c<px[r].length;c++){
        Pixel p=px[r][c];
        int avg=(p.getRed()+p.getGreen()+p.getBlue())/3;
        p.setRed(avg); p.setGreen(avg); p.setBlue(avg);
      }
    }
  }

  /**
   * Applies an invert filter by subtracting each color value from 255.
   */
  public void applyInvert(){
    Pixel[][] px=getPixels();
    for(int r=0;r<px.length;r++){
      for(int c=0;c<px[r].length;c++){
        Pixel p=px[r][c];
        p.setRed(255-p.getRed());
        p.setGreen(255-p.getGreen());
        p.setBlue(255-p.getBlue());
      }
    }
  }

  /**
   * Applies a brighten filter by adding 30 to each color value (capped at 255).
   */
  public void applyBrighten(){
    Pixel[][] px=getPixels();
    for(int r=0;r<px.length;r++){
      for(int c=0;c<px[r].length;c++){
        Pixel p=px[r][c];
        int newRed=Math.min(255,p.getRed()+30);
        int newGreen=Math.min(255,p.getGreen()+30);
        int newBlue=Math.min(255,p.getBlue()+30);
        p.setRed(newRed);
        p.setGreen(newGreen);
        p.setBlue(newBlue);
      }
    }
  }
}

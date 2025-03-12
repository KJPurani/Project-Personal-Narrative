
import org.code.theater.*;
import org.code.media.*;

/**
 * ImagePlus extends the basic Image class to load pixel data.
 *
 * Preconditions: The provided filename must be a valid image file.
 * Postconditions: An ImagePlus object is created with its pixel data loaded.
 */
public class ImagePlus extends Image{
  private Pixel[][] pixels;

  /**
   * Constructor that loads the image and its pixels.
   * @param filename The name of the image file.
   */
  public ImagePlus(String filename){
    super(filename);
    pixels=loadPixels();
  }

  /**
   * Returns the 2D array of pixels.
   * @return A 2D array of Pixel objects.
   */
  public Pixel[][] getPixels(){
    return pixels;
  }

  /**
   * Loads pixel data into a 2D array.
   * @return A 2D array of Pixel objects.
   */
  private Pixel[][] loadPixels(){
    Pixel[][] tempPixels=new Pixel[getHeight()][getWidth()];
    for(int row=0; row<tempPixels.length; row++){
      for(int col=0; col<tempPixels[row].length; col++){
        tempPixels[row][col]=getPixel(col,row);
      }
    }
    return tempPixels;
  }
}

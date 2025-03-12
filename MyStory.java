import org.code.theater.*;
import org.code.media.*;

/**
 * MyStory displays the personal narrative using images and captions.
 * It first shows each image unfiltered, then applies a filter based on the caption,
 * and displays the filtered version.
 *
 * Preconditions: captions and images arrays are non-null and of matching dimensions.
 * Postconditions: The scene shows original and filtered images with captions.
 */
public class MyStory extends Scene{
  private String[][] captions;
  private ImageFilter[][] images;

  /**
   * Constructor for MyStory.
   * @param captions A 2D array of captions.
   * @param images A 2D array of ImageFilter objects.
   */
  public MyStory(String[][] captions, ImageFilter[][] images){
    this.captions=captions;
    this.images=images;
  }

  /**
   * Draws the full scene: intro, captions, images (before and after filtering), and a final message.
   */
  public void drawScene(){
    drawIntroScene(); drawCaptionScene();
    drawImageScene(); drawFinalScene();
  }

  /**
   * Draws the introduction screen.
   */
  public void drawIntroScene(){
    clear("black");setTextStyle(Font.SANS,FontStyle.BOLD);
    drawText("My Life in Moments",100,50);pause(1);
  }

  /**
   * Displays all the captions.
   */
  public void drawCaptionScene(){
    clear("white");
    for(int row=0; row<captions.length; row++){
      for(int col=0; col<captions[row].length; col++){
        drawText(captions[row][col],col*250+50,row*150+50);
        pause(0.5);
      }
    }
    pause(1);
  }

  /**
   * For each image, first displays the original image, then applies the filter based on caption content,
   * and finally displays the filtered image.
   */
  public void drawImageScene(){
    clear("white");
    for(int row=0; row<images.length;row++){
      for(int col=0; col<images[row].length;col++){
        String caption=captions[row][col];
        ImageFilter img=images[row][col];
        
        // Draw the original image
        drawImage(img,col*250,row*200,200);
        drawText(caption+" (Original)",col*250+10,row*200+220);
        pause(1);

        // Apply filter
        if(caption.toLowerCase().contains("sunset")||caption.toLowerCase().contains("beach")){
          img.applyGrayscale();
        } else if(caption.toLowerCase().contains("graduation") && !caption.toLowerCase().contains("hiking")){
          img.applyInvert();
        } else if(caption.toLowerCase().contains("picnic")){
          img.applyBrighten();
        } else if(caption.toLowerCase().contains("hiking")||caption.toLowerCase().contains("adventure")){
          img.applyGrayscale();img.applyBrighten();
        }
        
        // Draw the filtered image
        drawImage(img,col*250,row*200,200);
        drawText(caption+" (Filtered)",col*250+10,row*200+220);
        pause(1);
      }
    }
    pause(1);
  }

  /**
   * Draws the final closing screen.
   */
  public void drawFinalScene(){
    clear("black");
    setTextStyle(Font.SANS,FontStyle.ITALIC);
    drawText("Thank you for watching!",100,200);
    pause(1);
  }
}

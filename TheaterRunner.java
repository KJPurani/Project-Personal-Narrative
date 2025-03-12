import org.code.theater.*;
import org.code.media.*;

/**
 * TheaterRunner is the entry point for the project.
 * It creates arrays of image file names, captions, and images (using ImageFilter),
 * then creates a MyStory scene and starts the animation.
 *
 * Preconditions: The image files (sunset.png, picnic.png, graduation.png, hiking.png)
 * must be available in the project directory.
 * Postconditions: The MyStory scene is created and played.
 */
public class TheaterRunner {
  public static void main(String[] args){
    // Array of image file names to load
    String[] imageFiles={"sunset.png","picnic.png","graduation.png","hiking.png"};
    
    // 2D Array of captions (each row represents a chapter, each column an event)
    String[][] captions={
      {"Sunset Beach","Family Picnic"},
      {"Graduation Day","Hiking Adventure"}
    };
    
    // 2D Array of ImageFilter objects for images
    ImageFilter[][] images={
      { new ImageFilter(imageFiles[0]), new ImageFilter(imageFiles[1]) },
      { new ImageFilter(imageFiles[2]), new ImageFilter(imageFiles[3]) }
    };
    
    // Create and play the story scene
    MyStory scene=new MyStory(captions,images);
    scene.drawScene();
    Theater.playScenes(scene);
  }
}

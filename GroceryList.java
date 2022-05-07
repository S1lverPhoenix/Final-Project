import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GroceryList {
    private static Image items;
    
    private static void openItems() {
		if(items==null) {
			try {
				File f = new File("images/grocery.jpeg");
				items = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
        }
    }
}

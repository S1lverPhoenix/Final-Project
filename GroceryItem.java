import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GroceryItem {
    private static Image items;
    File f = new File("images/shelf.jpeg");
    items = ImageIO.read(f);
}

import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GroceryImage {

    public BufferedImage loadImg(String path) throws IOException{
        
        URL url = this.getClass().getResource(path);
        java.awt.image.BufferedImage img = ImageIO.read(url);
        return img;
    }
}

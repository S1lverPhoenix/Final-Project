import java.io.IOException;
import java.net.URL;
import 
import javax.imageio.ImageIO;

public class BufferedImage {

    public java.awt.image.BufferedImage loadImg(String path) throws IOException{
        
        URL url = this.getClass().getResource(path);
        java.awt.image.BufferedImage img = ImageIO.read(url);
        return img;
    }
}

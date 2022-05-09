import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GroceryItem {
    private Image image;
    private String name;
    private double price;
    private boolean show;
    private int xLoc;
    private int yLoc;

    public GroceryItem(Image i, String s){
        image = i;
        name = s;
    }

    public String getName(){
        return name;
    }

    public void addPrice(double d) {
        price = d;
    }

    public void draw(Graphics g) {
    }
    
}

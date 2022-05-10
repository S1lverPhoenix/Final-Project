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

<<<<<<< HEAD

=======
    public void addPrice(double d) {
        price = d;
    }

    public void draw(Graphics g) {
    }
>>>>>>> 6694db76f821195e7e22105737e5666c9f67b4a1
    
}


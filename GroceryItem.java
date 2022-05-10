import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GroceryItem {
    private Image image;
    private String name;
    private int price;
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
    public void addPrice() {
=======
<<<<<<< HEAD

=======
    public void addPrice(double d) {
        price = d;
    }
>>>>>>> 7a6a41764634352f63716928246e0b05ea01e1ab

    }
>>>>>>> 6694db76f821195e7e22105737e5666c9f67b4a1
    
}


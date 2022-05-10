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
=======
<<<<<<< HEAD
    public void addPrice() {
=======
<<<<<<< HEAD
>>>>>>> c5d3553e1a10ca02fc21558c2d67de36cf00406a

    public void addPrice(double d) {
        price = d;
    }
>>>>>>> 7a6a41764634352f63716928246e0b05ea01e1ab

    }

    }



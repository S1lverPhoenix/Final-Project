import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class GroceryItem {
    private Image image;
    private String name;
    private double price;
    private boolean show;
    private int xLoc;
    private int yLoc;
	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, {"Macaroni", "Apples", "Null", "Peanuts", "Milk"},{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}};

    public GroceryItem(String s){
        name = s;
    }

    public String getName(){
        return name;
    }

    public void addPrice(double d) {
        price = d;
    }

    // public void draw(String path) throws IOException{
    //     URL url = this.getClass().getResource(path);
    //     java.awt.image.BufferedImage img = ImageIO.read(url);
    // }

    public void draw(){

        for(int x = 0; x<names.length; x++){
            for(int y = 0; y<names[0].length; y++){
                if(name.equals(names[x][y])){
                    
                }
            }
        }
    }

    public Image getImage(){
        return image;
    }
    
}


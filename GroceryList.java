import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GroceryList {
    private static Image items;
	private static final int SQUARE_HEIGHT = 100;
	private static final int SQUARE_WIDTH = 100;
    private static ArrayList<GroceryItem> groceryItems;
	private static String[] names = {"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter", "Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes", "Macaroni", "Apples", "Null", "Peanuts", "Milk", "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant", "Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}
    
	private static void openImage() {
		if(items==null) {
			try {
				File f = new File("images/grocery.jpeg");
				items = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
        }
    }
	protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
		openImage();
		return ((BufferedImage)items).getSubimage(x,y,w,h).getScaledInstance(SQUARE_WIDTH, SQUARE_HEIGHT, BufferedImage.SCALE_SMOOTH);
	}
	public void makeGroceryList(){
		int widthCount = SQUARE_WIDTH;
		int heightCount = SQUARE_HEIGHT;
		for(int x = 0; x<names.length; x++){
			groceryItems.add(new GroceryItem(openImageFromSpriteSheet(widthCount, heightCount, SQUARE_WIDTH, SQUARE_HEIGHT), names[x]));
			if(groceryItems.get(x).getName().equals("Null")){
				groceryItems.remove(x);
		}
		
		}
	}
}

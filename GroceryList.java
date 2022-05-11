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
	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, {"Macaroni", "Apples", "Null", "Peanuts", "Milk"},{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}};
    
	public ArrayList<GroceryItem> getItems(){
		return groceryItems;
	}

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
		int count = 0;
		for(int x = 0; x<names.length; x++){
			for(int y = 0; y<names[0].length; y++){
				groceryItems.add(new GroceryItem(names[x][y]));
				if(groceryItems.get(count).getName().equals("Null")){
					groceryItems.remove(count);
				}
				count++;
			}
		}
	}
}
